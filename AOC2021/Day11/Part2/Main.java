package AOC2021.Day11.Part2;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import AOC2021.Day11.Part1.Octopus;

public class Main {
  public static HashMap<String, Octopus> readData (HashMap<String, Octopus> octopuses, String filename) {
    try {
      File input = new File(filename);
      Scanner reader = new Scanner(input);
      int y = 0;

      while(reader.hasNextLine()) {
        String line = reader.nextLine();
        char[] splitLine = line.toCharArray();

        for(int x=0; x<10; x++) {
          Octopus octopus = new Octopus(x, y, Character.getNumericValue(splitLine[x]));
          octopuses.put(octopus.getIndex(), octopus);
        }
        y++;
      }
      reader.close();
    }
    catch (Exception e) { System.out.println(e.getMessage());}
    
    
    return octopuses;
  }

  public static void main(String[] args) {
    HashMap<String, Octopus> octopuses = new HashMap<String, Octopus>();
    String filename = "AOC2021\\Day11\\Part2\\input.txt";
    int flashed = 0;
    int counter = 0;

    octopuses = readData(octopuses, filename);

    while(flashed < 100) {
      counter ++;
      flashed = 0;
      ArrayList<String> toAdd = new ArrayList<String>();
      ArrayList<Octopus> neighbours = new ArrayList<Octopus>();
      for(Octopus octopus : octopuses.values()) {
        if(octopus.hasFlashed()) {
          octopus.resetFlash();
        }
      }
      for(Octopus octopus : octopuses.values()) {
        if(octopus.addEnergy()) {
          toAdd.addAll(octopus.getNeighbours());
          flashed ++;
          
        }
      
        for(String index : toAdd) {
          neighbours.add(octopuses.get(index));
        }
        toAdd.clear();
        
        while(!neighbours.isEmpty()) {
          for(Octopus neighbour : neighbours) {
            if(neighbour.addEnergy()) {
              toAdd.addAll(neighbour.getNeighbours());
              flashed++;
            }
          }
            
          neighbours.clear();

          for(String index : toAdd) {
            neighbours.add(octopuses.get(index));
          }
          toAdd.clear();
        }
      }
    }
    System.out.println(counter);
  }
  
}
