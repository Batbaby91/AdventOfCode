package AOC2021.Day4.Part2;

import java.util.HashMap;

public class Column {
  private HashMap<Integer, Boolean> numbers = new HashMap<Integer, Boolean>();
  private boolean complete;

  public Column(int[] numbers) {
    for(int number : numbers) {
      this.numbers.put(number, false);
    }
    complete = false;
  }

  public boolean callNumber(int number) {
    if (numbers.containsKey(number)) {
      numbers.replace(number, true);
      isComplete();
    }

    return complete;
  }

  public void isComplete() {
    if (!numbers.containsValue(false)) {
      complete = true;
    }
  }
}
