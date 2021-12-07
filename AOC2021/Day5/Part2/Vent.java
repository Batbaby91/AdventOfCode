package AOC2021.Day5.Part2;

import java.util.ArrayList;

public class Vent {
  int xStart;
  int yStart;
  int xEnd;
  int yEnd;
  int xDifference;
  int yDifference;
  ArrayList<Coord> coords = new ArrayList<Coord>();
  boolean isLine;

  public Vent(int[] input) {
      xStart = input[0];
      yStart = input[1];
      xEnd = input[2];
      yEnd = input[3];
   
    isLine();
    setDifferences();
    setCoords();

  }

  public void setCoords() {
    int x = xStart;
    int y = yStart;
    while ((x != (xEnd + xDifference)) || (y != (yEnd + yDifference))) {
      coords.add(new Coord(x,y));
      x += xDifference;
      y += yDifference;
    }
  }

  public void setDifferences() {
    if(xStart < xEnd) {
      xDifference = 1;
    }
    else if(xStart == xEnd) {
      xDifference = 0;
    }
    else {
      xDifference = -1;
    }

    if(yStart < yEnd) {
      yDifference = 1;
    }
    else if(yStart == yEnd) {
      yDifference = 0;
    }
    else {
      yDifference = -1;
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
