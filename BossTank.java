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
public class BossTank implements Tank{
    BossTank tk;
    private int X;
    private int Y;
    private String direction;
    
    public BossTank(int X, int Y, String direction)
    {
        this.X=X;
        this.Y=Y;
        this.direction=direction;
    }
  
    public void moveTank(int battleField[][]) {
        if(direction=="up")
        {
            battleField[X][Y]=21;
        }
        else if(direction=="down")
        {
            battleField[X][Y]=22;
        }
        
        else if(direction=="right")
        {
            battleField[X][Y]=23;
        }
        else if(direction=="left")
        {
            battleField[X][Y]=24;
        }
       
    }
    
}
