package AOC2021.Day8.Part2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static ArrayList<Reading> readData(ArrayList<Reading> readings, String filename) {
    try {
      File input = new File(filename);
      Scanner reader = new Scanner(input);

      while(reader.hasNextLine()) {
        String line = reader.nextLine();
        int delimiter = line.indexOf("|");
        String data = line.substring(0, delimiter);
        String reading = line.substring(delimiter+1);
        String[] splitData = data.trim().split("\\s+");
        String[] values = reading.trim().split("\\s+");

        readings.add(new Reading(splitData, values));
      }
      reader.close();
    } 
    catch (Exception e) {
      System.out.println(e.getMessage());
    }  
    
    return readings;
  }

  
  public static void main(String[] args) {
    ArrayList<Reading> readings = new ArrayList<Reading>();
    String filename = "AOC2021\\Day8\\Part2\\input.txt";

    readings = readData(readings, filename);
    
    long value = 0l;

    for(Reading reading : readings) {
      value += reading.getValue();
    }
    
    System.out.println(value);

  }
}
