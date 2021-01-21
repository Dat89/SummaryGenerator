//This class tests the implementation of SummaryGenerator class.
//It creates a BufferedReader to read from the data file purchases.csv,
//  creates an object of SummaryGenerator,
//  uses this object to call createCountsByCountry and pass 
//     the BufferedReader object br to this method,
//  uses this object to call showCountsByCountry.

/* CIS2168 003 Data Structures
o Dat Nguyen tuk78874@temple.edu
o Lab7 Map
o SummaryGeneratorTest.java
o Program description: Using the map data structure to store and keep count of countries purchases, this is test for the 
SummaryGenerator class
*/
package assign7_template;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SummaryGeneratorTest {

    public static void main(String[] args) {
        try {
            //create a BufferedReader to read from file purchases.csv
           BufferedReader br = new BufferedReader(new FileReader("purchases.csv"));

    //----Assign 7------------//
        //add your own code:
        //  create an object of SummaryGenerator
        //  use this object to call createCountsByCountry and pass 
        //     the BufferedReader object br to this method.
        //  use this object to call showCountsByCountry  
			SummaryGenerator sumGenerator = new SummaryGenerator();
			sumGenerator.createCountsByCountry(br);
			sumGenerator.showCountsByCountry();
    //----Assign 7------------//              
            
        } catch (IOException ioe) {
            System.out.println("file input error.");
            ioe.printStackTrace();
            System.exit(1);
        }

    }

}

