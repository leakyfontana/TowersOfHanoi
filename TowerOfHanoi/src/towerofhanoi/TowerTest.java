package towerofhanoi;

/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and 
 * integrity at all times. I will not lie, cheat, or 
 * steal, nor will I accept the actions of those who do.
 * -- Xander Dyer (xdyer)
 * 
 * Tests the methods provided in the LinkedStack class.
 * 
 * @author Xander Dyer (xdyer)
 * @version 2020.07.31
 *
 */
public class TowerTest extends student.TestCase {
    
    private Tower test;
    private Disk entry;
    
    /**
     * Sets up testing conditions
     */
    public void setUp()
    {
        test = new Tower(Position.DEFAULT);
        entry = new Disk(3);
    }
    /**
     * Tests position method by asserting the
     * correct position is returned.
     */
    public void testPosition()
    {
        assertEquals(Position.DEFAULT, test.position());
    }
    
    /**
     * Tests the new push method by performing 
     * exception checks, and asserting the disks
     * in compliance can be added.
     */
    public void testPush()
    {
        Disk nullDisk = null;
        Exception exception = null;
        try {
            test.push(nullDisk);
        }
        catch (IllegalArgumentException e) {
            exception = e;
        }
        assertNotNull(exception);
        
        assertTrue(test.isEmpty());
        test.push(entry);
        assertEquals(1, test.size());
        assertFalse(test.isEmpty());
        entry = new Disk(2);
        test.push(entry);
        assertEquals(2, test.size());
        entry = new Disk(4);
        
        Exception exception2 = null;
        try {
            test.push(entry);
        }
        catch (IllegalStateException e) {
            exception2 = e;
        }
        assertNotNull(exception2);
    }

}
