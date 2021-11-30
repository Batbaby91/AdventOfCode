package AOC2018.Day2.Part1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Part1 {

  public static ArrayList<BoxID> readData(ArrayList<BoxID> boxIDs, String filepath)
  {
    try {
      File input = new File(filepath);
      Scanner reader = new Scanner(input);

      while (reader.hasNextLine()) {
        String line = reader.nextLine();
        System.out.println(line);
        boxIDs.add(new BoxID(line));
      }
    }
    catch (Exception e) { System.out.println(e.getMessage()); }

    return boxIDs;
  }
  public static void main(String [] args) {
    ArrayList<BoxID> boxIDs = new ArrayList<BoxID>();
    int twos = 0;
    int threes = 0;
    int checksum = 0;

    readData(boxIDs, "AOC2018\\Day2\\Part1\\input.txt");

    for (BoxID box : boxIDs) {
      if (box.getContainsTwo()) {
        twos ++;
      }
      if (box.getContainsThree()) {
        threes ++;
      }
    }

    checksum = twos * threes;

    System.out.println("twos: " + twos);
    System.out.println("threes: " + threes);
    System.out.println("checksum: " + checksum);
  }
  
}
