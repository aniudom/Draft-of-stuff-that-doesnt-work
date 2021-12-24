
public abstract class Player{ 
  private char player;

  public Player(char player){
    this.player = player;
  }

  public char getCounter(){
  return player;
  }

  public abstract String getMove();
  
}