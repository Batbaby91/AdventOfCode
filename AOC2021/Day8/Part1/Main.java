package AOC2021.Day8.Part1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static ArrayList<String> readData(ArrayList<String> readings, String filename) {
    try {
      File input = new File(filename);
      Scanner reader = new Scanner(input);

      while(reader.hasNextLine()) {
        String line = reader.nextLine();
        int delimiter = line.indexOf("|");
        String reading = line.substring(delimiter);
        String[] values = reading.trim().split("\\s+");
        
        for(int x=0; x<values.length; x++) {
          readings.add(values[x]);
        }
      }
      reader.close();
    } 
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    
    return readings;
  }
  
  public static void main(String[] args) {
    String filename = "AOC2021\\Day8\\Part1\\input.txt";
    ArrayList<String> readings = new ArrayList<String>();
    int selectedValues = 0;

    readings = readData(readings, filename);

    for(String reading : readings) {
      if((reading.length() == 2) || (reading.length() == 3) || (reading.length() == 4) || (reading.length() == 7)) {
        selectedValues ++;
      }
    }

    System.out.println(selectedValues);
  }
}
