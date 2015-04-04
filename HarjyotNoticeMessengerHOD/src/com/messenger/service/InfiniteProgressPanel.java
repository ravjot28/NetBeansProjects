package com.messenger.service;

/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.font.FontRenderContext;
/*     */ import java.awt.font.TextLayout;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Area;
/*     */ import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import javax.swing.JComponent;
/*     */ 
/*     */ public class InfiniteProgressPanel extends JComponent
/*     */   implements MouseListener
/*     */ {
/*  19 */   protected Area[] ticker = null;
/*  20 */   protected Thread animation = null;
/*  21 */   protected boolean started = false;
/*  22 */   protected int alphaLevel = 0;
/*  23 */   protected int rampDelay = 300;
/*  24 */   protected float shield = 0.7F;
/*  25 */   protected String text = "";
/*  26 */   protected int barsCount = 14;
/*  27 */   protected float fps = 15.0F;
/*     */ 
/*  29 */   protected RenderingHints hints = null;
/*     */ 
/*     */   public InfiniteProgressPanel()
/*     */   {
/*  33 */     this("");
/*     */   }
/*     */ 
/*     */   public InfiniteProgressPanel(String text)
/*     */   {
/*  38 */     this(text, 14);
/*     */   }
/*     */ 
/*     */   public InfiniteProgressPanel(String text, int barsCount)
/*     */   {
/*  43 */     this(text, barsCount, 0.7F);
/*     */   }
/*     */ 
/*     */   public InfiniteProgressPanel(String text, int barsCount, float shield)
/*     */   {
/*  48 */     this(text, barsCount, shield, 15.0F);
/*     */   }
/*     */ 
/*     */   public InfiniteProgressPanel(String text, int barsCount, float shield, float fps)
/*     */   {
/*  53 */     this(text, barsCount, shield, fps, 300);
/*     */   }
/*     */ 
/*     */   public InfiniteProgressPanel(String text, int barsCount, float shield, float fps, int rampDelay)
/*     */   {
/*  58 */     this.text = text;
/*  59 */     this.rampDelay = (rampDelay >= 0 ? rampDelay : 0);
/*  60 */     this.shield = (shield >= 0.0F ? shield : 0.0F);
/*  61 */     this.fps = (fps > 0.0F ? fps : 15.0F);
/*  62 */     this.barsCount = (barsCount > 0 ? barsCount : 14);
/*     */ 
/*  64 */     this.hints = new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
/*  65 */     this.hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*  66 */     this.hints.put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
/*     */   }
/*     */ 
/*     */   public void setText(String text)
/*     */   {
/*  71 */     repaint();
/*  72 */     this.text = text;
/*     */   }
/*     */ 
/*     */   public String getText()
/*     */   {
/*  77 */     return this.text;
/*     */   }
/*     */ 
/*     */   public void start()
/*     */   {
/*  82 */     addMouseListener(this);
/*  83 */     setVisible(true);
/*  84 */     this.ticker = buildTicker();
/*  85 */     this.animation = new Thread(new InfiniteProgressPanel.Animator(true));
/*  86 */     this.animation.start();
/*     */   }
/*     */ 
/*     */   public void stop()
/*     */   {
/*  91 */     if (this.animation != null) {
/*  92 */       this.animation.interrupt();
/*  93 */       this.animation = null;
/*  94 */       this.animation = new Thread(new InfiniteProgressPanel.Animator(false));
/*  95 */       this.animation.start();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void interrupt()
/*     */   {
/* 101 */     if (this.animation != null) {
/* 102 */       this.animation.interrupt();
/* 103 */       this.animation = null;
/*     */ 
/* 105 */       removeMouseListener(this);
/* 106 */       setVisible(false);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void paintComponent(Graphics g)
/*     */   {
/* 112 */     if (this.started)
/*     */     {
/* 114 */       int width = getWidth();
/* 115 */       int height = getHeight();
/*     */ 
/* 117 */       double maxY = 0.0D;
/*     */ 
/* 119 */       Graphics2D g2 = (Graphics2D)g;
/* 120 */       g2.setRenderingHints(this.hints);
/*     */ 
/* 122 */       g2.setColor(new Color(255, 255, 255, (int)(this.alphaLevel * this.shield)));
/* 123 */       g2.fillRect(0, 0, getWidth(), getHeight());
/*     */ 
/* 125 */       for (int i = 0; i < this.ticker.length; i++)
/*     */       {
/* 127 */         int channel = 224 - 128 / (i + 1);
/* 128 */         g2.setColor(new Color(channel, channel, channel, this.alphaLevel));
/* 129 */         g2.fill(this.ticker[i]);
/*     */ 
/* 131 */         Rectangle2D bounds = this.ticker[i].getBounds2D();
/* 132 */         if (bounds.getMaxY() > maxY) {
/* 133 */           maxY = bounds.getMaxY();
/*     */         }
/*     */       }
/* 136 */       if ((this.text != null) && (this.text.length() > 0))
/*     */       {
/* 138 */         FontRenderContext context = g2.getFontRenderContext();
/* 139 */         TextLayout layout = new TextLayout(this.text, getFont(), context);
/* 140 */         Rectangle2D bounds = layout.getBounds();
/* 141 */         g2.setColor(getForeground());
/* 142 */         layout.draw(g2, (float)(width - bounds.getWidth()) / 2.0F, (float)(maxY + layout.getLeading() + 2.0F * layout.getAscent()));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private Area[] buildTicker()
/*     */   {
/* 150 */     Area[] ticker = new Area[this.barsCount];
/* 151 */     Point2D.Double center = new Point2D.Double(getWidth() / 2.0D, getHeight() / 2.0D);
/* 152 */     double fixedAngle = 6.283185307179586D / this.barsCount;
/*     */ 
/* 154 */     for (double i = 0.0D; i < this.barsCount; i += 1.0D)
/*     */     {
/* 156 */       Area primitive = buildPrimitive();
/*     */ 
/* 158 */       AffineTransform toCenter = AffineTransform.getTranslateInstance(center.getX(), center.getY());
/* 159 */       AffineTransform toBorder = AffineTransform.getTranslateInstance(45.0D, -6.0D);
/* 160 */       AffineTransform toCircle = AffineTransform.getRotateInstance(-i * fixedAngle, center.getX(), center.getY());
/*     */ 
/* 162 */       AffineTransform toWheel = new AffineTransform();
/* 163 */       toWheel.concatenate(toCenter);
/* 164 */       toWheel.concatenate(toBorder);
/*     */ 
/* 166 */       primitive.transform(toWheel);
/* 167 */       primitive.transform(toCircle);
/*     */ 
/* 169 */       ticker[((int)i)] = primitive;
/*     */     }
/*     */ 
/* 172 */     return ticker;
/*     */   }
/*     */ 
/*     */   private Area buildPrimitive()
/*     */   {
/* 177 */     Rectangle2D.Double body = new Rectangle2D.Double(6.0D, 0.0D, 30.0D, 12.0D);
/* 178 */     Ellipse2D.Double head = new Ellipse2D.Double(0.0D, 0.0D, 12.0D, 12.0D);
/* 179 */     Ellipse2D.Double tail = new Ellipse2D.Double(30.0D, 0.0D, 12.0D, 12.0D);
/*     */ 
/* 181 */     Area tick = new Area(body);
/* 182 */     tick.add(new Area(head));
/* 183 */     tick.add(new Area(tail));
/*     */ 
/* 185 */     return tick; } 
/*     */   public void mouseClicked(MouseEvent e) {  } 
/*     */   public void mousePressed(MouseEvent e) {  } 
/*     */   public void mouseReleased(MouseEvent e) {  } 
/*     */   public void mouseEntered(MouseEvent e) {  } 
/*     */   public void mouseExited(MouseEvent e) {  } 
/* 190 */   protected class Animator implements Runnable { private boolean rampUp = true;
/*     */ 
/*     */     protected Animator(boolean rampUp)
/*     */     {
/* 194 */       this.rampUp = rampUp;
/*     */     }
/*     */ 
/*     */     public void run()
/*     */     {
/* 199 */       Point2D.Double center = new Point2D.Double(InfiniteProgressPanel.this.getWidth() / 2.0D, InfiniteProgressPanel.this.getHeight() / 2.0D);
/* 200 */       double fixedIncrement = 6.283185307179586D / InfiniteProgressPanel.this.barsCount;
/* 201 */       AffineTransform toCircle = AffineTransform.getRotateInstance(fixedIncrement, center.getX(), center.getY());
/*     */ 
/* 203 */       long start = System.currentTimeMillis();
/* 204 */       if (InfiniteProgressPanel.this.rampDelay == 0) {
/* 205 */         InfiniteProgressPanel.this.alphaLevel = (this.rampUp ? 255 : 0);
/*     */       }
/* 207 */       InfiniteProgressPanel.this.started = true;
/* 208 */       boolean inRamp = this.rampUp;
/*     */ 
/* 210 */       while (!Thread.interrupted())
/*     */       {
/* 212 */         if (!inRamp)
/*     */         {
/* 214 */           for (int i = 0; i < InfiniteProgressPanel.this.ticker.length; i++) {
/* 215 */             InfiniteProgressPanel.this.ticker[i].transform(toCircle);
/*     */           }
/*     */         }
/* 218 */         InfiniteProgressPanel.this.repaint();
/*     */ 
/* 220 */         if (this.rampUp)
/*     */         {
/* 222 */           if (InfiniteProgressPanel.this.alphaLevel < 255)
/*     */           {
/* 224 */             InfiniteProgressPanel.this.alphaLevel = ((int)(255L * (System.currentTimeMillis() - start) / InfiniteProgressPanel.this.rampDelay));
/* 225 */             if (InfiniteProgressPanel.this.alphaLevel >= 255)
/*     */             {
/* 227 */               InfiniteProgressPanel.this.alphaLevel = 255;
/* 228 */               inRamp = false;
/*     */             }
/*     */           }
/* 231 */         } else if (InfiniteProgressPanel.this.alphaLevel > 0) {
/* 232 */           InfiniteProgressPanel.this.alphaLevel = ((int)(255L - 255L * (System.currentTimeMillis() - start) / InfiniteProgressPanel.this.rampDelay));
/* 233 */           if (InfiniteProgressPanel.this.alphaLevel <= 0)
/*     */           {
/* 235 */             InfiniteProgressPanel.this.alphaLevel = 0;
/* 236 */             break;
/*     */           }
/*     */         }
/*     */ 
/*     */         try
/*     */         {
/* 242 */           Thread.sleep(inRamp ? 10L : (int)(1000.0F / InfiniteProgressPanel.this.fps));
/*     */         } catch (InterruptedException ie) {
/* 244 */           break;
/*     */         }
/* 246 */         Thread.yield();
/*     */       }
/*     */ 
/* 249 */       if (!this.rampUp)
/*     */       {
/* 251 */         InfiniteProgressPanel.this.started = false;
/* 252 */         InfiniteProgressPanel.this.repaint();
/*     */ 
/* 254 */         InfiniteProgressPanel.this.setVisible(false);
/* 255 */         InfiniteProgressPanel.this.removeMouseListener(InfiniteProgressPanel.this);
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           D:\Harjyot Project\Notice Messenger\HOD\Messenger.jar
 * Qualified Name:     InfiniteProgressPanel
 * JD-Core Version:    0.6.2
 */