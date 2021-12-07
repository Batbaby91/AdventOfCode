package AOC2021.Day5.Part2;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

  public static ArrayList<Vent> getVents(ArrayList<Vent> vents, String filename) {
    try {
      File input = new File(filename);
      Scanner reader = new Scanner(input);

      while (reader.hasNextLine()) {
        String line = reader.nextLine();
        String[] splitLine = line.trim().split("\\D+");
        int[] intLine = new int[4];
        for(int x=0; x<4; x++) {
          intLine[x] = Integer.parseInt(splitLine[x]);
        }
        vents.add(new Vent(intLine));
      }

    }
    catch (Exception e) { System.out.println(e.getMessage()); }
    
    
    return vents;
  }

  public static void main(String[] args) {
    ArrayList<Vent> vents = new ArrayList<Vent>();
    HashMap<String, Integer> coordTally = new HashMap<String, Integer>();
    String filename = "AOC2021\\Day5\\Part2\\input.txt";

    vents = getVents(vents, filename);

    for(Vent vent : vents) {
      ArrayList<Coord> ventCoords = vent.getCoords();

      for(Coord coord : ventCoords) {
        String id = coord.getID();
        if(coordTally.containsKey(id)) {
          coordTally.replace(id, (coordTally.get(id) + 1));
        }
        else {
          coordTally.put(id, 1);
        }
      }
    }

    int overlap = 0;

    for(String id : coordTally.keySet()) {
      if(coordTally.get(id) > 1) {
        overlap++;
      }
    }

    System.out.println(overlap);
  }
  
}
