/**
 * Copyright 2005 Mammoth Software LLC
 * Author: M. Bangham
 */


import java.awt.Graphics2D;
import java.awt.Image;

/**
 * @author michael
 *
 */
public class ProjectileSprite implements ISprite {
	private static int t = 0;
	private double vX0 = 0;
	private double vY0 = 0;
	private static double a = 0;
	// initial pos
	private int x0;
	private int y0;
	private int theta0;
	// height of the frame
	private int height;
	// the projectile image
	private Image image;
	
	public ProjectileSprite(Image image, int x0, int y0, int theta0, double vX0, double vY0, int height) {
		this.image = image;
		this.x0 = x0;
		this.y0 = y0;
		this.vX0 = vX0;
		this.vY0 = vY0;
		this.theta0 = theta0;
		this.height = height;
	}
	
	public void paint(Graphics2D g2) {
		paintImage(g2);
	}
	
	private void paintImage(Graphics2D g2) {
		g2.drawImage(image, xScreenCoords(), yScreenCoords(), null);
	}

	public static void setTime(int time) {
		t = time;
	}
	
	public static void setAccel(double accel) {
		a = accel;
	}
	
	public int getX() {
		int x = (int)(vX0 * t + x0);
		return x;
	}

	public int getY() {
		return (int)(a*Math.pow(t, 2) + vY0 * t + y0);
	}
	
	public int theta() {
		return theta0;
	}
	
	private int xScreenCoords() {
		return getX();
	}
	
	private int yScreenCoords() {
		return height - getY();
	}
	
}
