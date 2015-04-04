package splashscreen;

import java.awt.*;
import javax.swing.*;

public class SplashScreen extends JWindow {

    private int duration;

    public SplashScreen(int d) {
        duration = d;
    }

    // A simple little method to show a title screen in the center
    // of the screen for the amount of time given in the constructor
    public void showSplash() {

        JPanel content = (JPanel)getContentPane();
        content.setBackground(Color.white);

        // Set the window's bounds, centering the window
        int width = 450;
        int height =115;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);

        // Build the splash screen
        JLabel label = new JLabel(new ImageIcon("javaTips.gif"));
        JLabel copyrt = new JLabel
                ("Copyright 2002, O'Reilly & Associates", JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        Color oraRed = new Color(156, 20, 20,  255);
        content.setBorder(BorderFactory.createLineBorder(oraRed, 10));

        // Display it
        setVisible(true);

        // Wait a little while, maybe while loading resources
        try { Thread.sleep(duration); } catch (Exception e) {}

        setVisible(false);

    }

    public void showSplashAndExit() {

        showSplash();
        System.exit(0);

    }

    public static void main(String[] args) {

        // Throw a nice little title page up on the screen first
        SplashScreen splash = new SplashScreen(10000);

        // Normally, we'd call splash.showSplash() and get on
        // with the program. But, since this is only a test...
        splash.showSplashAndExit();

    }
}
