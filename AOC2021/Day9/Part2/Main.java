package AOC2021.Day9.Part2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public static int getNoRows(String filename) {
    int noRows =0;
    try {
      File input = new File(filename);
      Scanner reader = new Scanner(input);

      while(reader.hasNextLine()) {
        noRows ++;
        reader.nextLine();
      }
      reader.close();
    } 
    catch (Exception e) { System.out.println(e.getMessage()); }
    
    return noRows;
  }

  public static HashMap<String, Point> readData(HashMap<String, Point> points, String filename, int noRows) {
    try {
      File input = new File(filename);
      Scanner reader = new Scanner(input);
      int y = 0;

      while(reader.hasNextLine()) {
        String line = reader.nextLine();
        char[] splitLine = line.toCharArray();

        for(int x=0; x<splitLine.length; x++) {
          int value = Character.getNumericValue(splitLine[x]);
          Point point = new Point(x, y, value, splitLine.length-1, noRows-1);
          points.put(point.getIndex(), point); 
        }
        y++;
      }
      reader.close();
    } 
    catch (Exception e) { System.out.println(e.getMessage()); }
    
    return points;
  }

  public static void main(String[] args) {
    HashMap<String, Point> points = new HashMap<String, Point>();
    String filename = "AOC2021\\Day9\\Part2\\input.txt";
    int noRows = getNoRows(filename);
    points = readData(points, filename, noRows);
    int total = 0;
    ArrayList<Basin> basins = new ArrayList<Basin>();

    for(Point point : points.values()) {
      ArrayList<String> neighbours = point.getNeighbours();
      ArrayList<Integer> nValues = new ArrayList<Integer>();
      for(String neighbour : neighbours) {
        nValues.add(points.get(neighbour).getValue());
      }
      if(point.isLow(nValues)) {
        basins.add(new Basin(point));
      }
    }

    for(Basin basin : basins) {
      basin.calcSize(points);
    }

    int[] largestBasins = {0, 0, 0};

    for(Basin basin : basins) {
      for(int x=2; x>=0; x--) {
        if(basin.getSize() > largestBasins[x]) {
          largestBasins[x] = basin.getSize();
          break;
        }
        Arrays.sort(largestBasins);
      }
    }


    System.out.println(largestBasins[0] * largestBasins[1] * largestBasins[2]);
  }
  
}
