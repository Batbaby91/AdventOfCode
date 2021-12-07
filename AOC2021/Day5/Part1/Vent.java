package AOC2021.Day5.Part1;

import java.util.ArrayList;

public class Vent {
  int xStart;
  int yStart;
  int xEnd;
  int yEnd;
  ArrayList<Coord> coords = new ArrayList<Coord>();
  boolean isLine;

  public Vent(int[] input) {
    if(input[0] <= input[2]) {
      xStart = input[0];
      xEnd = input[2];
    }
    else {
      xStart = input[2];
      xEnd = input[0];
    }

    if(input[1] <= input[3]) {
      yStart = input[1];
      yEnd = input[3];
    }
    else {
      yStart = input[3];
      yEnd = input[1];
    }
    setCoords();
    isLine();
  }

  public void setCoords() {
    for(int x=xStart; x<=xEnd; x++) {
      for(int y=yStart; y<=yEnd; y++) {
        coords.add(new Coord(x,y));
      }
    }
  }

  public void isLine() {
    if((xStart == xEnd) || (yStart == yEnd)) {
      isLine = true;
    }
    else {
      isLine = false;
    }
  }

  public boolean getIsLine() { return isLine; }
  public ArrayList<Coord> getCoords() { return coords; }
}
