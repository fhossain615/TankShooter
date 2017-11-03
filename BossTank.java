
package Game;
/* 
    Set the position of Boss Tank

Author : Md Mizanur Rahman
*/

public class BossTank implements Tank{
    BossTank tk;
    private int X;
    private int Y;
    private String direction;
    Game Game =new Game();
    public BossTank(int X, int Y, String direction)
    {
        this.X=X;
        this.Y=Y;
        this.direction=direction;
    }
  
    public void moveTank() {
        if(direction=="up")
        {
            Game.blockArray[X][Y]=9;
        }
        else if(direction=="down")
        {
            Game.blockArray[X][Y]=10;
        }
        
        else if(direction=="right")
        {
            Game.blockArray[X][Y]=11;
        }
        else if(direction=="left")
        {
            Game.blockArray[X][Y]=12;
        }
       
    }
    
}
