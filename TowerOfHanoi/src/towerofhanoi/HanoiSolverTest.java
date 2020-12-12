package towerofhanoi;

/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and 
 * integrity at all times. I will not lie, cheat, or 
 * steal, nor will I accept the actions of those who do.
 * -- Xander Dyer (xdyer)
 * 
 * Tests the methods provided in the HanoiSolver class.
 * 
 * @author Xander Dyer (xdyer)
 * @version 2020.07.31
 *
 */
public class HanoiSolverTest extends student.TestCase {
    
    private HanoiSolver test;
    private Tower ltow;
    private Tower mtow;
    private Tower rtow;
    
    /**
     * Sets up testing conditions
     */
    public void setUp()
    {
        test = new HanoiSolver(5);
        ltow = test.getTower(Position.LEFT);
        mtow = test.getTower(Position.MIDDLE);
        rtow = test.getTower(Position.RIGHT);
    }
    
    /**
     * Tests the getTower method by asserting that the
     * method utilized to initialize the test towers
     * is replicated.
     */
    public void testGetTower()
    {

        assertEquals(ltow, test.getTower(Position.LEFT));
        assertEquals(mtow, test.getTower(Position.MIDDLE));
        assertEquals(rtow, test.getTower(Position.RIGHT));
        assertEquals(mtow, test.getTower(Position.DEFAULT));
    }
    
    /**
     * Tests the toString method by adding disks to a
     * multiple towers and asserting that the correct
     * contents is printed in the correct order.
     */
    public void testToString()
    {
        Disk entry = new Disk(1);
        Disk entry2 = new Disk(2);
        Disk entry3 = new Disk(3);
        Disk entry4 = new Disk(4);
        Disk entry5 = new Disk(5);
        test.getTower(Position.LEFT).push(entry5);
        test.getTower(Position.LEFT).push(entry4);
        test.getTower(Position.MIDDLE).push(entry3);
        test.getTower(Position.RIGHT).push(entry2);
        test.getTower(Position.RIGHT).push(entry);
        assertEquals("[4, 5][3][1, 2]", test.toString());
    }
    
    /**
     * Tests the disks method by asserting that the 
     * correct number of disks is returned.
     */
    public void testDisks()
    {
        assertEquals(5, test.disks());
    }
    
    /**
     * Tests the solve method by running a solve method
     * for a HanoiProblem with 5 disks.
     */
    public void testSolve()
    {
        Disk entry = new Disk(1);
        Disk entry2 = new Disk(2);
        Disk entry3 = new Disk(3);
        Disk entry4 = new Disk(4);
        Disk entry5 = new Disk(5);
        test.getTower(Position.RIGHT).push(entry5);
        test.getTower(Position.RIGHT).push(entry4);
        test.getTower(Position.RIGHT).push(entry3);
        test.getTower(Position.RIGHT).push(entry2);
        test.getTower(Position.RIGHT).push(entry);
        assertEquals(5, test.getTower(Position.RIGHT).size());
        test.solve();
    }

}
