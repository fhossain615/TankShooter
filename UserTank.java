/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Admin
 */
public class UserTank implements Tank{
    private static UserTank tk = null;
    private static int X;
    private static int Y;
    private static String direction;
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
    public void moveTank(int battleField[][])
    {
        if(direction=="up")
        {
            battleField[X][Y]=5;
        }
        else if(direction=="down")
        {
            battleField[X][Y]=6;
        }
        
        else if(direction=="right")
        {
            battleField[X][Y]=7;
        }
        else if(direction=="left")
        {
            battleField[X][Y]=8;
        }
        
    }

}
