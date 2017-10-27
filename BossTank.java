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
    Game gm = new Game();
    public BossTank(int X, int Y, String direction)
    {
        this.X=X;
        this.Y=Y;
        this.direction=direction;
    }
  
    public void moveTank() {
        if(direction=="up")
        {
            gm.blockArray[X][Y]=21;
        }
        else if(direction=="down")
        {
            gm.blockArray[X][Y]=22;
        }
        
        else if(direction=="right")
        {
            gm.blockArray[X][Y]=23;
        }
        else if(direction=="left")
        {
            gm.blockArray[X][Y]=24;
        }
       
    }
    
}
