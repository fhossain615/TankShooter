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
public class Bullet extends Game{
    private int X;
    private int Y;
    private String direction;
    public Bullet(int X, int Y, String direction)
    {
        this.X=X;
        this.Y=Y;
        this.direction=direction;
    }
    
    public void drawBullet(int battleField[][])
    {
        
        battleField[X][Y]=25;
               
    }
    
}
