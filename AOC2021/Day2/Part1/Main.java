package AOC2021.Day2.Part1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static ArrayList<Instruction> readInput(ArrayList<Instruction> instructions, String filepath) {
    try {
      File input = new File(filepath);    
      Scanner reader = new Scanner(input);

      while (reader.hasNextLine()) {
        String line = reader.nextLine();
        instructions.add(new Instruction(line));
      }
      reader.close();
    }
    catch (Exception e) { System.out.println(e.getMessage()); }

    return instructions;
  }

  public static void main (String[] args) {
    ArrayList<Instruction> instructions = new ArrayList<Instruction>();
    String filepath = "AOC2021\\Day2\\Part1\\input.txt";
    int horizontal = 0;
    int depth = 0;
    int result = 0;

    instructions = readInput(instructions, filepath);

    for(Instruction instruction : instructions) {
      switch(instruction.getDirection()) {
        case "forward": horizontal += instruction.getAmount(); break;
        case "down": depth += instruction.getAmount(); break;
        case "up": depth -= instruction.getAmount(); break;
        default: System.out.println(instruction.getDirection() + " " + instruction.getAmount()); break;
      }
    }

    result = horizontal * depth;

    System.out.println("horizontal: " + horizontal);
    System.out.println("depth: " + depth);
    System.out.println("result: " + result);
  
  }
}