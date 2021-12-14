package AOC2021.Day4.Part1;

public class Card {
  private Row[] rows = new Row[5];
  private Column[] columns = new Column[5];
  private boolean win;
  private int score;

  public Card(int[][] rows) {
    addCardInfo(rows);
    win = false;
    score = 0;
  }

  public void addCardInfo(int[][] rows) {
    for(int x=0; x<5; x++) {
      this.rows[x] = new Row(rows[x]); 
    }
    
    for(int x=0; x<5; x++) {
      int[] column = { rows[0][x], rows[1][x], rows[2][x], rows[3][x], rows[4][x] };
      columns[x] = new Column(column);
    }
  }

  public boolean calledNumber(int number) {
    for(Row row : rows) {
      if(row.callNumber(number)) {
        win = true;
        break;
      } 
    }

    for(Column column : columns) {
      if(column.callNumber(number)) {
        win = true;
        break;
      }
    }
    return win;
  }

  public int getScore() {
    for(Row row: rows) {
      score += row.getScore();
    }
    return score;
  }


  
}
