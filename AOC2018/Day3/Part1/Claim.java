package AOC2018.Day3.Part1;

import java.util.ArrayList;

public class Claim {
  private int xStart;
  private int yStart;
  private int xLength;
  private int yLength;
  private ArrayList<Coord> coords = new ArrayList<Coord>();
  
  public Claim(String data) {
    processClaim(data);
    setCoordinates();
  } 

  public void processClaim(String data) {
    String[] dataArray = data.split("\\D+");

    xStart = Integer.parseInt(dataArray[2]);
    yStart = Integer.parseInt(dataArray[3]);
    xLength = Integer.parseInt(dataArray[4]);
    yLength = Integer.parseInt(dataArray[5]);
  }

  public void setCoordinates() {
    int currentX;
    int currentY;
    for(int xCounter=1; xCounter<=xLength; xCounter++) {
      currentX = xStart + xCounter;
      for(int yCounter=1; yCounter<=yLength; yCounter++) {
        currentY = yStart + yCounter;
        coords.add(new Coord(currentX, currentY));
      }
    }
  }

  public ArrayList<Coord> getCoords() { return coords; }
}
