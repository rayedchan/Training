package recursion;

public class Factorial 
{
    public static void main(String[] args)
    {
        int result = recursiveFactorial(5);
        System.out.println(result);
    }
    
    /**
     * Recursively computes the factorial of a nonnegative integer.
     * @param   n   Nth factorial to compute 
     * @throws  IllegalArgumentException
     */
    public static int recursiveFactorial(int n) throws IllegalArgumentException
    {
        // Negative number case
        if (n < 0)
        {
            throw new IllegalArgumentException("Argument cannot be negative.");
        }
        
        // Large number case due to int storage limitations
        else if(n > 16)
        {
            throw new IllegalArgumentException("Argument cannot exceed 16.");
        }
        
        // Base case: 0! = 1
        else if (n == 0)
        {
            return 1;
        }
        
        // n > 0  
        else
        {
            return n * recursiveFactorial(n - 1);
        }
    }  
}
