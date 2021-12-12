package AOC2021.Day9.Part1;

import java.util.ArrayList;

public class Point {
  int x;
  int y;
  boolean corner;
  boolean edge;
  boolean low;
  int value;
  String index;
  ArrayList<String> neighbours = new ArrayList<String>();

  public Point(int x, int y, int value, int maxX, int maxY) {
    this.x = x;
    this.y = y;
    this.value = value;
    index = x + "," + y;
    setCorner(maxX, maxY);
    setEdge(maxX, maxY);
  }

  public void setCorner(int maxX, int maxY) {
    if ((x == 0) && (y==0)) {
      corner = true;
      neighbours.add(x + "," + (y+1));
      neighbours.add((x+1) + "," + y);
    }
    else if ((x == 0) && (y==maxY)) {
      corner = true;
      neighbours.add(x + "," + (y-1));
      neighbours.add((x+1) + "," + y);
    }
    else if ((x == maxX) && (y==0)) {
      corner = true;
      neighbours.add(x + "," + (y+1));
      neighbours.add((x-1) + "," + y);
    }
    else if ((x == maxX) && (y==maxY)) {
      corner = true;
      neighbours.add(x + "," + (y-1));
      neighbours.add((x-1) + "," + y);
    }
    else {
      corner = false;
    }
  }

  public void setEdge(int maxX, int maxY) {
    if(corner) {
      edge = false;
    }
    else if(x == 0) {
      edge = true;
      neighbours.add(x + "," + (y+1));
      neighbours.add(x + "," + (y-1));      
      neighbours.add((x+1) + "," + y);
    }
    else if(x == maxX){
      edge = true;
      neighbours.add(x + "," + (y+1));
      neighbours.add(x + "," + (y-1));      
      neighbours.add((x-1) + "," + y);
    }
    else if(y == 0) {
      edge = true;
      neighbours.add((x+1) + "," + y);
      neighbours.add((x-1) + "," + y);      
      neighbours.add(x + "," + (y+1));
    }
    else if(y == maxY) {
      edge = true;
      neighbours.add((x+1) + "," + y);
      neighbours.add((x-1) + "," + y);      
      neighbours.add(x + "," + (y-1));
    }
    else {
      edge = false;
      neighbours.add((x+1) + "," + y);
      neighbours.add((x-1) + "," + y);      
      neighbours.add(x + "," + (y+1));
      neighbours.add(x + "," + (y-1));
    }
  }

  public boolean isLow(ArrayList<Integer> neighbourValues) {
    for(Integer nValue : neighbourValues) {
      if(nValue <= value) {
        low = false;
        return low;
      }
    }
    low = true;
    return low;
  }

  public String getIndex() { return index; }
  public ArrayList<String> getNeighbours() { return neighbours; }
  public int getValue() { return value; }
}
