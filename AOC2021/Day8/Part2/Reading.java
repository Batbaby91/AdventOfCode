package AOC2021.Day8.Part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Reading {
  String[] patterns = new String[10];
  String[] values = new String[4];
  ArrayList<char[]> sortedPatterns = new ArrayList<>();
  ArrayList<char[]> unknownPatterns = new ArrayList<>();
  ArrayList<char[]> sortedValues = new ArrayList<>();
  HashMap<Integer, char[]> numbers = new HashMap<>();
  char top;
  int value = 0;
  
  public Reading(String[] patterns, String[] values) {
    this.patterns = patterns;
    this.values = values;
    sortPatterns();
    sortValues();
    assignUnique();
    calcTop();
    calcSix();
    calcNine();
    setZero();
    calcThree();
    calcTwoFive();
    calcValue();
  }

  public void sortPatterns() {
    for(String pattern : patterns) {
      char[] patternChar = pattern.toCharArray();
      Arrays.sort(patternChar);

      sortedPatterns.add(patternChar);
    }
  }

  public void sortValues() {
    for(String value : values) {
      char[] valueChar = value.toCharArray();
      Arrays.sort(valueChar);

      sortedValues.add(valueChar);
    }
  }

  public void assignUnique() {
    for(char[] pattern : sortedPatterns) {
      switch(pattern.length) {
        case 2: numbers.put(1, pattern); break;
        case 3: numbers.put(7, pattern); break;
        case 4: numbers.put(4, pattern); break;
        case 7: numbers.put(8, pattern); break;
        default: unknownPatterns.add(pattern); break;
      }
    }
  }

  public void calcTop(){
    for(char c : numbers.get(7)) {
      if((c != numbers.get(1)[0]) && (c != numbers.get(1)[1])) {
        top = c;
      }
    }
  }

  public void calcSix() {
   
    for(char[] unknown : unknownPatterns) {
      int matched = 0;
      if(unknown.length == 6) {
        for(char c : unknown) {
          if((c == numbers.get(1)[0]) || (c == numbers.get(1)[1])) {
            matched ++;
          }
        }
        if (matched == 1) {
          numbers.put(6, unknown);
        }
      }
    }

    unknownPatterns.remove(numbers.get(6));
  }

  public void calcNine() {
   
    for(char[] unknown : unknownPatterns) {
      int matched = 0;
      if(unknown.length == 6) {
        for(char c : unknown) {
          if((c == numbers.get(4)[0]) || (c == numbers.get(4)[1]) || (c == numbers.get(4)[2]) || (c == numbers.get(4)[3])) {
            matched ++;
          }
        }
        if (matched == 4) {
          numbers.put(9, unknown);
        }
      }
    }

    unknownPatterns.remove(numbers.get(9));
  }

  public void setZero() {
    for(char[] unknown : unknownPatterns) {
      if(unknown.length == 6) {
        numbers.put(0, unknown);
      }
    }
    unknownPatterns.remove(numbers.get(0));
  }

  public void calcThree() {
    for(char[] unknown : unknownPatterns) {
      int matched = 0;
      if(unknown.length == 5) {
        for(char c : unknown) {
          if((c == numbers.get(1)[0]) || (c == numbers.get(1)[1])) {
            matched ++;
          }
        }
        if (matched == 2) {
          numbers.put(3, unknown);
        }
      }
    }

    unknownPatterns.remove(numbers.get(3));
  }

  public void calcTwoFive() {
   
    for(char[] unknown : unknownPatterns) {
      int matched = 0;
      if(unknown.length == 5) {
        for(char c : unknown) {
          if((c == numbers.get(4)[0]) || (c == numbers.get(4)[1]) || (c == numbers.get(4)[2]) || (c == numbers.get(4)[3])) {
            matched ++;
          }
        }
        if (matched == 2) {
          numbers.put(2, unknown);
        }
        else if(matched == 3) {
          numbers.put(5, unknown);
        }
      }
    }
  }

  public void calcValue() {
    int[] multiplier = {1000, 100, 10, 1};
    for(int x=0; x<4; x++) {
      for(int number : numbers.keySet()) {
        if(Arrays.equals(sortedValues.get(x), numbers.get(number))) {
          value += (number * multiplier[x]);
        }
      }
    }
  }

  public int getValue() { return value; }
}