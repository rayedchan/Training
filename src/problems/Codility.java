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
        //System.out.println("start");
        //System.out.println(Integer.valueOf("05"));
        int cost;
        
        //cost = phoneBill("00:05:01,123-456-7890\n00:05:00,980-678-1234\n00:06:07,123-456-7890");
        //cost = phoneBill("");
        //cost = phoneBill("01:05:01,123-456-7890");
        //cost = phoneBill("99:05:01,123-456-7890\n00:00:70,980-678-1234\n00:06:07,123-456-7890\n00:00:01,980-678-1234");
        //cost = phoneBill("99:99:99,123-456-7890\n99:99:99,980-678-1234\n99:99:99,123-456-7890\n99:99:99,980-678-1234\n99:99:99,123-456-7890\n99:99:99,980-678-1234\n99:99:99,123-456-7890\n99:99:99,980-678-1234\n99:99:99,123-456-7890\n99:99:99,980-678-1234\n99:99:99,123-456-7890\n99:99:99,980-678-1234\n99:99:99,123-456-7890\n99:99:99,980-678-1234\n99:99:99,123-456-7890\n99:99:99,980-678-1234\n99:99:99,123-456-7890\n99:99:99,980-678-1234\n99:99:99,123-456-7890\n99:99:99,980-678-1234\n99:99:99,123-456-7890\n99:99:99,980-678-1234\n99:99:99,123-456-7890\n99:99:99,980-678-1234\n99:99:99,123-456-7890\n99:99:99,980-678-1234\n99:99:99,123-456-7890\n99:99:99,980-678-1234\n99:99:99,123-456-7890\n99:99:99,980-678-1234\n99:99:99,123-456-7890\n99:99:99,980-678-1234\n99:99:99,123-456-7890\n99:99:99,980-678-1234\n99:99:99,123-456-7890\n99:99:99,980-678-1234\n99:99:99,123-456-7890\n99:99:99,980-678-1234\n99:99:99,123-456-7890\n99:99:99,980-678-1234");
        //cost = phoneBill(null);
        cost = phoneBill("00:05:01,123-456-7890\n00:05:00,980-678-1234\n00:00:07,123-456-7898");
        System.out.println(cost);
        
        
        
    }
    
    /**
     * Calculate phone bill
     * Rules:
     * 1. Cost is 150 cents per minute if phone number greater than or equal 5 minutes (Rounded up)
     * 2. Cost is 3 cents per second if phone number is under 5 minutes 
     * 3. Exclude phone number with the max cost
     * @param bill String delimited 
     * Duration,Phone
     * HH:MM:SS,NNN-NNN-NNNN
     * E.g. 00:05:01,123-456-7890\n00:05:00,980-678-1234\n00:06:07,123-456-7890
     * @return number of cents to pay
     */
    public static int phoneBill(String bill)
    {
        if(bill == null || bill.equalsIgnoreCase(""))
        {
            return 0;
        }
        
        int total = 0;
        HashMap<String,Integer> uniquePhones = new HashMap<String,Integer>();
        String[] entries = bill.split("\n");
        int maxPrice = 0;
        
        for(String entry: entries)
        {
            String[] tokens = entry.split(",");
            
            String duration = tokens[0];
            String[] time = duration.split(":");
            int hours = Integer.valueOf(time[0]);
            int mins = Integer.valueOf(time[1]);
            int secs = Integer.valueOf(time[2]);
            int totalSecs = hours * 60 * 60 + mins * 60 + secs;
            
            String phoneNum = tokens[1];
            
            if(uniquePhones.containsKey(phoneNum))
            {
                int combineSecs = uniquePhones.get(phoneNum) + totalSecs;
                uniquePhones.put(phoneNum, combineSecs );
            }
            
            else
            {
                uniquePhones.put(phoneNum, totalSecs);
            }
        }
        
        System.out.println(uniquePhones);
        
        for(Map.Entry<String,Integer> phoneRec: uniquePhones.entrySet())
        {
            int secs = phoneRec.getValue();
            int price = 0;
            
            if(secs < 300)
            {
                price = secs * 3;
            }
            
            else
            {
                price = ((secs / 60) + (secs % 60 == 0? 0 : 1)) * 150;
            }
            
            if(price > maxPrice)
            {
                maxPrice = price;
            }
            
            total = total + price;
        }
        
        total = total - maxPrice;
        return total;        
    }

    // https://codility.com/demo/results/training5WP9GW-Z8U/
    // Efficient Solution: Use XOR since same element cancel each other out resulting in the lonely number 
    public static int OddOccurrencesInArray(int[] A) 
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
    public static int[] cyclicRotation(int[] A, int K)
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
