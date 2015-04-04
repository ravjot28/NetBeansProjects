/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestingGUI;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ImageButtonV2 extends JButton{

	private static final long serialVersionUID = -2864903417434547174L;

	private BufferedImage upImage;
	private BufferedImage downImage;
	private BufferedImage behind;

	private Color preferredColor;
	private boolean usePreferredColor;
	private boolean doRedrawBackground;
	private boolean needsNewBehind;

	public ImageButtonV2(){
		this.setBorderPainted(false);
		setUsePreferredColor(true);
		setDoBackgroundRedraw(false);
	}

	public void setUpImage(File upFile, boolean generatedDownImage){
		try {
			upImage = ImageIO.read(upFile);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Invalid File Or Location", "Error Reading File", JOptionPane.ERROR_MESSAGE);
		}

		if(generatedDownImage)
			downImage = grayScale(upImage);
	}

	public void setUpImage(File upFile){
		setUpImage(upFile, false);
	}

	public void setDownImage(File downFile){
		try {
			downImage = ImageIO.read(downFile);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Invalid File Or Location", "Error Reading File", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void setPreferredColor(Color color){preferredColor = color;}

	public void setUsePreferredColor(boolean use){
	if(doRedrawBackground == true && use == true){
		setDoBackgroundRedraw(false);
	}
	usePreferredColor = use;
	}

	public void setDoBackgroundRedraw(boolean doRedraw){
		if(doRedrawBackground == true && doRedraw == true){
			setUsePreferredColor(false);
		}
		doRedrawBackground = doRedraw;
	}

	public void setSize(int width, int height){
		super.setSize(width, height);
		needsNewBehind = true;
	}

	public void setSize(Dimension d){
		super.setSize(d);
		needsNewBehind = true;
	}

	public void setLocation(int x, int y){
		super.setLocation(x, y);
		needsNewBehind = true;
	}

	public BufferedImage getUpImage(){return upImage;}

	public BufferedImage getDownImage(){return downImage;}

	private void createBehind(){
		if(!needsNewBehind)
			return;

		this.setIgnoreRepaint(true);
		this.getRootPane().repaint();
		try {
			Robot robot = new Robot();
			behind = robot.createScreenCapture(this.getBounds());
			needsNewBehind = false;
		} catch (AWTException e) {}
		this.setIgnoreRepaint(false);
		this.getRootPane().repaint();
	}

	public static BufferedImage grayScale(BufferedImage im) {
		BufferedImage grayImage = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_INT_ARGB);

	     for(int x = 0; x < im.getWidth(); x++)
	          for(int y = 0; y < im.getHeight(); y++){
	               int argb = im.getRGB(x,y);

	               int a = (argb >> 24) & 0xff;
	               int r = (argb >> 16) & 0xff;
	               int g = (argb >>  8) & 0xff;
	               int b = (argb      ) & 0xff;

	               int l= (int) (.299 * r + .587 * g + .114 * b); //luminance

	               grayImage.setRGB(x,y, (a << 24) + (l << 16) + (l << 8) + l);
	         }
	     return grayImage;
	}

	protected void paintComponent(Graphics g){
		//super.paintComponent(g);

		int endX, beginX, endY, beginY;

		int w = getSize().width;
		int h = getSize().height;

		// get the smaller of the two
		int min = w > h ? w : h;

		beginX = (w - min) / 2;
		endX = beginX + min;

		beginY = (h - min) / 2;
		endY = beginY + min;

		if(model.isPressed() && model.isEnabled()){
			if((downImage.getTransparency() == BufferedImage.BITMASK || downImage.getTransparency() == BufferedImage.TRANSLUCENT) && usePreferredColor){
				if(doRedrawBackground){
					createBehind(); // Gets the Background Image if Needed
					paintBehind(g, beginX, beginY, endX, endY); //Paints The Background Image between Artifacts
				}
				if(usePreferredColor)
					paintColorBackground(g, beginX, beginY, endX, endY);
			}
			g.drawImage(downImage, beginX, beginY, endX - beginX, endY - beginY, null);
		}else{
			if((upImage.getTransparency() == BufferedImage.BITMASK || upImage.getTransparency() == BufferedImage.TRANSLUCENT) && usePreferredColor){
				if(doRedrawBackground){
					createBehind();
					paintBehind(g, beginX, beginY, endX, endY);
				}
				if(usePreferredColor)
					paintColorBackground(g, beginX, beginY, endX, endY);
			}
			g.drawImage(upImage, beginX, beginY, endX - beginX, endY - beginY, null);
		}
	}

	public void paintBehind(Graphics g, int beginX, int beginY, int endX, int endY){
		g.drawImage(behind, beginX, beginY, endX - beginX, endY - beginY, null);
	}

	public void paintColorBackground(Graphics g, int beginX, int beginY, int endX, int endY){
		Color cache = g.getColor();
		g.setColor(preferredColor);
		g.fillRect(beginX, beginY, endX - beginX, endY - beginY);
		g.setColor(cache);
	}

	public static void main(String[] args){
		JFrame frame = new JFrame("Testing V2 ImageButton");
		ImageButtonV2 button = new ImageButtonV2();
		ImageButtonV2 button2 = new ImageButtonV2();
		button.setPreferredColor(Color.blue);
		button.setUpImage(new File("Logo2.png"), true);
		button.setDownImage(new File("Sig4.png"));
		button.setUsePreferredColor(true);
		button2.setPreferredColor(Color.red);
		button2.setUpImage(new File("Logo2.png"), true);
		frame.setLayout(new GridLayout());

		frame.add(button, BorderLayout.CENTER);
		frame.add(button2, BorderLayout.SOUTH);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ActionListener foo = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button Pressed");
			}

		};

		button.addActionListener(foo);
		button2.addActionListener(foo);

		frame.setVisible(true);
	}
}
