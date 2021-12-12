package AOC2021.Day11.Part2;

import java.util.ArrayList;

public class Octopus {
  int x;
  int y;
  int energy;
  String index;
  boolean flashed;
  ArrayList<String>neighbours = new ArrayList<String>();

  public Octopus(int x, int y, int energy) {
    this.x = x;
    this.y = y;
    this.energy = energy;
    index = x + "," + y;
    flashed = false;
    setNeighbours();
  }

  public void setNeighbours() {
    if(x==0 && y==0) {
      neighbours.add((x + "," + (y+1)));
      neighbours.add(((x+1) + "," + (y+1)));      
      neighbours.add(((x+1) + "," + (y)));
    }

    else if(x==0 && y==9) {
      neighbours.add((x + "," + (y-1)));
      neighbours.add(((x+1) + "," + (y-1)));      
      neighbours.add(((x+1) + "," + (y)));
    }

    else if(x==9 && y==9) {
      neighbours.add((x + "," + (y-1)));
      neighbours.add(((x-1) + "," + (y-1)));      
      neighbours.add(((x-1) + "," + (y)));
    }

    else if(x==9 && y==0) {
      neighbours.add((x + "," + (y+1)));
      neighbours.add(((x-1) + "," + (y+1)));      
      neighbours.add(((x-1) + "," + (y)));
    }

    else if(x==0) {
      neighbours.add((x + "," + (y-1)));
      neighbours.add(((x) + "," + (y+1)));
      neighbours.add(((x+1) + "," + (y-1)));      
      neighbours.add(((x+1) + "," + (y)));
      neighbours.add(((x+1) + "," + (y+1)));
    }

    else if(x==9) {
      neighbours.add(((x-1) + "," + (y-1)));      
      neighbours.add(((x-1) + "," + (y)));
      neighbours.add(((x-1) + "," + (y+1)));
      neighbours.add((x + "," + (y-1)));
      neighbours.add(((x) + "," + (y+1)));      
    }

    else if(y==0) {
      neighbours.add(((x-1) + "," + (y)));
      neighbours.add(((x-1) + "," + (y+1)));
      neighbours.add((x + "," + (y+1)));
      neighbours.add(((x+1) + "," + (y)));
      neighbours.add(((x+1) + "," + (y+1)));
    }

    else if(y==9) {
      neighbours.add(((x-1) + "," + (y-1)));
      neighbours.add(((x-1) + "," + (y)));
      neighbours.add((x + "," + (y-1)));
      neighbours.add(((x+1) + "," + (y-1)));
      neighbours.add(((x+1) + "," + (y)));
    }

    else {
      neighbours.add(((x-1) + "," + (y-1)));
      neighbours.add(((x-1) + "," + (y)));
      neighbours.add(((x-1) + "," + (y+1)));
      neighbours.add((x + "," + (y-1)));
      neighbours.add((x + "," + (y+1)));
      neighbours.add(((x+1) + "," + (y-1)));
      neighbours.add(((x+1) + "," + (y)));
      neighbours.add(((x+1) + "," + (y+1)));
    }
  }

  public boolean addEnergy() {
    if(!flashed) {
      energy += 1;
      if( energy > 9) {
        flashed = true;
        return true;
      }
    }
    return false;
  }

  public boolean hasFlashed() { return flashed; }

  public ArrayList<String> getNeighbours() { return neighbours; }

  public String getIndex() { return index; }

  public void resetFlash() {
    flashed = false;
    energy = 0;
  }
  
  
}
