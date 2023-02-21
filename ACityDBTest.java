/**
*
* Tests DB operations implemented using arrays
*
* Run with:
*    $ java ACityDBTest < input_file_name
*/
import java.util.Scanner;
public class ACityDBTest {
   public static void main(String[] args) {
      ACityDB cityDB = new ACityDB(30000); // create a DB
      Scanner sc = new Scanner(System.in);
      while (sc.hasNextLine()) {
          String line = sc.nextLine();
          String[] fields = line.split(",");
          String myName = fields[0].trim();
          String myState = fields[1].trim();
          double myLat = Double.parseDouble(fields[2].trim());
          double myLon = Double.parseDouble(fields[3].trim());
          int myPop = Integer.parseInt(fields[4].trim());
          City myCity = new City(myName, myState, myLat, myLon, myPop);
          cityDB.insert(myCity);
      }
      sc.close();
      // I am using nano second for a more accurate measurement of the execution time and convert it to ms
      //long start = System.nanoTime();
     
      
      System.out.println(cityDB.search("Adams", "OR"));
      System.out.println(""); //To separate the outputs
      System.out.println(cityDB.search(45.7662, -118.5643));
      System.out.println(""); //To separate the outputs
      cityDB.delete("Adams", "OR");
      System.out.println(cityDB.search("Adams", "OR"));
      System.out.println(""); //To separate the outputs
      cityDB.printAllState("RI");
      cityDB.printAllDistance(39.0, -76.0, 0.2);
      System.out.println(""); //To separate the outputs
      cityDB.printAllPopulation(5000000,20000000);
     
      //long end = System.nanoTime();      
      //long execution_time_ns = end - start;
      //double execution_time_ms = execution_time_ns / 1000000.0; // convert to milliseconds
     //System.out.println("Elapsed Time in milliseconds: " + execution_time_ms);
   }
}
