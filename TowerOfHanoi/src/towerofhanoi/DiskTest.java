package towerofhanoi;

/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and 
 * integrity at all times. I will not lie, cheat, or 
 * steal, nor will I accept the actions of those who do.
 * -- Xander Dyer (xdyer)
 * 
 * Tests the methods provided in the Disk class.
 * 
 * @author Xander Dyer (xdyer)
 * @version 2020.07.31
 *
 */
public class DiskTest extends student.TestCase {
    
    private Disk test;
    private Disk comp;
    
    /**
     * Sets up testing conditions
     */
    public void setUp()
    {
        test = new Disk(3);
    }
    
    /**
     * Tests the compareTo method by checking the 
     * IllegalArgumentException and testing each 
     * possible return value.
     */
    public void testCompareTo()
    {
        comp = new Disk(4);
        assertEquals(-1, test.compareTo(comp));
        comp = new Disk(2);
        assertEquals(1, test.compareTo(comp));
        comp = new Disk(3);
        assertEquals(0, test.compareTo(comp));
        
        Disk nullDisk = null;
        Exception exception = null;
        try {
            test.compareTo(nullDisk);
        }
        catch (IllegalArgumentException e) {
            exception = e;
        }
        assertNotNull(exception);
    }
    
    /**
     * Tests the toString method by checking the
     * string that is returned from a disk object.
     */
    public void testToString()
    {
        assertEquals("3", test.toString());
    }
    
    /**
     * Tests the equals method by having the 
     * disk check itself, then providing a null
     * check, then comparing with another object
     * type and lastly testing disk objects that are
     * the same and different.
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals()
    {
        assertTrue(test.equals(test));
        Disk nullDisk = null;
        assertFalse(test.equals(nullDisk));
        String string = "test";
        assertFalse(test.equals(string));
        comp = new Disk(4);
        assertFalse(test.equals(comp));
        comp = new Disk(3);
        assertTrue(test.equals(comp));
    }

}
