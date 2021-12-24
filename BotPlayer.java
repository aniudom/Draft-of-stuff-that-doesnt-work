import java.util.Random;

public class BotPlayer extends Player{
  private Random random;
  private Board b;

  public BotPlayer(char player){
    super(player);
    random = new Random();
    b = new Board();
  }

  public String getMove(){
    int r = random.nextInt(7);
    String column = "" + r;
    System.out.println(random);
    b.placeCounter(r, 'y');
    return column;
    
  }


}