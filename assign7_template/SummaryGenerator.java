//This class generates the data summary based on the data in the file 
// and show such summaries. 
//Currently it only counts how many times each country appears. 

/* CIS2168 003 Data Structures
o Dat Nguyen tuk78874@temple.edu
o Lab7 Map
o SummaryGenerator.java
o Program description: Using the map data structure to store and keep count of countries purchases, file being read from 
is csv
*/
package assign7_template;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

public class SummaryGenerator {

    //the delimiter comma in the data file: purchases.csv
    private final String COMMA_DELIMITER = ",";
    
    //----Assign 7------------//    
    //add your code:  define a data field named countsByCountryMap, which must be a Map data structure.
	private Map<String, Integer> countsByCountryMap;

    //add your code: define a no-argument constructor, 
    //  where you create a new HashMap or TreeMap for the data summary. 
    //  You must add the code for creating each type of Map.
    //  Then you comment the code for one type, use the other type at a time.
    public SummaryGenerator() {
        //add your code
		countsByCountryMap = new HashMap<>();
//		countsByCountryMap = new TreeMap<>();
    }
    
    
    //----Assign 7------------//    
    
    //takes in a BufferedReader object that is already associated with
    //   the file purchases.csv, read the data line by line,
    //   create the country summary and save the summary entries in the summary map.
    public void createCountsByCountry(BufferedReader br) {      
        //build country summary
        List<String> purchase = new ArrayList<>();

        try {
            String line;
            //read line by line until file reading is completed
            
            while ((line = br.readLine()) != null) {
                //split values in each line using the delimiter comma,
                //  store values as String in a String array.
                String[] fields = line.split(COMMA_DELIMITER);
                //convert the array to an ArrayList
                purchase = Arrays.asList(fields);
				// System.out.println(purchase);
				// System.out.println(purchase.get(purchase.size()));

				if (countsByCountryMap.containsKey(purchase.get(7)) == false) {
					countsByCountryMap.put(purchase.get(7), 1);
				} else {
					// get current key's value and update it;
					int count = countsByCountryMap.get(purchase.get(7));
					countsByCountryMap.replace(purchase.get(7), count + 1);
				}

        //----Assign 7------------//
        
        //Add your code:
        //get the country from the ArrayList: purchase
        //if the country is already in the data summary
        //    get the country's count, increase the count by 1,
        //    write the new summary: country, updated-count into the data summary map.
        //otherwise,
        //    add the new summary entry: country, 1 into the data summary map.
                             

        //----Assign 7------------//                
                
            }
        } catch (IOException ioe) { 
            System.out.println("file input error.");
            ioe.printStackTrace();
            System.exit(1);
        } catch (PatternSyntaxException pse) {
            System.out.println("pattern specification error.");            
            pse.printStackTrace();
            System.exit(1);            
        }


    }
    
    //----Assign 7------------//
    
    //print the content of the data summary map in the format given in the sample output
    public void showCountsByCountry(){
        //add your code
        //print the heading
		System.out.println("Country\t\t\tCount");
		// print a number of dashes
		System.out.println("--------------------------------------");
		// use a foreach loop
		for (String key : countsByCountryMap.keySet()) {
			if (key.length() > 6 && key.contains(" ")) {// formatting
				System.out.print(key + "\t\t");
				printNChars('*', countsByCountryMap.get(key));
			} else {
				System.out.print(key + "\t\t\t");
				printNChars('*', countsByCountryMap.get(key));
			}
		}


        //   do the following in each loop run
        //      get the curernt data summary entry: country, count
        //      print the country
        //      call printNChars to print the count as a sequence of stars.
        //           count of 5 means 5 stars.
    }
    
    //print the character ch count number of times in one line
    private void printNChars(char ch, int count) {
		String countNumber = "";
        //add your own code
		while (count != 0) {
			countNumber += ch;
			count--;
		}
		System.out.println(countNumber);
    }
    //----Assign 7  End------------//    
    
}

