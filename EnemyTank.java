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
public class EnemyTank implements Tank{
    EnemyTank tk;
    private int X;
    private int Y;
    private String direction;
    BattleField field = new BattleField();
    public EnemyTank(int X, int Y, String direction)
    {
        this.X=X;
        this.Y=Y;
        this.direction=direction;
    }
    public void moveTank() {
        if(direction=="up")
        {
            field.blockArray[X][Y]=9;
        }
        else if(direction=="down")
        {
            field.blockArray[X][Y]=10;
        }
        
        else if(direction=="right")
        {
            field.blockArray[X][Y]=11;
        }
        else if(direction=="left")
        {
            field.blockArray[X][Y]=12;
        }
       
    }
    
}
