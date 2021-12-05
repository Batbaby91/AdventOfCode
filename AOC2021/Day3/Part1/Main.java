package AOC2021.Day3.Part1;

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
    }
    catch (Exception e) { System.out.println(e.getMessage()); }

    return readings;
  }

  public static void main (String[] args) {
    ArrayList<int[]> readings = new ArrayList<int[]>();
    String filepath = "AOC2021\\Day3\\Part1\\input.txt";
    int gammaDecimal = 0;
    int epsilonDecimal = 0;

    readings = readInput(readings, filepath);
    int[] readingsTally = new int[readings.get(0).length];
    int[] gamma = new int[readings.get(0).length];
    int[] epsilon = new int[readings.get(0).length];
    int[] binaryToDecimal = new int[readings.get(0).length];    

    for(int[] reading : readings) {
      for(int x=0; x<reading.length; x++) {
        if (x==0) { binaryToDecimal[x] = 1; }
        else { binaryToDecimal[x] = binaryToDecimal[x-1]*2; }

        readingsTally[x] += reading[x];
      }
    }

    for (int x=0; x<readingsTally.length; x++) {
      if(readingsTally[x] >= (readings.size()/2)) {
        gamma[x] = 1;
        epsilon[x] = 0;
      }
      else {
        gamma[x] = 0;
        epsilon[x] = 1;
      }
      int binaryIndex = binaryToDecimal.length -x -1;
      gammaDecimal += gamma[x] * binaryToDecimal[binaryIndex];
      epsilonDecimal += epsilon[x] * binaryToDecimal[binaryIndex];
    }

    System.out.println("Gamma: " + gammaDecimal);
    System.out.println("Epsilon: " + epsilonDecimal);
    System.out.println("Power consumption: " + gammaDecimal*epsilonDecimal);
  }
}
