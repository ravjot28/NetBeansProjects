package com.mammothsoftware.animation;

import MainFrame.Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
        static JFrame frame;
	
	public static void main(String[] args)
        {
		frame = new JFrame("R App");
                frame.setUndecorated(true);
                Toolkit kit = Toolkit.getDefaultToolkit();
                Dimension d = kit.getScreenSize();
                
		frame.setLocation(d.height/3,d.width/12);
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

        public void close()
    {
            frame.dispose();
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

        class Animation extends JPanel {
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
                                try
                                {
                                    new Thread().sleep(1000);
                                }catch(Exception sad){}
                                 frame.dispose();
                                new Main().Main1();

			}
		}

	}

}


}
