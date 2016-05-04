import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class InvertedIndex {

	public static void main(String args[]) throws IOException{
		
		Scanner stdin = new Scanner(System.in);
		
		final File folder = new File("C:/Users/srikanth_nadella/workspace/problems/552InvertedIndex/pa4");
		TreeMap<String,TreeMap<String,Integer>> treeMap =  listFilesForFolder(folder);
		
		System.out.println("Press anything to continue");
		while(stdin.hasNext() && stdin.next()!="Yes"){
			System.out.println("Input a word");
			String input = stdin.next();
			System.out.println(treeMap.get(input).toString());
			//printMap(listFilesForFolder(folder).get(input));
			System.out.println("You want to quit...Press 'No'...Else press anything");
		}
		
	}
	
	public static  TreeMap<String,TreeMap<String,Integer>>  listFilesForFolder(final File folder) throws IOException {
	    String eachLine =null; 
	    TreeMap<String,TreeMap<String,Integer>> treemap1 = new TreeMap<String,TreeMap<String,Integer>>();
	    
		for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	           // System.out.println(fileEntry.getName());
	        	 FileReader fileReader = 
	                     new FileReader("C:/Users/srikanth_nadella/workspace/problems/552InvertedIndex/pa4/"+fileEntry.getName());

	                 // Always wrap FileReader in BufferedReader.
	                 BufferedReader breader = 
	                     new BufferedReader(fileReader);

	                 while ((eachLine = breader.readLine()) != null) {
	     				/*System.out.println(eachLine);*/
	                	 String[] arr = eachLine.split(" ");    

	                	 for ( String ss : arr) {

	                	       if(treemap1.containsKey(ss)){
	                	    	 if(treemap1.get(ss).containsKey(fileEntry.getName())){
	                	    		   int value =treemap1.get(ss).get(fileEntry.getName())+1 ;
	                	    		   treemap1.get(ss).put(fileEntry.getName(),value);
	                	    	   }
	                	    	 else
	                	    	 {
	                	    		 treemap1.get(ss).put(fileEntry.getName(),1);
	                	    	 }
	                	       }
	                	       else
	                	       {  TreeMap<String,Integer> treemap2 = new TreeMap<String,Integer>();
	                	    	   treemap2.put(fileEntry.getName(), 1);
	                	    	   treemap1.put(ss,treemap2);
	                	       }
	                	  }
	     			}

	                 // Always close files.
	                 breader.close();  
	        }
	    } return treemap1;
	}

	public static void printMap(TreeMap<String,Integer> treeMap) {
		for(Map.Entry<String,Integer> entry : treeMap.entrySet()) {
			  String key = entry.getKey();
			  Integer value = entry.getValue();

			  System.out.println(key + " => " + value);
			}
	}
}
