package AOC2021.Day5.Part2;

public class Coord {
  int x;
  int y;
  String id;

  public Coord(int x, int y) {
    this.x = x;
    this.y = y;
    id = x + "," + y;
  }

  public String getID() { return id; }
}
