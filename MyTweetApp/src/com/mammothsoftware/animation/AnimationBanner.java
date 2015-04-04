package com.mammothsoftware.animation;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

public class AnimationBanner {
	// setup and tuning parameters...
	// frame size
	private static int WIDTH = 700;
	private static int HEIGHT = 500;
	// duration of the simulation in ms (default 1 sec)
	private static final int SIM_LEN = 1000;
	// the update frequency in Millisec
	private static final int DELAY = 20;
	// acceleration parameter
	private static final double ACCEL = -0.0005;
	// name of the file containing the slogan
	private static final String SLOGAN_FILE = "slogan.gif";
	// number of chars in the slogan file
	private static final int NUM_SLOGAN_CHARS = 20;
	// name of company logo file
	private static final String LOGO_FILE = "logo.gif";
	// name of trademark file
	private static final String TRADEMARK_FILE = "tm.gif";
	
	// location of the final text string
	private static Point origin = new Point();
	private static Animation animation;
	private static Image sloganImage;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Animation");
		frame.setLocation(100,100);
		frame.setSize(WIDTH, HEIGHT);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		AnimationBanner banner = new AnimationBanner();
		
		frame.setContentPane(banner.getAnimation());
		
		frame.setVisible(true);
		
		initAnimation(animation);
		
		banner.getAnimation().start();

	}
	
	public AnimationBanner() {
		animation = new Animation(DELAY, SIM_LEN, LOGO_FILE);

		// rerun the animation on a mouse click
		animation.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				animation.clearSprites();
				initAnimation(animation);
				animation.start();
			}
		});
		
		sloganImage = animation.getSpriteImage(SLOGAN_FILE);

		ProjectileSprite.setAccel(ACCEL);

	}
	
	public Animation getAnimation() {
		return animation;
	}
	
	public void startAnimation() {
		animation.start();
	}
	
	public void initialize() {
		initAnimation(animation);
	}
	/**
	 * Get the individual sprite images, constructed from the main slogan file
	 * @param animation
	 */
	private static void initAnimation(Animation animation) {
		// adjust width and height to parent frame size
		if (animation.getParent() != null) {
			WIDTH = animation.getParent().getWidth();
			HEIGHT = animation.getParent().getHeight();
		}

		// origin in screen coords
		origin.x = WIDTH/2 - sloganImage.getWidth(null)/2;
		origin.y = (int)(HEIGHT * 0.75);
		
		// chop up the slogan image to get a char for each sprite
		SpriteImage[] spriteImages = createSpriteImages(sloganImage, NUM_SLOGAN_CHARS);
		for (SpriteImage spriteImage : spriteImages) {
			ProjectileSprite sprite = new ProjectileSprite(spriteImage.image, spriteImage.x0, spriteImage.y0, 0, spriteImage.vX0, spriteImage.vY0, HEIGHT);
			animation.addSprite(sprite);
		}
		
		// add the tm sprite adjusting to a raised position
		origin.x = origin.x + sloganImage.getWidth(null) - 10;
		Image tmImage = animation.getSpriteImage(TRADEMARK_FILE);
		spriteImages = createSpriteImages(tmImage, 1);
		for (SpriteImage spriteImage : spriteImages) {
			ProjectileSprite sprite = new ProjectileSprite(spriteImage.image, spriteImage.x0, spriteImage.y0, 0, spriteImage.vX0, spriteImage.vY0, HEIGHT);
			animation.addSprite(sprite);
		}
	}
	
	/**
	 * A little helper class to bundle up info about the sprite
	 */
	private static class SpriteImage {
		public Image image;
		public int x0;
		public int y0;
		public int xF;
		public int yF;
		public double vX0;
		public double vY0;
	}
	
	/**
	 * Chop up the slogan image and create the individual sprites
	 * @param baseImage The base image for the slogan
	 * @param n The number of chars in the slogan
	 * @return An array of classes containing info about each sprite
	 */
	private static SpriteImage[] createSpriteImages(Image baseImage, int n) {
		n = n == 0 ? 1 : n;
		
		SpriteImage[] spriteImages = new SpriteImage[n];
		
		int h = baseImage.getHeight(null);
		int w = baseImage.getWidth(null)/n;
		
		Random rand = new Random(System.currentTimeMillis());
		
		// number of sprites along top edge
		int top = rand.nextInt(n);
		// number of remaining sprites at x= 0
		int left = rand.nextInt(n - top);
		
		// collection of sprites to pull from randomly
		List<SpriteImage> sprites = new ArrayList<SpriteImage>();
		
		// first pass to set the final positions
		for (int i = 0; i < n; i++) {
			spriteImages[i] = new SpriteImage();
			
			BufferedImage image = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
			Graphics2D g2 = image.createGraphics();
			g2.translate(-(w * i), 0);
			g2.drawImage(baseImage, 0, 0, null);
			g2.translate((w * i), 0);
			
			spriteImages[i].image = image;
			// final pos in projectile coords
			int xF = origin.x + w * i;
			int yF = HEIGHT - origin.y;
			
			spriteImages[i].xF = xF;
			spriteImages[i].yF = yF;
			
			sprites.add(spriteImages[i]);
			
		}
		
		// second pass to randomly set the initial positions
		for (int i = 0; i < n; i++) {
			// grab a random sprite
			int size = sprites.size();
			SpriteImage spriteImage = null;
			if (size != 1) {
				int j = rand.nextInt(size - 1);
				spriteImage = sprites.remove(j);
			}
			else {
				spriteImage = sprites.get(0);
			}

			
			int y0 = 0; int x0 = 0;
			// initial pos in projectile coords
			if (i < top) {
				y0 = HEIGHT + 30;
				x0 = rand.nextInt(WIDTH);
			}
			else {
				y0 = HEIGHT - rand.nextInt(HEIGHT);
				if (i - top < left) {
					x0 = 0;
				}
				else {
					x0 = WIDTH;
				}
			}
			
			double vX0 = (double)(spriteImage.xF - x0)/SIM_LEN;

			double vY0 = (double)(spriteImage.yF - y0 - ACCEL * Math.pow(SIM_LEN, 2.0))/SIM_LEN;
			
			spriteImage.x0 = x0;
			spriteImage.y0 = y0;
			spriteImage.vX0 = vX0;
			spriteImage.vY0 = vY0;
						
		}
		
		return spriteImages;
	}

}
