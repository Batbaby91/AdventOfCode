package AOC2021.Day10.Part2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
  public static ArrayList<Line> readData(ArrayList<Line> lines, String filename) {
    try {
      File input = new File(filename);
      Scanner reader = new Scanner(input);

      while(reader.hasNextLine()) {
        lines.add(new Line(reader.nextLine()));
      }
      reader.close();
    } 
    catch (Exception e) { System.out.println(e.getMessage()); }
    
    return lines;
  }

  public static void main(String[] args) {
    String filename = "AOC2021\\Day10\\Part2\\input.txt";
    ArrayList<Line> lines = new ArrayList<Line>();
    ArrayList<Long> values = new ArrayList<Long>();

    lines = readData(lines, filename);

    for(Line line : lines) {
      if(!line.isCorrupted()) {
        values.add(line.getIncompleteScore());
      }
    }

    Collections.sort(values);
    int index = (values.size()/2);
    
    System.out.println(values.get(index));
  }
}
