package recursion;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FactorialTest 
{
    public FactorialTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
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
        int result = Factorial.recursiveFactorial(n);
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
        Factorial.recursiveFactorial(n);
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
        int result = Factorial.recursiveFactorial(n);
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
        Factorial.recursiveFactorial(n);
    }
}
