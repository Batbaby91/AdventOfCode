package AOC2018.Day2.Part1;

import java.util.HashMap;

public class BoxID {
  private char[] id;
  private HashMap<Character, Integer> letters = new HashMap<Character, Integer>();
  private boolean containsTwo = false;
  private boolean containsThree = false;
  
  public BoxID(String id) {
    this.id = id.toCharArray();
    sortChars();
  }

  public void sortChars() {
    for (char c : id) {
      if (letters.containsKey(c)) {
        letters.replace(c, (letters.get(c) +1));
      }
      else {
        letters.put(c, 1);
      }
    }

    if (letters.containsValue(2)) {
      containsTwo = true;
    }
    if (letters.containsValue(3)) {
      containsThree = true;
    }
  }

  public boolean getContainsTwo() { return containsTwo; }
  public boolean getContainsThree() { return containsThree; }
}
