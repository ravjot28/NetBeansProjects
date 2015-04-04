package createdemogivingapp;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import javax.swing.JComponent;

public class Main
{
    public void MoveMouse(JComponent start,JComponent end,final int duration) throws AWTException
    {
        final Robot robot = new Robot();

        final Point start_coords = start.getLocationOnScreen();
        start_coords.translate(start.getWidth()/2,start.getHeight()/2);

        final Point end_coords = end.getLocationOnScreen();
        end_coords.translate(end.getWidth()/2,end.getWidth()/2);

        int steps = duration/50;

        int distx = (end_coords.x - start_coords.x);
        int disty = (end_coords.y - start_coords.y);

        for(int i=1;i<=steps;i++)
        {
            int x = start_coords.x + i*distx/steps;
            int y = start_coords.y + i*disty/steps;
            robot.mouseMove(x, y);
            try
            {
                Thread.currentThread().sleep(50);
            }catch(Exception ae){}
        }
    }
}
