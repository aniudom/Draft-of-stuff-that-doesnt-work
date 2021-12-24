

public class Board{
  //This class needs a field for board and one for the counters
  private static int rows = 6;
  private static int columns = 7;

  private static Counter[][]myboard = new Counter [rows][columns];

  public Board(){
    for(int row = 0; rows < rows; rows++){
			for(int col = 0; col < columns; col++){
        myboard[row][col] = null;
      }
    }
  }


// method to print the board. This will be used each time a new counter is added to the board
  public void printBoard(){
		for(int row = 0; row < rows; row++){
      System.out.print("|");
			for(int col = 0; col < columns ; col++){
        if(myboard[row][col] == null) {
          System.out.print("_");
        }
        else {
          System.out.print(myboard[row][col].getCounter());
        } 
      System.out.print("|");
		  }
		 System.out.println();
	  }
    System.out.println(" 1 2 3 4 5 6 7");
    System.out.println();
  }


  // this is a method to place counters and check if counters have been placed or not 
  public boolean placeCounter(int colPlaced, char player){
    if(colPlaced >= 0 && colPlaced < columns){
    
      if(myboard[0][colPlaced] == null){
        boolean placed = false;
        int addedRow = -1;
        for(int row = rows -1; row >= 0; row--)
          if(myboard[row][colPlaced] == null){
            myboard[row][colPlaced] = new Counter();
            myboard[row][colPlaced].setCounter(player);
            placed = true;
            addedRow = row;
            break;
          }
          return placed;
          }
          else{
           System.out.println ("Column full, try again");
           return false;
     }
       
      }
       else{
      System.out.println (" Cannot place counter there");
      return false;
      } 
  
  }
 
  public boolean hasWon(int col, char winningPlayer){
    return checkVertical(col, winningPlayer) || checkHorizontal(col, winningPlayer) || checkLeftDiagonal(col, winningPlayer) || checkRightDiagonal(col, winningPlayer);
  }

  private boolean checkVertical(int col, char winningPlayer){
    boolean winner = false;
    for(int row = 0; row < rows; row++){
      if (myboard[row][col] != null){
        int winningStreak = 3;

        for(int winRow = row + 1; winRow < rows; winRow++){
          if(myboard[winRow][col].getCounter() == winningPlayer){
            winningStreak--;
            if(winningStreak == 0){
              winner = true;
            }
          }
          else{
            winningStreak = 3;
          }
        }
      }
    }
    return winner;
   }

  private boolean checkHorizontal(int col, char winningPlayer){
    boolean winner = false;
    for(int row = 0; row < rows; row++){
      if (myboard[row][col] != null){
      int winningStreak = 4;

      for(int winCol = col - 3; winCol < col + 3; winCol++){
        if(winCol < 0) continue;
        if(winCol >= columns) break;

        if(myboard[row][winCol] != null && myboard[row][winCol].getCounter() == winningPlayer){
          winningStreak--;
          if(winningStreak == 0){
            winner = true;
          }
        }
        else{
          winningStreak = 4;
        }
      }
      break;
      }
    }
   return winner;
  }

  private boolean checkLeftDiagonal(int col, char winningPlayer){
    boolean winner = false;
    for(int row = 0; row < rows; row++){
      if (myboard[row][col] != null){
      int winningStreak = 4;

      //  checks left diagonal, top to bottom
      for(int winRow = row - 3, winCol = col - 3; winRow <= row + 3 && winCol <= col + 3; winRow++, winCol++){
        if(winRow < 0 || winCol < 0) continue;
        if(winRow >= rows || winCol >= columns) break;
       
        if(myboard[winRow][winCol] != null && myboard[winRow][winCol].getCounter() == winningPlayer) {
          winningStreak--;
          if(winningStreak == 0){
            winner = true;
          }
        }
        else{
          winningStreak = 4;
        }
      }
      break;
    }
  }
  return winner;
  }
  
  private boolean checkRightDiagonal(int col, char winningPlayer){
    boolean winner = false;
    for(int row = 0; row < rows; row++){
      if (myboard[row][col] != null){
      int winningStreak = 4;

      // check right diagonal, bottom to top
      for(int winRow = row - 3, winCol = col + 3; winRow <= row + 3 && winCol >= col - 3; winRow++, winCol--){
        if(winRow < 0 || winCol >= columns) continue;
        if(winRow >= rows || winCol < 0) break;
       
        if(myboard[winRow][winCol] != null && myboard[winRow][winCol].getCounter() == winningPlayer) {
          winningStreak--;
          if(winningStreak == 0){
            winner = true;
          }
        }
        else{
          winningStreak = 4;
      }
      }
      break;   
     }
    }
  return winner;
  }
}