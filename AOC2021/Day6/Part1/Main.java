package AOC2021.Day6.Part1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static ArrayList<Integer> readData(ArrayList<Integer> lanternfish, String filename) {
    try {
      File input = new File(filename);
      Scanner reader = new Scanner(input);

      while (reader.hasNextLine()) {
        String line = reader.nextLine();
        String[] splitLine = line.trim().split("\\D+");

        for(String item : splitLine) {
          lanternfish.add(Integer.parseInt(item));
        }
      }
      reader.close();
    }
    catch (Exception e) { System.out.println(e.getMessage()); }
    
    
    return lanternfish;
  }

  public static ArrayList<Integer> addDay (ArrayList<Integer> lanternfish) {
    int newFish = 0;
    ArrayList<Integer> newLanternfish = new ArrayList<Integer>();

    for(Integer fish : lanternfish) {
      if(fish > 0) {
        fish--;
        newLanternfish.add(fish);
      }
      else {
        fish = 6;
        newFish ++;
        newLanternfish.add(fish);
      }
    }

    for (int x=0; x<newFish; x++) {
      newLanternfish.add(8);
    }

    lanternfish.removeAll(lanternfish);
    lanternfish.addAll(newLanternfish);
    return lanternfish;
  }
  public static void main(String[] args) {
    String filename = "AOC2021\\Day6\\Part1\\input.txt";
    ArrayList<Integer> lanternfish = new ArrayList<Integer>();

    lanternfish = readData(lanternfish, filename);

    for(int day=0; day<80; day++) {
      lanternfish = addDay(lanternfish);
    }

    System.out.println(lanternfish.size());
    
  }
}