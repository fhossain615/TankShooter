/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class TankThread extends Thread{
    public static int possitionX;
    public static int possitionY;
    public static String direction;
    
    private static String[] rotate = {"up","down","left","right"};
    BattleField field = new BattleField();
    
    public TankThread(int possitionX,int possitionY, String direction) {
        this.possitionX = possitionX;
        this.possitionY = possitionY;
        this.direction = direction;
    }
    private void checkPosition(int x, int y)
    {
        if(field.blockArray[x][y]==0)
        {
            possitionX = x;
            possitionY = y;
            
            EnemyTank et = new EnemyTank(possitionX, possitionY, direction);
            et.moveTank();
            
        }
        else
        {
             Random randomGenerator = new Random();
             int randomInt = randomGenerator.nextInt(4);
             direction = rotate[randomInt];
             
        }
        
    }
    public void run()
    {
        int x,y;
        while(true)
        {
            if(field.blockArray[possitionX][possitionY]==0)
            {
                break;
            }
            
            if(direction.contentEquals("up"))
            {
                x=possitionX;
                y=possitionY-1;
                checkPosition(x, y);
                
            }
            else if(direction.contentEquals("down"))
            {
                x=possitionX;
                y=possitionY+1;
                checkPosition(x, y);
            }
            else if(direction.contentEquals("left"))
            {
                x=possitionX-1;
                y=possitionY;
                checkPosition(x, y);
            }
            else if(direction.contentEquals("right"))
            {
                x=possitionX+1;
                y=possitionY;
                checkPosition(x, y);
            }
        }
    }
    
}
