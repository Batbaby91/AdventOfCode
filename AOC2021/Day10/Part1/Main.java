package AOC2021.Day10.Part1;

import java.io.File;
import java.util.ArrayList;
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
    String filename = "AOC2021\\Day10\\Part1\\input.txt";
    ArrayList<Line> lines = new ArrayList<Line>();
    long value = 0l;

    lines = readData(lines, filename);

    for(Line line : lines) {
      if(line.isCorrupted()) {
        switch(line.getCorruptedValue()) {
          case ')': value += 3; break;
          case ']': value += 57; break;
          case '}': value += 1197; break;
          case '>': value += 25137; break;
        }
      }
    }

    System.out.println(value);
  }
}
