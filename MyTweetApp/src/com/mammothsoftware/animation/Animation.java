package com.mammothsoftware.animation;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class Animation extends JPanel {
	private int time = 0;
	private int duration = 0;
	// main timer thread
	private Timer timer;
	// the panel to draw on
	// the animation objects
	private List<ISprite> sprites = new ArrayList<ISprite>();
	// the animation delay
	private int delay = 0;
	// off screen animation buffer
	private BufferedImage imageBuffer;
	// the graphics correspsonding to the imageBUffer
	private Graphics2D bufferGraphics;
	// start of gradient color
	private Color startColor = getBackground(); //new Color(150, 215, 10);
	// end of gradient color
	private Color endColor = new Color(200, 200, 255); //new Color(100, 200, 0);
	private Image logoImage;
	private int logoX = 0, logoY = 0;
	private int width = 0;
	private int height = 0;
	
	public Animation(int delay, int duration, String logoFile) {
		super(false);
		this.delay = delay;
		this.duration = duration;
		logoImage = getSpriteImage(logoFile);
	}
	
	public void addSprite(ISprite sprite) {
		sprites.add(sprite);
	}
	
	public void clearSprites() {
		sprites.clear();
	}
	
	public void start() {
		time = 0;
		timer = new Timer();
		timer.schedule(new AnimationTask(), 50, delay);
	}
	
	/**
	 * Override
	 */
	public void paintComponent(Graphics g) {
		paintImage((Graphics2D)g);
	}
	
	public int getWidth() {
		return getParent().getWidth();
	}
	
	public int getHeight() {
		return getParent().getHeight();
	}

	private boolean paintBackground(Graphics2D g2) {
		if (g2 == null) return false;
		if (getHeight() <= 0 || getWidth() <= 0) return false;
		
		getBufferGraphics().setPaint(new GradientPaint(0, getHeight(), startColor, getWidth(), getHeight(), endColor));
		getBufferGraphics().fillRect(0, 0, getWidth(), getHeight());
		getBufferGraphics().drawImage(logoImage, logoX, logoY, null);
		return true;
	}
	
	private Graphics2D getBufferGraphics() {
		if (imageBuffer == null || width != getWidth() || height != getHeight()) {
			width = getWidth();
			height = getHeight();
			imageBuffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
			logoX = getWidth()/2 - logoImage.getWidth(null)/2;
			logoY = (int)(getHeight() * 0.25);
			bufferGraphics = imageBuffer.createGraphics();
		}
		return bufferGraphics;
	}
	
	public Image getSpriteImage(String filePath) {
		MediaTracker tracker = new MediaTracker(this);
		URL imageURL = Animation.class.getResource(filePath);
		Image image = Toolkit.getDefaultToolkit().createImage(imageURL);
		tracker.addImage(image, 0);
		try {
			tracker.waitForID(0);
			return image;
		} catch (InterruptedException e) {
			return null;
		}
	}
	
	public void paintImage(Graphics2D g2) {
		if (!paintBackground(g2)) return;
		for (ISprite sprite : sprites) {
			sprite.paint(getBufferGraphics());
		}
		g2.drawImage(imageBuffer, 0, 0, Animation.this);
	}
	
	/**
	 * Main animation task
	 */
	private class AnimationTask extends TimerTask {

		public void run() {
			time += delay;
			ProjectileSprite.setTime(time);
			if (!paintBackground(getBufferGraphics())) return;
			for (ISprite sprite : sprites) {
				sprite.paint(getBufferGraphics());
			}
			getGraphics().drawImage(imageBuffer, 0, 0, Animation.this);
			if (time >= duration) {
				timer.cancel();
			}
		}
		
	}

}
