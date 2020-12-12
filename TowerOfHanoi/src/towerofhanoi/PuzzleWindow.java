/**
 * 
 */
package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * Class that handles the front end (physical illustration)
 * of the project
 * 
 * @author Xander Dyer
 * @version 2020.03.25
 *
 */
public class PuzzleWindow implements Observer 
{

    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Window window;
    public static final int DISK_HEIGHT = 20;
    public static final int DISK_GAP = 10;
    public static final int WIDTH_FACTOR = 20;
    
 // ~ Constructor ...........................................................
    /**
     * new PuzzleWindow Object
     *
     * @param h, the Hanoi solver to 
     * be illustrated
     */
    public PuzzleWindow(HanoiSolver h)
    {
        game = h;
        game.addObserver(this);
        window = new Window("Tower Of Hanoi");
        left = new Shape( (int) ( (double)
            window.getGraphPanelWidth() * (0.25)),
            window.getGraphPanelHeight()/2 - 30, 10, 150);
        
        middle = new Shape( (int) ( (double)
            window.getGraphPanelWidth() * (0.5)),
            window.getGraphPanelHeight()/2 - 30, 10, 150);
        
        right = new Shape((int)((double)
            window.getGraphPanelWidth() * (0.75)),
            window.getGraphPanelHeight()/2 - 30, 10, 150);
        
        
        for (int i = game.disks(); i > 0 ; i--)
        {
             Disk temp = new Disk(20 * i);
             int R = (int)(Math.random()*256);
             int G = (int)(Math.random()*256);
             int B= (int)(Math.random()*256);
             Color color = new Color(R, G, B); 
             Random random = new Random();
             final float hue = random.nextFloat();
             final float saturation = 0.9f;
             final float luminance = 1.0f; 
             color = Color.getHSBColor(hue, saturation, luminance);
             temp.setBackgroundColor(color);
             temp.setForegroundColor(Color.LIGHT_GRAY);
             window.addShape(temp);
             game.getTower(Position.RIGHT).push(temp);
             moveDisk(Position.RIGHT);
        }
        
        window.addShape(right);
        window.addShape(middle);
        window.addShape(left);
        
        Button but = new Button("Solve");
        but.onClick(this, "clickedSolve");  
        window.addButton(but, WindowSide.SOUTH);
        
        
    }

    /**
     * Pauses thread between disk movements so
     * they can be seen
     *
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * Supports solve button so the back end is
     * run concurrently to front end
     *
     * @param button to be pushed to activate the
     * method
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }
    
    /**
     * Moves a disk on the front end
     * that has already been moved on the back end
     * to its current position
     *
     * @param position that the previously
     * moved disk currently resides on
     */
    private void moveDisk(Position position)
    {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole = null;
        if (position == Position.LEFT)
        {
            currentPole = left;
        }
        else if (position == Position.RIGHT)
        {
            currentPole = right;
        }
        else
        {
            currentPole = middle;
        }
        
        currentDisk.moveTo(currentPole.getX() - 
            (((game.disks() - game.getTower(position).size())
                * WIDTH_FACTOR/2)),
            (currentPole.getY() + 150) - game.getTower(position).size()
            * DISK_HEIGHT);
    }
    
    /**
     * Notified by back end class that a change
     * has been made
     *
     * @param o the class that is being observed
     * @param arg the Position the disk is being moved to
     */
    @Override
    public void update(Observable o, Object arg)
    {
        if (arg.getClass().equals(Position.class))
        {
            Position p = (Position) arg;
            moveDisk(p);
            sleep();
        }
    }

}

