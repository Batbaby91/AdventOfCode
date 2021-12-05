package AOC2021.Day4.Part2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static ArrayList<Card> getCards (ArrayList<Card> cards, String filename) {
    try {
      File input = new File(filename);
      Scanner reader = new Scanner(input);
      String line = "";
      String[] splitLine = new String[5];
      int[][] rows = new int[5][5];
      int rowCounter = 0;

      reader.nextLine();
      reader.nextLine();
      
      while(reader.hasNextLine()) {
        line = reader.nextLine();

        if(line.isEmpty()) {
          rowCounter = 0;  
          cards.add(new Card (rows));        
        }
        else {
          int[] row = new int[5];
          line = line.trim();
          splitLine = line.trim().split("\\s+");
          for(int x=0; x<splitLine.length; x++) {
            row[x] = Integer.parseInt(splitLine[x]);
          }
          rows[rowCounter] = row;
          rowCounter++;
        }
      }
      cards.add(new Card(rows));
    }
    catch (Exception e) { System.out.println(e.getMessage()); }
    
    return cards;
  }

  public static ArrayList<Integer> getNumbers (ArrayList<Integer> numbers, String filename) {
    try {
      File input = new File(filename);
      Scanner reader = new Scanner(input);
      String line = "";
      String[] splitLine = new String[5];

      line = reader.nextLine();
      splitLine = line.split(",");

      for(String string : splitLine) {
        numbers.add(Integer.parseInt(string));
      }
    }
    catch (Exception e) { System.out.println(e.getMessage()); }      
    
    return numbers;
  }

  public static void main(String[] args) {
    String filename = "AOC2021\\Day4\\Part2\\input.txt";
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    ArrayList<Card> cards = new ArrayList<Card>();

    numbers = getNumbers(numbers, filename);
    cards = getCards(cards, filename);

    for(Integer number : numbers) {
      for(Card card : cards) {
        if(card.calledNumber(number)) {
          int wins = 0;

          for(Card winCard : cards) {
            if (winCard.getWin()) {
              wins++;
            }
          }

          if(wins == cards.size()) {
            System.out.println(card.getScore());
            System.out.println(number);
            System.out.println(number * card.getScore());
            System.exit(0);
          }
          
         
        }

      }
    }
  }
  
}
  
