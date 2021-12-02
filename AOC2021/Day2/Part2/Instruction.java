package AOC2021.Day2.Part2;

public class Instruction {
  private String direction;
  private int amount;

  public Instruction (String instruction) {
    String[] separated = instruction.split("\\s");
    direction = separated[0];
    amount = Integer.parseInt(separated[1]);
  }

  public String getDirection() { return direction; }  
  public int getAmount() { return amount; }
}
