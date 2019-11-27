/**
 * Empid:23469048
 */

/**
 * @author Merle Cato
 *
 *Using TreeMap to map the word frequencies of contents provided 
 */

import java.util.*;
import java.io.*;

public class WordCount1 {

	/**
	 * @param args
	 */
	// function to sort TreeMap values
	public static TreeMap<String, Integer> sortByValue(TreeMap<String, Integer> tCount){
		
		//Create a list from the elements of a TreeMap
	    List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(tCount.entrySet());	
	
	    //
	    Collections.sort(list, new Comparator< Map.Entry<String, Integer> >(){
	    	public int compare(Map.Entry<String, Integer> num1,
	    			Map.Entry<String, Integer>num2) {
	    		return(num2.getValue()).compareTo(num1.getValue());
	    	}
	    });
	    
	    //put data from sorted list into TreeMap
	    TreeMap<String, Integer> wordTemp = new TreeMap<String, Integer>();
	    for(Map.Entry<String, Integer> links : list) {
	    	wordTemp.put(links.getKey(), links.getValue());
	    }
	    return wordTemp;	
	  }
	
	
	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		 
       Scanner scan = new Scanner (new File("/Users/Black/Desktop/mobydick.txt"));
       
       // counts word occurrences
       TreeMap<String, Integer> wordCounts = new TreeMap<String, Integer>();
       while(scan.hasNext()) {
    	   String next = scan.next().toLowerCase();
    	   String clean = next.replaceAll("\\p{Punct}", " ").toLowerCase();
    	   
    	   if(!wordCounts.containsKey(clean)) {
    		   wordCounts.put(clean, 1); 		   
    	   }else {
    		   wordCounts.put(clean,  wordCounts.get(clean) + 1);
    	   }
       }
       
       scan.close();
   
	
	System.out.println("Total Words = " + wordCounts.size());
	
	TreeMap<String, Integer>sortedMapAsc = WordCount1.sortByValue(wordCounts);
	
	// frequencies of word occurrences
	
	for(String word : sortedMapAsc.keySet()) {
		int count = sortedMapAsc.get(word);
		System.out.println(count + ": " + word);
	}
	}

}
