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
        /*     */ implements MouseListener /*     */ {
    /*  21 */ protected Area[] ticker = null;
    /*  22 */ protected Thread animation = null;
    /*  23 */ protected boolean started = false;
    /*  24 */ protected int alphaLevel = 0;
    /*  25 */ protected int rampDelay = 300;
    /*  26 */ protected float shield = 0.7F;
    /*  27 */ protected String text = "";
    /*  28 */ protected int barsCount = 14;
    /*  29 */ protected float fps = 15.0F;
    /*     */
    /*  31 */ protected RenderingHints hints = null;
    /*     */
    /*     */ public InfiniteProgressPanel() /*     */ {
        /*  35 */ this("");
        /*     */    }
    /*     */
    /*     */ public InfiniteProgressPanel(String text) /*     */ {
        /*  40 */ this(text, 14);
        /*     */    }
    /*     */
    /*     */ public InfiniteProgressPanel(String text, int barsCount) /*     */ {
        /*  45 */ this(text, barsCount, 0.7F);
        /*     */    }
    /*     */
    /*     */ public InfiniteProgressPanel(String text, int barsCount, float shield) /*     */ {
        /*  50 */ this(text, barsCount, shield, 15.0F);
        /*     */    }
    /*     */
    /*     */ public InfiniteProgressPanel(String text, int barsCount, float shield, float fps) /*     */ {
        /*  55 */ this(text, barsCount, shield, fps, 300);
        /*     */    }
    /*     */
    /*     */ public InfiniteProgressPanel(String text, int barsCount, float shield, float fps, int rampDelay) /*     */ {
        /*  60 */ this.text = text;
        /*  61 */ this.rampDelay = (rampDelay >= 0 ? rampDelay : 0);
        /*  62 */ this.shield = (shield >= 0.0F ? shield : 0.0F);
        /*  63 */ this.fps = (fps > 0.0F ? fps : 15.0F);
        /*  64 */ this.barsCount = (barsCount > 0 ? barsCount : 14);
        /*     */
        /*  66 */ this.hints = new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        /*  67 */ this.hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        /*  68 */ this.hints.put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        /*     */    }
    /*     */
    /*     */ public void setText(String text) /*     */ {
        /*  73 */ repaint();
        /*  74 */ this.text = text;
        /*     */    }
    /*     */
    /*     */ public String getText() /*     */ {
        /*  79 */ return this.text;
        /*     */    }
    /*     */
    /*     */ public void start() /*     */ {
        /*  84 */ addMouseListener(this);
        /*  85 */ setVisible(true);
        /*  86 */ this.ticker = buildTicker();
        /*  87 */ this.animation = new Thread(new InfiniteProgressPanel.Animator(true));
        /*  88 */ this.animation.start();
        /*     */    }
    /*     */
    /*     */ public void stop() /*     */ {
        /*  93 */ if (this.animation != null) {
            /*  94 */ this.animation.interrupt();
            /*  95 */ this.animation = null;
            /*  96 */ this.animation = new Thread(new InfiniteProgressPanel.Animator(false));
            /*  97 */ this.animation.start();
            /*     */        }
        /*     */    }
    /*     */
    /*     */ public void interrupt() /*     */ {
        /* 103 */ if (this.animation != null) {
            /* 104 */ this.animation.interrupt();
            /* 105 */ this.animation = null;
            /*     */
            /* 107 */ removeMouseListener(this);
            /* 108 */ setVisible(false);
            /*     */        }
        /*     */    }
    /*     */
    /*     */ public void paintComponent(Graphics g) /*     */ {
        /* 114 */ if (this.started) /*     */ {
            /* 116 */ int width = getWidth();
            /* 117 */ int height = getHeight();
            /*     */
            /* 119 */ double maxY = 0.0D;
            /*     */
            /* 121 */ Graphics2D g2 = (Graphics2D) g;
            /* 122 */ g2.setRenderingHints(this.hints);
            /*     */
            /* 124 */ g2.setColor(new Color(255, 255, 255, (int) (this.alphaLevel * this.shield)));
            /* 125 */ g2.fillRect(0, 0, getWidth(), getHeight());
            /*     */
            /* 127 */ for (int i = 0; i < this.ticker.length; i++) /*     */ {
                /* 129 */ int channel = 224 - 128 / (i + 1);
                /* 130 */ g2.setColor(new Color(channel, channel, channel, this.alphaLevel));
                /* 131 */ g2.fill(this.ticker[i]);
                /*     */
                /* 133 */ Rectangle2D bounds = this.ticker[i].getBounds2D();
                /* 134 */ if (bounds.getMaxY() > maxY) {
                    /* 135 */ maxY = bounds.getMaxY();
                    /*     */                }
                /*     */            }
            /* 138 */ if ((this.text != null) && (this.text.length() > 0)) /*     */ {
                /* 140 */ FontRenderContext context = g2.getFontRenderContext();
                /* 141 */ TextLayout layout = new TextLayout(this.text, getFont(), context);
                /* 142 */ Rectangle2D bounds = layout.getBounds();
                /* 143 */ g2.setColor(getForeground());
                /* 144 */ layout.draw(g2, (float) (width - bounds.getWidth()) / 2.0F, (float) (maxY + layout.getLeading() + 2.0F * layout.getAscent()));
                /*     */            }
            /*     */        }
        /*     */    }
    /*     */
    /*     */ private Area[] buildTicker() /*     */ {
        /* 152 */ Area[] ticker = new Area[this.barsCount];
        /* 153 */ Point2D.Double center = new Point2D.Double(getWidth() / 2.0D, getHeight() / 2.0D);
        /* 154 */ double fixedAngle = 6.283185307179586D / this.barsCount;
        /*     */
        /* 156 */ for (double i = 0.0D; i < this.barsCount; i += 1.0D) /*     */ {
            /* 158 */ Area primitive = buildPrimitive();
            /*     */
            /* 160 */ AffineTransform toCenter = AffineTransform.getTranslateInstance(center.getX(), center.getY());
            /* 161 */ AffineTransform toBorder = AffineTransform.getTranslateInstance(45.0D, -6.0D);
            /* 162 */ AffineTransform toCircle = AffineTransform.getRotateInstance(-i * fixedAngle, center.getX(), center.getY());
            /*     */
            /* 164 */ AffineTransform toWheel = new AffineTransform();
            /* 165 */ toWheel.concatenate(toCenter);
            /* 166 */ toWheel.concatenate(toBorder);
            /*     */
            /* 168 */ primitive.transform(toWheel);
            /* 169 */ primitive.transform(toCircle);
            /*     */
            /* 171 */ ticker[((int) i)] = primitive;
            /*     */        }
        /*     */
        /* 174 */ return ticker;
        /*     */    }
    /*     */
    /*     */ private Area buildPrimitive() /*     */ {
        /* 179 */ Rectangle2D.Double body = new Rectangle2D.Double(6.0D, 0.0D, 30.0D, 12.0D);
        /* 180 */ Ellipse2D.Double head = new Ellipse2D.Double(0.0D, 0.0D, 12.0D, 12.0D);
        /* 181 */ Ellipse2D.Double tail = new Ellipse2D.Double(30.0D, 0.0D, 12.0D, 12.0D);
        /*     */
        /* 183 */ Area tick = new Area(body);
        /* 184 */ tick.add(new Area(head));
        /* 185 */ tick.add(new Area(tail));
        /*     */
        /* 187 */ return tick;
    }
    /*     */ public void mouseClicked(MouseEvent e) {
    }
    /*     */ public void mousePressed(MouseEvent e) {
    }
    /*     */ public void mouseReleased(MouseEvent e) {
    }
    /*     */ public void mouseEntered(MouseEvent e) {
    }
    /*     */ public void mouseExited(MouseEvent e) {
    }
    /* 192 */ protected class Animator implements Runnable {

        private boolean rampUp = true;
        /*     */
        /*     */ protected Animator(boolean rampUp) /*     */ {
            /* 196 */ this.rampUp = rampUp;
            /*     */        }
        /*     */
        /*     */ public void run() /*     */ {
            /* 201 */ Point2D.Double center = new Point2D.Double(InfiniteProgressPanel.this.getWidth() / 2.0D, InfiniteProgressPanel.this.getHeight() / 2.0D);
            /* 202 */ double fixedIncrement = 6.283185307179586D / InfiniteProgressPanel.this.barsCount;
            /* 203 */ AffineTransform toCircle = AffineTransform.getRotateInstance(fixedIncrement, center.getX(), center.getY());
            /*     */
            /* 205 */ long start = System.currentTimeMillis();
            /* 206 */ if (InfiniteProgressPanel.this.rampDelay == 0) {
                /* 207 */ InfiniteProgressPanel.this.alphaLevel = (this.rampUp ? 255 : 0);
                /*     */            }
            /* 209 */ InfiniteProgressPanel.this.started = true;
            /* 210 */ boolean inRamp = this.rampUp;
            /*     */
            /* 212 */ while (!Thread.interrupted()) /*     */ {
                /* 214 */ if (!inRamp) /*     */ {
                    /* 216 */ for (int i = 0; i < InfiniteProgressPanel.this.ticker.length; i++) {
                        /* 217 */ InfiniteProgressPanel.this.ticker[i].transform(toCircle);
                        /*     */                    }
                    /*     */                }
                /* 220 */ InfiniteProgressPanel.this.repaint();
                /*     */
                /* 222 */ if (this.rampUp) /*     */ {
                    /* 224 */ if (InfiniteProgressPanel.this.alphaLevel < 255) /*     */ {
                        /* 226 */ InfiniteProgressPanel.this.alphaLevel = ((int) (255L * (System.currentTimeMillis() - start) / InfiniteProgressPanel.this.rampDelay));
                        /* 227 */ if (InfiniteProgressPanel.this.alphaLevel >= 255) /*     */ {
                            /* 229 */ InfiniteProgressPanel.this.alphaLevel = 255;
                            /* 230 */ inRamp = false;
                            /*     */                        }
                        /*     */                    }
                    /* 233 */                } else if (InfiniteProgressPanel.this.alphaLevel > 0) {
                    /* 234 */ InfiniteProgressPanel.this.alphaLevel = ((int) (255L - 255L * (System.currentTimeMillis() - start) / InfiniteProgressPanel.this.rampDelay));
                    /* 235 */ if (InfiniteProgressPanel.this.alphaLevel <= 0) /*     */ {
                        /* 237 */ InfiniteProgressPanel.this.alphaLevel = 0;
                        /* 238 */ break;
                        /*     */                    }
                    /*     */                }
                /*     */
                /*     */ try /*     */ {
                    /* 244 */ Thread.sleep(inRamp ? 10L : (int) (1000.0F / InfiniteProgressPanel.this.fps));
                    /*     */                } catch (InterruptedException ie) {
                    /* 246 */ break;
                    /*     */                }
                /* 248 */ Thread.yield();
                /*     */            }
            /*     */
            /* 251 */ if (!this.rampUp) /*     */ {
                /* 253 */ InfiniteProgressPanel.this.started = false;
                /* 254 */ InfiniteProgressPanel.this.repaint();
                /*     */
                /* 256 */ InfiniteProgressPanel.this.setVisible(false);
                /* 257 */ InfiniteProgressPanel.this.removeMouseListener(InfiniteProgressPanel.this);
                /*     */            }
            /*     */        }
        /*     */    }
    /*     */ }
