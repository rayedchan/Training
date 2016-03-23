package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rayedchan
 */
public class Codility 
{
    public static void main(String[] args)
    {
        //binaryGap(2147483647);
        
    }
    
    // https://codility.com/demo/results/training5WP9GW-Z8U/
    // Efficient Solution: Use XOR since same element cancel each other out resulting in the lonely number 
    public int OddOccurrencesInArray(int[] A) 
    {
        // write your code in Java SE 8
        HashMap<Integer,Integer> count = new HashMap<Integer, Integer>();
        int size = A.length;
        
        for(int i = 0; i < size; i++)
        {
            int ele = A[i];
            
            if(count.containsKey(ele))
            {
                count.put(ele, count.get(ele) + 1);
            }
            
            else
            {
                 count.put(ele, 1);
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : count.entrySet())
        {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            
            if(value % 2 == 1)
            {
                return key;
            }
        }
        
        return -1;    
    }
    
    // https://codility.com/demo/results/trainingMSC3JY-7GV/
    public int[] cyclicRotation(int[] A, int K)
    {
        // write your code in Java SE 8
                
        int size = A.length;
        
        if(size == 0)
        {
            return A;
        }
        
        int rNum = K % size;
        int[] result = new int[size];
        int start = 0;
        
        if(rNum == 0)
        {
            return A;
        }
        
        for(int i = 0; i < size; i++)
        {
            int sPos = (i + K) % size;
            result[sPos] = A[i];
            
            //int temp = A[i];
            //A[i] = A[K - 1];
            //A[K - 1] = temp;
        }
        
        return result;
    }
    
    // https://codility.com/demo/results/trainingXDQSXF-9Q2/
    public static int binaryGap(int N)
    {
        // write your code in Java SE 8
        String bitStr = Integer.toBinaryString(N);
        System.out.println(bitStr);
        
        char[] bits = bitStr.toCharArray(); 
        int max = 0;
        int cur = 0;
        int size = bits.length;
        
        for(int i = 0; i < size; i++)
        {
            if(bits[i] == '1')
            {
                if(cur > max)
                {
                    max = cur;
                }
                
                cur = 0;
            }
            
            else
            {
                cur++;
            }
        }
        
        return max;
    }
}
