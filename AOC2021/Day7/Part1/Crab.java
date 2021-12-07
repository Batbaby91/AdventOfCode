package AOC2021.Day7.Part1;

import java.util.ArrayList;

public class Crab {
  int startingPos;
  ArrayList<Integer> positions = new ArrayList<Integer>();
  int fuel;

  public Crab (int startingPos, ArrayList<Integer> positions) {
    this.startingPos = startingPos;
    this.positions = positions;
    fuel = 0;
    calcFuel();
  }

  public void calcFuel() {
    for(Integer position: positions) {
      if(position >= startingPos) {
        fuel += position-startingPos;
      }
      else {
        fuel += startingPos - position;
      }
    }
  }

  public int getFuel() { return fuel; }
  
}
