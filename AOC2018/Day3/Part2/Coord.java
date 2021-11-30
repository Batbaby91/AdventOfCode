package AOC2018.Day3.Part2;

public class Coord {
  String id;
  int x;
  int y;

  public Coord(int x, int y) {
    this.x = x;
    this.y = y;
    id = x + "," + y;
  }

  public String getID() { return id; }
  
}
