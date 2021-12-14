package AOC2021.Day14.Part2;

public class Pair {
  private char[] pair = new char[2];
  private char[] newPair1 = new char[2];
  private char[] newPair2 = new char[2];

  public Pair(char[] pair, char addition) {
    this.pair = pair;
    setNewPairs(addition);    
  }

  public void setNewPairs(char addition) {
    newPair1[0] = pair[0];
    newPair1[1] = addition;
    newPair2[0] = addition;
    newPair2[1] = pair[1];
  }

  public String getNew1() { return new String(newPair1); }
  public String getNew2() { return new String(newPair2); }
}