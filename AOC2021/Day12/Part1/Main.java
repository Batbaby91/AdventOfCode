package AOC2021.Day12.Part1;

import java.io.File;
import java.util.Scanner;

public class Main {

  public static void readData(String filename) {
    try {
      File input = new File(filename);
      Scanner reader = new Scanner(input);

      while (reader.hasNextLine()) {
        //do the thing
      }
      reader.close();
    }
    catch (Exception e) { System.out.println(e.getMessage()); }
  }

  public static void main(String[] args) {
    String filename = "AOC2021\\Day12\\Part1\\input.txt";
    readData(filename);
  }
  
}
