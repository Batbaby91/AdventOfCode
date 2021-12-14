package AOC2021.Day1.Part1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static ArrayList<Integer> readInput(ArrayList<Integer> measurements, String filepath) {
    try {
      File input = new File(filepath);    
      Scanner reader = new Scanner(input);

      while (reader.hasNextLine()) {
        String line = reader.nextLine();
        measurements.add(Integer.parseInt(line));
      }
      reader.close();
    }
    catch (Exception e) { System.out.println(e.getMessage()); }

    return measurements;
  }
  

  public static void main (String[] args) {
    ArrayList<Integer> measurements = new ArrayList<Integer>();
    String filepath = "AOC2021\\Day1\\Part1\\input.txt";
    int increases = 0;

    measurements = readInput(measurements, filepath);

    for (int x=1; x<measurements.size(); x++) {
      if (measurements.get(x) > measurements.get(x-1))
        {
          increases++;
        }
    }
    System.out.println(increases);
  }
  
}
