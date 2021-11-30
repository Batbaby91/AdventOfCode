package AOC2018.Day2.Part2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2 {

  public static boolean checkDifferences(char[] id1, char[] id2) {
    boolean oneDifference = false;
    int differences = 0;

    for (int x=0; x<id1.length; x++)
    {
      if (id1[x] != id2[x])
        {
          differences ++;
          if(differences == 2) { return oneDifference;}
        }
    }

    if (differences == 1) { oneDifference = true; }

    return oneDifference;
  }

  public static String getCommonLetters(char[] id1, char[] id2) {
    String common = "";
    for (int x=0; x<id1.length; x++)
    {
      if (id1[x] == id2[x])
        {
          common += id1[x];
        }
    }

    return common;
  }

  public static ArrayList<BoxID> readData(ArrayList<BoxID> boxIDs, String filepath)
  {
    try {
      File input = new File(filepath);
      Scanner reader = new Scanner(input);

      while (reader.hasNextLine()) {
        String line = reader.nextLine();
        boxIDs.add(new BoxID(line));
      }
    }
    catch (Exception e) { System.out.println(e.getMessage()); }

    return boxIDs;
  }
  public static void main(String [] args) {
    ArrayList<BoxID> boxIDs = new ArrayList<BoxID>();

    readData(boxIDs, "AOC2018\\Day2\\Part2\\input.txt");

    for (BoxID box1 : boxIDs) {
      for(BoxID box2 : boxIDs) {
        if (checkDifferences(box1.getID(), box2.getID())) {
          System.out.println(getCommonLetters(box1.getID(), box2.getID()));
        }
      }
    }
  }
  
}
