package AOC2021.Day6.Part2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.FormatterClosedException;
import java.util.HashMap;
import java.util.List;
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

  public static long[] addDay (long[] fishPerDay) {
    long fishZeros = fishPerDay[0];
    for(int x=1; x<9; x++) {
      fishPerDay[x-1] = fishPerDay[x];
    }

    fishPerDay[8] = fishZeros;
    fishPerDay[6] += fishZeros;

    return fishPerDay;
  }

  public static void main(String[] args) {
    String filename = "AOC2021\\Day6\\Part2\\input.txt";
    ArrayList<Integer> lanternfish = new ArrayList<Integer>();

    lanternfish = readData(lanternfish, filename);

    long[] fishPerDay = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    for(Integer fish : lanternfish) {
      fishPerDay[fish] ++;
    }

    for(int day = 0; day<256; day++) {
      fishPerDay = addDay(fishPerDay);
    }

    long totalFish = 0;
    for (int x=0; x<fishPerDay.length; x++) {
      totalFish += fishPerDay[x];
    }
    System.out.println(totalFish);
  }
}