import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HumanPlayer extends Player{
  private BufferedReader input;
  private Board b;

  
  public HumanPlayer(char player){
    super(player);
    input = new BufferedReader(new InputStreamReader(System.in));
    b = new Board();
  }

  public String getMove(){
    try{
     String column = input.readLine();
     int c = Integer.parseInt(column) - 1;
     System.out.println(input);
     b.placeCounter(c, 'r');
     }
     catch(Exception e){
     System.out.println("Please enter a number");
     }
     return null;
    
  }
  
}