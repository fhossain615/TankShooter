
package game;


public class UserTank implements Tank{
    private static UserTank tk = null;
    private static int X;
    private static int Y;
    private static String direction;
    Game game =new Game();
    private UserTank(int X, int Y, String direction)
    {
        this.X=X;
        this.Y=Y;
        this.direction=direction;
    }
    
    public static UserTank getInstance(int XX, int YY, String ddirection)
    {
        
        if(tk==null)
        {
            tk=new UserTank(XX, YY, ddirection);
        }
        else
        {
            X=XX;
            Y=YY;
            direction =ddirection;
        }
        return tk;
    }
    public void moveTank()
    {
        if(direction=="up")
        {
            game.blockArray[X][Y]=5;
        }
        else if(direction=="down")
        {
            game.blockArray[X][Y]=6;
        }
        
        else if(direction=="right")
        {
            game.blockArray[X][Y]=7;
        }
        else if(direction=="left")
        {
            game.blockArray[X][Y]=8;
        }
        
    }

}
