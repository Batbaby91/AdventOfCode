package AOC2018.Day3.Part2;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Part2 {
  public static ArrayList<Claim> readData(ArrayList<Claim> claims, String filepath)
  {
    try {
      File input = new File(filepath);
      Scanner reader = new Scanner(input);

      while (reader.hasNextLine()) {
        String line = reader.nextLine();
        claims.add(new Claim(line));
      }
    }
    catch (Exception e) { System.out.println(e.getMessage()); }

    return claims;
  } 

  public static void main(String [] args) {
    ArrayList<Claim> claims = new ArrayList<Claim>();
    HashMap<String, Integer> coordTally = new HashMap<String, Integer>();
    ArrayList<String> noOverlap = new ArrayList<String>();
    int duplicates =0;

    claims = readData(claims, "AOC2018\\Day3\\Part2\\input.txt");

    for(Claim claim: claims) {
      for(Coord coord: claim.getCoords()) {
        if(coordTally.containsKey(coord.getID()))
        {
          coordTally.replace(coord.getID(), (coordTally.get(coord.getID()) +1));
        }
        else {
          coordTally.put(coord.getID(), 1);
        }
      }
    }

    for(String id : coordTally.keySet()) {
      if (coordTally.get(id)>1) {
        duplicates++;
      }
      else {
        noOverlap.add(id);
      }
    }

    for( Claim claim: claims) {
      if( claim.noOverlap(noOverlap)) {
        System.out.println(claim.getID());
      }
    }
    System.out.println(duplicates);
  }
}
