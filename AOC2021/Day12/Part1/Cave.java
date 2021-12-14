package AOC2021.Day12.Part1;

public class Cave {
  char index;
  boolean small;
  boolean visited;
  char[] neighbours;

  public Cave(char index) {
    this.index = index;

  }

  public void setSmall() {
    if(Character.isLowerCase(index)) {
      small = true;
    }
    else {
      small = false;
    }
  }
  
}
