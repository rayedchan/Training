package recursion;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FactorialTest 
{
    private static Factorial instance; // Class variable to be reused
    
    public FactorialTest() 
    {
    }
    
    /*
     * This method is called once. It is very useful to
     * create database connection object here rather than
     * constantly creating database connection object for every tests.
     */
    @BeforeClass
    public static void setUpClass() 
    {          
        System.out.println("Executing setUpClass()");
        instance = new Factorial();
    }
    
    /*
     * Gets called at the very end after all tests have been ran.
     */
    @AfterClass
    public static void tearDownClass() 
    {
        System.out.println("Executing tearDownClass()");
    }
    
    /*
     * Gets called at the beginning of each test.
     */
    @Before
    public void setUp() 
    {
        
    }
    
    /*
     * Gets called at the end of each test.
     */
    @After
    public void tearDown() 
    {
        
    }

    /**
     * Case 1: Positive value
     */
    @Test
    public void testRecursiveFactorial() 
    {
        System.out.println("recursiveFactorial");
        int n = 5;
        int expResult = 120;
        int result = instance.recursiveFactorial(n);
        assertEquals(expResult, result);
    }
    
    /*
     * Case 2: Negative number
     */
    @Test(expected=IllegalArgumentException.class)
    public void testRecursiveFactorial2() 
    {
        System.out.println("recursiveFactorial");
        int n = -1;
        instance.recursiveFactorial(n);
    }
      
    /**
     * Case 3: base case zero
     */
    @Test
    public void testRecursiveFactorial3() 
    {
        System.out.println("recursiveFactorial");
        int n = 0;
        int expResult = 1;
        int result = instance.recursiveFactorial(n);
        assertEquals(expResult, result);
    }
      
    /*
     * Case 4: Large number
     */
    @Test(expected=IllegalArgumentException.class)
    public void testRecursiveFactorial4() 
    {
        System.out.println("recursiveFactorial");
        int n = 200;
        instance.recursiveFactorial(n);
    }
    
        
    /**
     * Case 1: Positive value
     */
    @Test
    public void testIterativeFactorial() 
    {
        System.out.println("iterativeFactorial");
        int n = 3;
        int expResult = 6;
        int result = instance.recursiveFactorial(n);
        assertEquals(expResult, result);
    }
    
    /*
     * Case 2: Negative number
     */
    @Test(expected=IllegalArgumentException.class)
    public void testIterativeFactorial2() 
    {
        System.out.println("iterativeFactorial");
        int n = -5;
        instance.recursiveFactorial(n);
    }
      
    /**
     * Case 3: base case zero
     */
    @Test
    public void testiterativeFactorial3() 
    {
        System.out.println("iterativeFactorial");
        int n = 0;
        int expResult = 1;
        int result = instance.iterativeFactorial(n);
        assertEquals(expResult, result);
    }
      
    /*
     * Case 4: Large number
     */
    @Test(expected=IllegalArgumentException.class)
    public void testiterativeFactorial4() 
    {
        System.out.println("iterativeFactorial");
        int n = 17;
        instance.iterativeFactorial(n);
    } 
}
