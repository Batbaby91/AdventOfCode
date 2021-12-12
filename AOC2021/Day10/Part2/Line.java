package AOC2021.Day10.Part2;

import java.util.ArrayList;

public class Line {
  ArrayList<Character> openingChars = new ArrayList<Character>();
  Character corruptedValue;
  Boolean corrupted;
  long incompleteScore = 0l;

  public Line(String input) {
    corruptedValue = ' ';
    corrupted = false;
    checkSyntax(input);
    if(!corrupted) {
      calcIncompleteScore();
    }
  }

  public void checkSyntax(String input) {
    for(Character c : input.toCharArray()) {
      if(!corrupted) {
        switch(c) {
          case '(': openingChars.add(c); break;
          case '[': openingChars.add(c); break;
          case '<': openingChars.add(c); break;
          case '{': openingChars.add(c); break;
          case ')': 
            if(openingChars.get(openingChars.size()-1) != '(') {
              corrupted = true;
              corruptedValue = ')';
            }
            else {
              openingChars.remove(openingChars.size()-1);
            }
            break;
          case ']': 
            if(openingChars.get(openingChars.size()-1) != '[') {
              corrupted = true;
              corruptedValue = ']';
            }
            else {
              openingChars.remove(openingChars.size()-1);
            }
            break;
          case '>': 
            if(openingChars.get(openingChars.size()-1) != '<') {
              corrupted = true;
              corruptedValue = '>';
            }
            else {
              openingChars.remove(openingChars.size()-1);
            }
            break;
          case '}': 
            if(openingChars.get(openingChars.size()-1) != '{') {
              corrupted = true;
              corruptedValue = '}';
            }
            else {
              openingChars.remove(openingChars.size()-1);
            }
            break;
        }
      }
    }
  }

  public boolean isCorrupted() { return corrupted; }

  public Character getCorruptedValue() { return corruptedValue; }

  public void calcIncompleteScore() {
    for(int x=(openingChars.size()-1); x>=0; x--) {
      incompleteScore *= 5;
      switch(openingChars.get(x)) {
        case '(': incompleteScore += 1; break;
        case '[': incompleteScore += 2; break;
        case '{': incompleteScore += 3; break;
        case '<': incompleteScore += 4; break;
      }
    }
  }

  public long getIncompleteScore() { return incompleteScore; }

}
