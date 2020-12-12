package towerofhanoi;

import CS2114.Shape;
//import student.TestableRandom;
import java.awt.Color;

/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and 
 * integrity at all times. I will not lie, cheat, or 
 * steal, nor will I accept the actions of those who do.
 * -- Xander Dyer (xdyer)
 * 
 * Provides a constructor and method for comaprable 
 * disk objects.
 * 
 * @author Xander Dyer (xdyer)
 * @version 2020.07.31
 *
 */
public class Disk extends Shape implements Comparable<Disk> {
    
    //private TestableRandom randomGenerator;
    
    /**
     * Constructor for Disk.
     * @param width of Disk.
     */
    public Disk(int width)
    {
        super(0, 0, width, 30);
        Color color = new Color(255, 255, 255);
        setBackgroundColor(color);
    }
    
    /**
     * Compares a disk's width to another disk's width.
     * 
     * @param otherDisk disk to be compared
     * @return -1 if otherdisk's width is larger, 1 if this
     * disk's width is larger and zero if they are the same.
     */
    public int compareTo(Disk otherDisk)
    {
        if (otherDisk == null)
        {
            throw new IllegalArgumentException("disk is null");
        }
        if (this.getWidth() < otherDisk.getWidth())
        {
            return -1;
        }
        if (this.getWidth() > otherDisk.getWidth())
        {
            return 1;
        }
        return 0;
    }
    /**
     * Turns a disk's width into a String
     * @return String containing width
     */
    public String toString()
    {
        int width = this.getWidth();
        return String.valueOf(width);
    }
    
    /**
     * Checks to see if an object is a disk and  or
     * not its width is equal to this disk.
     * 
     * @param obj object to be compared
     * 
     *  @return true if widths are the same, false if 
     *  not or the object is not a disk.
     */
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if ((obj == null) || (obj.getClass()
            != Disk.class)) {
            return false;
        }
        return (this.getWidth() == ((Disk)obj).getWidth());
    }
}

