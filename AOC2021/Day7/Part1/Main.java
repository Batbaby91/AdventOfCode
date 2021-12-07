package AOC2021.Day7.Part1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public static ArrayList<Integer> readData (ArrayList<Integer> positions, String filename) {
    try {
      File input = new File(filename);
      Scanner reader = new Scanner(input);
      String[] splitLine = reader.nextLine().trim().split("\\D+");

      for (String item : splitLine) {
        positions.add(Integer.parseInt(item));
      }

      reader.close();
    }
    catch (Exception e) { System.out.println(e.getMessage()); }
    
    return positions;
  }

  public static void main(String[] args) {
    //HashMap<Crab, Integer> crabs = new HashMap<Crab, Integer>();
    ArrayList<Integer> crabFuel = new ArrayList<Integer>();
    ArrayList<Integer> positions = new ArrayList<Integer>();
    String filename = "AOC2021\\Day7\\Part1\\input.txt";

    positions = readData(positions, filename);

    for(Integer position : positions) {
      Crab crab = new Crab(position, positions);
      crabFuel.add(crab.getFuel());
    }

    Collections.sort(crabFuel);

    System.out.println(crabFuel.get(0));
  }
}
