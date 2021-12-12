package AOC2021.Day9.Part1;

import java.io.File;
import java.util.ArrayList;
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
    String filename = "AOC2021\\Day9\\Part1\\input.txt";
    int noRows = getNoRows(filename);
    points = readData(points, filename, noRows);
    int total = 0;

    for(Point point : points.values()) {
      ArrayList<String> neighbours = point.getNeighbours();
      ArrayList<Integer> nValues = new ArrayList<Integer>();
      for(String neighbour : neighbours) {
        nValues.add(points.get(neighbour).getValue());
      }
      if(point.isLow(nValues)) {
        total += point.getValue() + 1;
      }
    }

    System.out.println(total);
  }
  
}
