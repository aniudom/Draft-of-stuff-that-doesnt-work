import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Connect4{
  private Board b;
  private HumanPlayer player1;
  private BotPlayer player2;
  private BufferedReader input; 
  private Counter c;

  private boolean HumanPlaying;

  public Connect4(){
    b = new Board();
    player1 = new HumanPlayer('r');
    player2 = new BotPlayer('y');
    input = new BufferedReader(new InputStreamReader(System.in));

    HumanPlaying = (new Random()).nextBoolean();

  }

  public boolean hasWon(int col){

    char winningPlayer;
    if(HumanPlaying){
      winningPlayer = 'r';
    }
    else{
      winningPlayer = 'y';
    }
    return b.hasWon(col, winningPlayer);

  }

  public void playConnect4(){
    System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 is Red, Player 2 is Yellow");
		System.out.println("To play the game type in the number of the column you want to drop you counter in"); 
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		System.out.println("");
	

    boolean win = false;
    while(!win){
      b.printBoard();
      if(HumanPlaying){
          System.out.println("Player 1's turn");
          
      }
      else{
        System.out.println("Player 2's turn");
        
      }
      System.out.println("Select number between 1 and 7: ");

      boolean success = false;

      try{
        if(HumanPlaying){
          player1.getMove();
          success = true;
        }
        else{
          player2.getMove();
          success = true;
        }

        if(success){

          if(hasWon(c.getCounter())){
            win = true;
            if(HumanPlaying){
              b.printBoard();
              System.out.println("You won!");
            }
            else{
            b.printBoard();
            System.out.println("You lost :(, Computer won!");
            }
          }
        }
        HumanPlaying = !HumanPlaying;
      }
      catch(Exception e){
      System.out.println("Please enter a valid number");
      }    
      
    }

}

}