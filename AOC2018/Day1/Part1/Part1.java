package AOC2018.Day1.Part1;

import java.io.File;
import java.util.Scanner;

public class Part1 {
  public static void main (String[] args) {
    try {
      int frequency = 0;
      File input = new File("AOC2018\\Day1\\Part1\\input.txt");
      Scanner reader = new Scanner(input);

      while (reader.hasNextLine()) {
        String line = reader.nextLine();

        if(line.charAt(0) == '+') {
          frequency += Integer.parseInt(line.substring(1));
        }

        else if(line.charAt(0) == '-') {
          frequency -= Integer.parseInt(line.substring(1));
        }

        else {
          System.out.println(line + " error!");
        }

      }

      System.out.println(frequency);
      reader.close();
    }
  
    catch (Exception e) { System.out.println(e.getMessage());}

  }
  
}

