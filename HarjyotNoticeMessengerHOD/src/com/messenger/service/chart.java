package com.messenger.service;

/*    */ import java.awt.Dimension;
/*    */ import org.jfree.chart.ChartFactory;
/*    */ import org.jfree.chart.ChartPanel;
/*    */ import org.jfree.chart.JFreeChart;
/*    */ import org.jfree.chart.plot.PiePlot3D;
/*    */ import org.jfree.data.general.DefaultPieDataset;
/*    */ import org.jfree.data.general.PieDataset;
/*    */ import org.jfree.ui.ApplicationFrame;
/*    */ import org.jfree.util.Rotation;
/*    */ 
/*    */ public class chart extends ApplicationFrame
/*    */ {
/*    */   public chart(String title, int a, int b)
/*    */   {
/* 15 */     super(title);
/*    */ 
/* 19 */     DefaultPieDataset dataset = new DefaultPieDataset();
/* 20 */     dataset.setValue("Yes", new Integer(a));
/* 21 */     dataset.setValue("No", new Integer(b));
/*    */ 
/* 24 */     JFreeChart chart = createChart(dataset);
/*    */ 
/* 27 */     ChartPanel chartPanel = new ChartPanel(chart);
/* 28 */     chartPanel.setPreferredSize(new Dimension(500, 270));
/* 29 */     setContentPane(chartPanel);
/*    */   }
/*    */ 
/*    */   private JFreeChart createChart(PieDataset dataset)
/*    */   {
/* 35 */     JFreeChart chart = ChartFactory.createPieChart3D("Survey Result", dataset, true, true, false);
/*    */ 
/* 43 */     PiePlot3D plot = (PiePlot3D)chart.getPlot();
/* 44 */     plot.setStartAngle(290.0D);
/* 45 */     plot.setDirection(Rotation.CLOCKWISE);
/* 46 */     plot.setForegroundAlpha(0.5F);
/* 47 */     plot.setNoDataMessage("No data to display");
/* 48 */     return chart;
/*    */   }
/*    */ }

/* Location:           D:\Harjyot Project\Notice Messenger\HOD\Messenger.jar
 * Qualified Name:     chart
 * JD-Core Version:    0.6.2
 */