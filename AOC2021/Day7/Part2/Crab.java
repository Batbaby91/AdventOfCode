package AOC2021.Day7.Part2;

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
      int moves = 0;
      int fuelCost;
      if(position >= startingPos) {
        moves = position-startingPos;
        fuelCost = (moves * (moves+1))/2;
        fuel += fuelCost;
      }
      else {
        moves = startingPos - position;
        fuelCost = (moves * (moves+1))/2;
        fuel += fuelCost;
      }
    }
  }

  public int getFuel() { return fuel; }
  
}
