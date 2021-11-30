package AOC2018.Day1.Part2;

public class FrequencyChange {

  private char sign;
  private int amount;

  public FrequencyChange(char sign, int amount) {
    setSign(sign);
    setAmount(amount);
  }
  
  public char getSign() {
    return sign;
  }  
  public void setSign(char sign) {
    this.sign = sign;
  }
  public int getAmount() {
    return amount;
  }
  public void setAmount(int amount) {
    this.amount = amount;
  }

  
}
