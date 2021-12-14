package AOC2021.Day3.Part2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static ArrayList<int[]> readInput(ArrayList<int[]> readings, String filepath) {
    try {
      File input = new File(filepath);    
      Scanner reader = new Scanner(input);

      while (reader.hasNextLine()) {
        char[] line = reader.nextLine().toCharArray();
        int[] intLine = new int[line.length];

        for(int x=0; x<line.length; x++) {

          intLine[x] = Character.getNumericValue(line[x]);
        }
        readings.add(intLine);
      }
      reader.close();
    }
    catch (Exception e) { System.out.println(e.getMessage()); }

    return readings;
  }

  public static int[] getFinal(ArrayList<int[]> options, String type) {
    int numberLength = options.get(0).length;
    

    for(int x = 0; x<numberLength; x++) {
      int ones = 0;
      int zeroes = 0;
      int toKeep = 0;
      for(int[] option : options) {
        if(option[x] == 1) {
          ones++;
        }
        else { zeroes ++; }
      }

      if(type.equalsIgnoreCase("oxygen")) {

        if (ones >= zeroes) {
          toKeep = 1;
        }
        else { toKeep = 0; }      
      }
      else {
        if (zeroes <= ones) {
          toKeep = 0;
        }
        else { toKeep = 1; }
      }

      ArrayList<int[]> toRemove = new ArrayList<int[]>();

      for(int[] option : options) {
        if(option[x] != toKeep) {
          toRemove.add(option);
        }
      }

      for(int[] removeItem : toRemove) {
        if(options.size() == 1) {
          break;
        }
        options.remove(removeItem);
      }

      
    }
    return options.get(0);
  }

  public static void main (String[] args) {
    ArrayList<int[]> readings = new ArrayList<int[]>();
    ArrayList<int[]> oxygenOptions = new ArrayList<int[]>();
    ArrayList<int[]> co2Options = new ArrayList<int[]>();

    String filepath = "AOC2021\\Day3\\Part2\\input.txt";
    int oxygenDecimal = 0;
    int co2Decimal = 0;

    readings = readInput(readings, filepath);
    oxygenOptions = readInput(oxygenOptions, filepath);
    co2Options = readInput(co2Options, filepath);

    int[] finalOxygen = getFinal(oxygenOptions, "oxygen");
    int[] finalCO2 = getFinal(co2Options, "co2");
    
    int[] binaryToDecimal = new int[readings.get(0).length];    

    
    for(int x=0; x<readings.get(0).length; x++) {
      if (x==0) { binaryToDecimal[x] = 1; }
      else { binaryToDecimal[x] = binaryToDecimal[x-1]*2; }
    }          

    for(int x=0; x<finalOxygen.length; x++) {
      int binaryIndex = binaryToDecimal.length -x -1;
      oxygenDecimal += finalOxygen[x] * binaryToDecimal[binaryIndex];
      co2Decimal += finalCO2[x] * binaryToDecimal[binaryIndex];
    }

    System.out.println("Oxygen: " + oxygenDecimal);
    System.out.println("CO2: " + co2Decimal);
    System.out.println("Life Support: " + oxygenDecimal*co2Decimal);
  }
}
