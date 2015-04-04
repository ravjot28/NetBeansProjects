package splotlight;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;

public class SpotlightDemo extends JFrame
{
    private SpotlightPanel glassPane;
    private JComponent[] books;

    public SpotlightDemo()
    {
      super("Spotlight Demo");

      glassPane = new SpotlightPanel(true);
      this.setGlassPane(glassPane);

        Container c = new GradientPanel();
        setContentPane(c);
      c.setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel(new BorderLayout());
        HeaderPanel header = new HeaderPanel();
        headerPanel.add(BorderLayout.NORTH, header);
        headerPanel.add(BorderLayout.SOUTH, new JSeparator(JSeparator.HORIZONTAL));
        c.add(BorderLayout.NORTH, headerPanel);

        JPanel booksPanel = new GradientPanel();
        booksPanel.setOpaque(false);
        booksPanel.setLayout(new GridLayout(4, 3));
        booksPanel.setBorder(new EmptyBorder(6, 0, 0, 0));
        createBooks(booksPanel);
        c.add(BorderLayout.CENTER, booksPanel);

        JPanel searchPanel = new JPanel();
        searchPanel.setOpaque(false);
        JLabel label = new JLabel("Search for books:");
        searchPanel.add(label);
        JTextField searchField = new JTextField(12);
        searchField.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                String text = ((JTextField) evt.getSource()).getText();
                if (text.equals("1"))
                    one();//createSciFiSpots();
                else if (text.equals("2"))
                    two();//createSpotsForAll();
                else if (text.equals("3"))
                    three();//createPratchettSpots();
                else if (text.equals("4"))
                    four();//createAdamsSpots();
                else if (text.equals("5"))
                    five();//createPratchettSpots();
                else if (text.equals("6"))
                    six();//createAdamsSpots();
                else if (text.equals("7"))
                    seven();//createSpotsForAll();
                else if (text.equals("8"))
                    eight();//createPratchettSpots();
                else if (text.equals("9"))
                    nine();//createAdamsSpots();
                else if (text.equals("10"))
                    ten();//createPratchettSpots();
                else if (text.equals("11"))
                    eleven();//createAdamsSpots();
                else if (text.equals("12"))
                    twelve();//createAdamsSpots();
            }
        });
        searchPanel.add(searchField);
        c.add(BorderLayout.SOUTH, searchPanel);

        pack();
        //setResizable(false);
      setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void one()
    {
        glassPane.clearSpotlights();
        addSpotForBook(0);
        //this.setGlassPane(glassPane);
    }

    private void two()
    {
        glassPane.clearSpotlights();
        addSpotForBook(1);
    }

    private void three()
    {
        glassPane.clearSpotlights();
        addSpotForBook(2);
    }

    private void four()
    {
        glassPane.clearSpotlights();
        addSpotForBook(3);
    }

    private void five()
    {
        glassPane.clearSpotlights();
        addSpotForBook(4);
    }

    private void six()
    {
        glassPane.clearSpotlights();
        addSpotForBook(5);
    }

    private void seven()
    {
        glassPane.clearSpotlights();
        addSpotForBook(6);
        //this.setGlassPane(glassPane);
    }

    private void eight()
    {
        glassPane.clearSpotlights();
        addSpotForBook(7);
    }

    private void nine()
    {
        glassPane.clearSpotlights();
        addSpotForBook(8);
    }

    private void ten()
    {
        glassPane.clearSpotlights();
        addSpotForBook(9);
    }

    private void eleven()
    {
        glassPane.clearSpotlights();
        addSpotForBook(10);
    }

    private void twelve()
    {
        glassPane.clearSpotlights();
        addSpotForBook(11);
    }
/*
    /*private void createSpotsForAll()
    {
        for (int i = 0; i < 6; i++)
        {
            addSpotForBook(i);
        }
    }

    private void createSciFiSpots()
    {
        addSpotForBook(0);
        /*for (int i = 5; i < 6; i++)
        {
            addSpotForBook(i);
        }*/
    //}

    /*private void createAdamsSpots()
    {
        for (int i = 3; i < 6; i++)
        {
            addSpotForBook(i);
        }
    }

    private void createPratchettSpots()
    {
        addSpotForBook(2);
    }
*/
    private void addSpotForBook(int i)
    {
        Point p = new Point(books[i].getLocation());
        SwingUtilities.convertPointToScreen(p, books[i].getParent());
        SwingUtilities.convertPointFromScreen(p, glassPane);
        glassPane.addSpotlight(p.x - 4, p.y - 4,102,102);// 96, 152);
    }

    private void createBooks(JPanel container)
    {
        books = new JComponent[12];
        for (int i = 0; i < books.length; i++)
        {
            JPanel buttonPanel = new JPanel();
            buttonPanel.setOpaque(false);
         //buttonPanel.add(books[i] = new JLabel("", "cover" + (i + 1) + "_small_button"));
            buttonPanel.add(books[i] = new JLabel(new ImageIcon("r.png")));
            container.add(buttonPanel);
        }
    }

    private static class GradientPanel extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            if (!isOpaque())
            {
                return;
            }

            int width  = getWidth();
            int height = getHeight();

            Graphics2D g2 = (Graphics2D) g;

            Paint storedPaint = g2.getPaint();
            g2.setPaint(new GradientPaint(0, 0, Color.WHITE, width, height, new Color(200, 200, 200)));
            g2.fillRect(0, 0, width, height);
            g2.setPaint(storedPaint);
        }
    }

    public static void main(String[] args)
    {
        SpotlightDemo demo = new SpotlightDemo();
        demo.setVisible(true);
    }
}