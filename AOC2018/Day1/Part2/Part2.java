package AOC2018.Day1.Part2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2 {
  
  public static void main (String[] args) {
    int frequency = 0;
    ArrayList<Integer> pastFrequencies = new ArrayList<Integer>();
    ArrayList<FrequencyChange> changes = new ArrayList<FrequencyChange>();
    int index = 0;

    try {
      
      File input = new File("AOC2018\\Day1\\Part2\\input.txt");
      Scanner reader = new Scanner(input);
      
      while (reader.hasNextLine()) {
        String line = reader.nextLine();
        changes.add(new FrequencyChange(line.charAt(0), Integer.parseInt(line.substring(1))));
      }
      reader.close();
    }
    catch (Exception e) { System.out.println(e.getMessage()); }

    while (!pastFrequencies.contains(frequency)) {
      FrequencyChange change = changes.get(index);

      pastFrequencies.add(frequency);
      /*System.out.println("index: " + index);
      System.out.println("change sign: " + change.getSign());
      System.out.println("change amount: " + change.getAmount());
      System.out.println("current frequency: " + frequency);
      System.out.println("past frequencies: " + pastFrequencies);*/

      if(change.getSign() == '+') {
        frequency += change.getAmount();
      }
      else {
        frequency -= change.getAmount();
      }

      if(index < changes.size()-1) {
        index ++;
      }
      else {
        index = 0;
      }
    }    
    
  System.out.println(frequency);   
  }  
}