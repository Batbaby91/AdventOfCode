package AOC2021.Day13.Part1;

public class Dot {
  int x;
  int y;
  String index;

  public Dot(int x, int y) {
    this.x = x;
    this.y = y;
    index = x + "," + y;
  }

  public void fold(int xFold, int yFold) {
    if((x > xFold) && (xFold > 0)) {
      int oldX = x;
      x = xFold - (oldX-xFold);
      index = x + "," + y;
    }

    if((y > yFold) && (yFold > 0)) {
      int oldY = y;
      y = yFold - (oldY - yFold);
      index = x + "," + y;
    }
  }  

  public String getIndex() { return index; }
}
