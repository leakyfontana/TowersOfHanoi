/**
 * 
 */
package towerofhanoi;

/**
 * Contains main method that runs the project
 * @author Xander Dyer (scdrake19)
 * @version 2020.03.25
 *
 */
public class ProjectRunner 
{
    /**
     * Main Method, runs the project
     * @param args 
     */
    public static void main(String[] args)
    {
        int disks = 5;
        if (args.length == 1)
        {
            disks = Integer.parseInt(args[0]);
        }
        
        HanoiSolver h = new HanoiSolver(disks);
        PuzzleWindow p = new PuzzleWindow(h);
    }
}
