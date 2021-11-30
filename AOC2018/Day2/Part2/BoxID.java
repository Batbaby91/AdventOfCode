package AOC2018.Day2.Part2;

import java.util.HashMap;

public class BoxID {
  private char[] id;
  //private HashMap<Character, Integer> letters = new HashMap<Character, Integer>();
  
  public BoxID(String id) {
    this.id = id.toCharArray();
  }

  public char[] getID() { return id; }


}
