package AOC2021.Day13.Part1;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

  public static HashMap<String, Dot> readDots(HashMap<String, Dot> dots, String filename) {
    try {
      File input = new File(filename);
      Scanner reader = new Scanner(input);

      while(reader.hasNextLine()) {
        String line = reader.nextLine();
        if((!line.startsWith("fold")) && !line.isEmpty()) {
          String[] splitLine = line.trim().split("\\D+");
          Dot dot = new Dot(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]));
          dots.put(dot.getIndex(), dot);
        }
      }

      reader.close();
    }
    catch (Exception e) { System.out.println(e.getMessage()); }

    return dots;
  }  

  public static ArrayList<String> readFolds(ArrayList<String> folds, String filename) {
    try {
      File input = new File(filename);
      Scanner reader = new Scanner(input);

      while(reader.hasNextLine()) {
        String line = reader.nextLine();
        if(line.startsWith("fold")) {
          folds.add(line.substring(11));
        }
      }
      reader.close();
    }
    catch (Exception e) { System.out.println(e.getMessage()); }

    return folds;
  }  

  public static void main(String[] args) {
    HashMap<String, Dot> dots = new HashMap<String, Dot>();
    ArrayList<String> folds = new ArrayList<String>();
    HashMap<String, Dot> foldedDots = new HashMap<String, Dot>();
    String filename = "AOC2021\\Day13\\Part1\\input.txt";
    int xFold = 0;
    int yFold = 0;

    dots = readDots(dots, filename);
    folds = readFolds(folds, filename);

    String fold = folds.get(0);
    if(fold.startsWith("x")) {
      xFold = Integer.parseInt(fold.substring(2));
    }
    else if(fold.startsWith("y")) {
      yFold = Integer.parseInt(fold.substring(2));
    }
  
    for(Dot dot : dots.values()) {
      dot.fold(xFold, yFold);
      if(!foldedDots.containsKey(dot.getIndex())) {
        foldedDots.put(dot.getIndex(), dot);
      }
    }

    System.out.println(foldedDots.size());
  }
}