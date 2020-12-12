package towerofhanoi;

/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and 
 * integrity at all times. I will not lie, cheat, or 
 * steal, nor will I accept the actions of those who do.
 * -- Xander Dyer (xdyer)
 * 
 * Extends the Linked Stack and provides methods for 
 * Towers to be utilized in program solution.
 * 
 * @author Xander Dyer (xdyer)
 * @version 2020.07.31
 *
 */
public class Tower extends LinkedStack<Disk> {
    
    private Position position;
    
    /**
     * Constructor for a Tower
     * @param pos position of tower
     */
    public Tower(Position pos)
    {
        super();
        this.position = pos;
    }
    
    /**
     * Getter method for the position of a tower
     * @return position
     */
    public Position position()
    {
        return this.position;
    }
    
    /**
     * Overrides the push method so that only disks
     * smaller in width may be pushed onto existing 
     * disks.
     * 
     * @param disk to be compared
     */
    @Override
    public void push(Disk disk)
    {
        if (disk == null)
        {
            throw new IllegalArgumentException("disk is null");
        }
        else if (this.isEmpty() || this.peek().compareTo(disk) == 1)
        {
            super.push(disk);
        }
        else 
        {
            throw new IllegalStateException();
        }
    }

}
