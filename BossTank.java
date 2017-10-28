
package game;


public class BossTank implements Tank{
    BossTank tk;
    private int X;
    private int Y;
    private String direction;
    Game game =new Game();
    public BossTank(int X, int Y, String direction)
    {
        this.X=X;
        this.Y=Y;
        this.direction=direction;
    }
  
    public void moveTank() {
        if(direction=="up")
        {
            game.blockArray[X][Y]=21;
        }
        else if(direction=="down")
        {
            game.blockArray[X][Y]=22;
        }
        
        else if(direction=="right")
        {
            game.blockArray[X][Y]=23;
        }
        else if(direction=="left")
        {
            game.blockArray[X][Y]=24;
        }
       
    }
    
}
