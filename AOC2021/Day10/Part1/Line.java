package AOC2021.Day10.Part1;

import java.util.ArrayList;

public class Line {
  ArrayList<Character> openingChars = new ArrayList<Character>();
  Character corruptedValue;
  Boolean corrupted;

  public Line(String input) {
    corruptedValue = ' ';
    corrupted = false;
    checkSyntax(input);
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
}
