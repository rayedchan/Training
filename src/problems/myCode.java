import java.io.*;
import java.util.*;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        //System.out.println("Most frequent ngrams");
        //System.out.println(mostFrequentNgram("DANDAN", 2));
        //System.out.println(mostFrequentNgramRetry("DANDAN", 2));
    	
    	//System.out.println(mostFrequentNgramBoundary("DANDAN", 2));
    	//System.out.println(mostFrequentNgramBoundary("DANDAN", 3));
    	//System.out.println(mostFrequentNgramBoundary("ABCDEFAB", 2));
    	
    	System.out.println(mostFrequentNgramOffset("DANDAN", 2));
    	System.out.println(mostFrequentNgramOffset("DANDAN", 3));
    	System.out.println(mostFrequentNgramOffset("ABCDEFAB", 2));
    	System.out.println(mostFrequentNgramOffset("ABCDEFAB", 20));
    	System.out.println(mostFrequentNgramOffset(null, 20));
    	System.out.println(mostFrequentNgramOffset("ABCDEFAB", 8));
    }
    
    /*
    input: DANDAN, n=2
    
    DA - 2
    AN - 2
    ND - 1
    
    returns DA or AN (doesn't matter which)
    */
    
    /**
     * Enumerate all possible N-length subsets of a String using a offset
     * @param input
     * @param n
     * @return
     */
    private static String mostFrequentNgramOffset(String input, int n)
    {
    	// Null case va;idation
    	if(input == null)
    	{
    		return "";
    	}
    		
    	// Stores the results
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        // Initial length of input
        int length = input.length();
        
        // Starting position for grouping
        int offset = 0;
        
        // Continue iteration until offset does not exceed input length
        // or when (n + offset) does not exceed input length
        while(offset < length && ((n + offset) <= length))
        {
        	int startIndex = 0 + offset;
        	int endIndex = n + offset;
        	String key = input.substring(startIndex, endIndex);
        	
        	// First occurrence
            if(map.get(key) == null)
            {
                map.put(key, 1);
            }
            
            // Duplicate Key
            else
            {
                map.put(key, map.get(key) + 1);
            }
            
            offset++; // increase to start at a different initial position
        }

        System.out.println(map);
        
        Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator();
        String maxKey = "";
        int maxCount = 0;
        
        // Find Max Key
        while(it.hasNext())
        {
        	Map.Entry<String,Integer> entry = it.next();
        	String key = entry.getKey();
        	Integer value = entry.getValue();
        	
        	if(value > maxCount)
        	{
        		maxCount = value;
        		maxKey = key;
        	}
        }
        
        return maxKey;
    }
    
    /**
     * Uses boundary checking to enumerate all possible subsets of a String
     * @param input
     * @param n
     * @return
     */
    private static String mostFrequentNgramBoundary(String input, int n)
    {
    	// TODO: Input validation check E.g. Null and n is within length range
    	
    	// Stores the results
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        // Initial length of input
        int length = input.length();
        
        // Flag to continue iterating 
        boolean cIterate = true;
        
        // Boundary checker
        // Key = startIndex 
        // Value = endIndex
        HashMap<Integer, Integer> boundaries = new HashMap<Integer, Integer>(); 
        
        // Starting position for grouping
        int offset = 0;
        
        // Exhaust iteration
        // Check the first subset's boundaries when offset is applied
        // If inspected already, end case
        // else continue
        while(cIterate && length > 0)
        {
	        int remainder = n % length == 0 ? 0 : 1; 
	        int loops = (length / n) + remainder;
	        int startIndex = 0 + offset;
	        int endIndex = n + offset;
	        
	        // Boundary had been visited no need to investigate further 
	        if(boundaries.get(startIndex) != null)
	        {
	        	int value = boundaries.get(startIndex); 
	        	
	        	if(endIndex == value)
	        	{
	        		cIterate = false;
	        	}
	        }
	        
	        // Iterate substring groupings
	        while(loops > 1 && cIterate)
	        {
	            String key = input.substring(startIndex, endIndex);
	            
	            // First occurrence
	            if(map.get(key) == null)
	            {
	                map.put(key, 1);
	            }
	            
	            // Duplicate Key
	            else
	            {
	                map.put(key, map.get(key) + 1);
	            }
	                        
	            boundaries.put(startIndex, endIndex);
	            startIndex = endIndex;
	            endIndex = startIndex + n;
	            loops--;
	        }
	        
	        length--; // decrease due to offset
	        offset++; // increase to start at a different initial position
        }

        System.out.println(map);
        
        Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator();
        String maxKey = "";
        int maxCount = 0;
        
        // Find Max Key
        while(it.hasNext())
        {
        	Map.Entry<String,Integer> entry = it.next();
        	String key = entry.getKey();
        	Integer value = entry.getValue();
        	
        	if(value > maxCount)
        	{
        		maxCount = value;
        		maxKey = key;
        	}
        }
        
        return maxKey;
    }
    
    /**
     * Brute Force (Only works for N = 2 due to lack of permutation code)
     * @param input
     * @param n
     * @return
     */
    private static String mostFrequentNgramRetry(String input, int n)
    {
    	String maxKey = "";
    	int maxOcc = 0;
    	
    	// Results of N-grams
    	Map<String, Integer> nGrams = new HashMap<String, Integer>(); 
    	
        // Convert input into char array
    	char[] inputChars = input.toCharArray();
        
        // Use Set to store all the unique characters
        Set<String> uniqChars = new HashSet<String>();
        
        // Obtain the unique characters
        for(char c : inputChars)
        {
            uniqChars.add(Character.toString(c));
        }
        
        System.out.println(uniqChars);
        
        // Use to store all possible N grams keys
        Set<String> keys = new HashSet<String>();
        
        // Construct a permutation of unique characters and group keys with length N
        for(String ch : uniqChars)
        {
        	// Construct N-grams using the current character
        	// For N = 2
        	// TODO: Generalize this to N
        	for(String ch2: uniqChars)
        	{
        		String key = ch + ch2;
        		keys.add(key);
        	}
        }
        
        // Find counts of keys in given input
        for(String key: keys)
        {
        	int curIndex = 0;
        	int counter = 0;
        	
        	// Iterate input for key occurrence
        	while(true)
        	{
        		curIndex = input.indexOf(key, curIndex);
        		
        		// No more occurrence
        		if(curIndex == -1)
        		{
        			break; // end 
        		}
        		
        		// Find key occurrence
        		else
        		{
        			counter++;
        		}
        		
        		// Move index to proper place
        		// since indexOf returns index 
        		// of starting position of occurrence
        		curIndex = curIndex + n;
        	}
        	
        	nGrams.put(key, counter);
        	
        	if(counter > maxOcc)
        	{
        		maxKey = key;
        	    maxOcc = counter;
        	}
        }
        
        System.out.println(nGrams);
        return maxKey;
    }
    
    /**
     * Interview Code
     * @param input
     * @param n
     * @return
     */
    private static String mostFrequentNgram(String input, int n)
    {
        
        char[] inputChar = input.toCharArray();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        int length = input.length();
        int remainder = n % length == 0 ? 0 : 1; 
        int loops = (length / n) + remainder;
        
        
        int startIndex = 0;
        int endIndex = n;
        
        while(loops > 1)
        {
            String key = input.substring(startIndex, endIndex);
            
            // First occurrence
            if(map.get(key) == null)
            {
                map.put(key, 1);
            }
            
            // Duplicate Key
            else
            {
                map.put(key, map.get(key) + 1);
            }
                        
            startIndex = endIndex;
            endIndex = startIndex + n;
            loops--;
        }
        
       
        System.out.println(map);
        
        
        
        
        return "";
    }
}

