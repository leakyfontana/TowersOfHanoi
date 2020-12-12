package towerofhanoi;

import java.util.Observable;
/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and 
 * integrity at all times. I will not lie, cheat, or 
 * steal, nor will I accept the actions of those who do.
 * -- Xander Dyer (xdyer)
 * 
 * Provides methods to utilize towers and disks to set
 * up and solve the Towers of Hanoi problem.
 * 
 * @author Xander Dyer (xdyer)
 * @version 2020.07.31
 *
 */
public class HanoiSolver extends Observable {
    
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;
    
    /**
     * Constructor for the Hanoi problem solver. 
     * Creates three towers ans sets the field for
     * number of disks.
     * 
     * @param numDisks the number of disks in the 
     * problem.
     */
    public HanoiSolver(int numDisks)
    {
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }
    
    /**
     * Getter method for the number of disks in 
     * the problem.
     * 
     * @return the number of disks
     */
    public int disks()
    {
        return this.numDisks;
    }
    
    /**
     * Getter method for a tower at a given position.
     * 
     * @param pos The given position of a tower
     * @return The tower at said position
     */
    public Tower getTower(Position pos)
    {
        switch (pos)
        {
            case LEFT:
                return left;
            case RIGHT:
                return right;
            case MIDDLE:
                return middle;
            default:
                return middle;
        }
    }
    
    /**
     * Returns the contents of each tower in the form
     * of a string, from left right to left.
     * 
     * @return A string of all contents
     */
    public String toString()
    {
        StringBuilder contents = new StringBuilder("");
        contents.append(left.toString());
        contents.append(middle.toString());
        contents.append(right.toString());
        return contents.toString();
    }
    /**
     * Moves a disk from one tower to another.
     * @param source the originating tower
     * @param destination the final tower
     */
    private void move(Tower source, Tower destination)
    {
        Disk diskMove = source.pop(); 
        destination.push(diskMove);
        this.setChanged();
        this.notifyObservers(destination.position());
    }
    
    /**
     * Provides the solution for the Towers of Hanoi problem
     * by establishing recursion and a base case of 1 disk.
     * 
     * @param currentDisks the number of disks left to move
     * @param startPole the pole that starts with all the disks
     * @param tempPole pole used to move disks
     * @param endPole final spot for all disks
     */
    private void solveTowers(int currentDisks, Tower startPole, 
        Tower tempPole, Tower endPole)
    {
        if (currentDisks == 1)
        {
            this.move(startPole, endPole);
        }
        else
        {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            this.move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }
    
    /**
     * Implements the solveTowers mmethod with the right pole
     * being the startPole, the middle pole being the tempPole
     * and the left pole being the endPole. 
     */
    public void solve()
    {
        this.solveTowers(numDisks, right, middle, left);
    }


}
