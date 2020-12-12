package towerofhanoi;

import java.util.EmptyStackException;

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
public class LinkedStackTest extends student.TestCase {
    
    private LinkedStack<String> test;
    private String entry;
    
    /**
     * Sets up testing conditions
     */
    public void setUp()
    {
        test = new LinkedStack<String>();
        entry = "disk";
    }
    
    /**
     * Tests the push method by asserting size
     * and contents after pushing a string.
     */
    public void testPush()
    {
        assertTrue(test.isEmpty());
        test.push(entry);
        assertEquals(1, test.size());
        assertFalse(test.isEmpty());
        assertEquals("disk", test.peek());
    }
    
    /**
     * Tests the size method by asserting size 
     * after pushing a string.
     */
    public void testSize()
    {
        assertEquals(0, test.size());
        test.push(entry);
        assertEquals(1, test.size());
    }
    
    /**
     * Tests to string by asserting contents of
     * Linked Stack after pushing several strings.
     */
    public void testToString()
    {
        test.push(entry);
        String entry2 = "click";
        String entry3 = "rick";
        test.push(entry2);
        test.push(entry3);
        assertEquals("[rick, click, disk]", test.toString());
    }
    
    /**
     * Tests the isEmpty method by asserting true and
     * false when empty and not empty.
     */
    public void testIsEmpty()
    {
        assertTrue(test.isEmpty());
        test.push(entry);
        assertEquals(1, test.size());
        assertFalse(test.isEmpty());
    }
    
    /**
     * Tests clear by clearing a full Linked Stack
     * and asserting empty.
     */
    public void testClear()
    {
        test.push(entry);
        String entry2 = "click";
        String entry3 = "rick";
        test.push(entry2);
        test.push(entry3);
        assertEquals(3, test.size());
        test.clear();
        assertTrue(test.isEmpty());
        assertEquals(0, test.size()); 
    }
    
    /**
     * Tests the peek method by checking the 
     * EmptyStackException and then checking 
     * return value from peeking on a full Linked
     * Stack.
     */
    public void testPeek()
    {
        Exception exception = null;
        try {
            test.peek();
        }
        catch (EmptyStackException e) {
            exception = e;
        }
        assertNotNull(exception);
        
        test.push(entry);
        String entry2 = "click";
        String entry3 = "rick";
        test.push(entry2);
        test.push(entry3);
        assertEquals("rick", test.peek());
    }
    
    /**
     * Tests the pop method by checking the 
     * EmptyStackException and then checking size
     * and returned contents using pop.
     */
    public void testPop()
    {
        Exception exception = null;
        try {
            test.peek();
        }
        catch (EmptyStackException e) {
            exception = e;
        }
        assertNotNull(exception);
        
        test.push(entry);
        String entry2 = "click";
        String entry3 = "rick";
        test.push(entry2);
        test.push(entry3);
        assertEquals("rick", test.pop());
        assertEquals(2, test.size()); 
        assertEquals("click", test.pop());
        assertEquals(1, test.size());
    }

}
