/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class TankThread extends Thread{
    public static int possitionX;
    public static int possitionY;
    public static String direction;
    public static int checker = 0;
    private static String[] rotate = {"up","down","left","right"};
    Game game =new Game();
    
    public TankThread(int possitionX,int possitionY, String direction) {
        this.possitionX = possitionX;
        this.possitionY = possitionY;
        this.direction = direction;
    }
    private void checkPosition(int x, int y)
    {
        if(game.blockArray[x][y]==0)
        {
            possitionX = x;
            possitionY = y;
            if(direction.contentEquals("up"))
            {
                game.blockArray[x+1][y] = 0;
            }
            else if(direction.contentEquals("down"))
            {
                game.blockArray[x-1][y] = 0;
            }
            else if(direction.contentEquals("left"))
            {
                game.blockArray[x][y+1] = 0;
            }
            else if(direction.contentEquals("right"))
            {
                game.blockArray[x][y-1] = 0;
            }
            EnemyTank et = new EnemyTank(possitionX, possitionY, direction);
            et.moveTank();
            return;
        }
        else
        {
            
             Random randomGenerator = new Random();
             while(true)
             {
                int randomInt = randomGenerator.nextInt(4);
                String newDirection = rotate[randomInt];
                if(newDirection.contentEquals(direction))
                    continue;
                else
                {
                    direction = newDirection;
                    break;
                }
             }
             return;
        }
        
    }
    
    public void run()
    {
        int x,y;
        while(true)
        {
            if(game.blockArray[possitionX][possitionY]==0)
            {
                break;
            }
            
            if(direction.contentEquals("up"))
            {
                x=possitionX-1;
                y=possitionY;
                checkPosition(x, y);
                System.out.println(x+" "+y);
            }
            else if(direction.contentEquals("down"))
            {
                x=possitionX+1;
                y=possitionY;
                checkPosition(x, y);
            }
            else if(direction.contentEquals("left"))
            {
                x=possitionX;
                y=possitionY-1;
                checkPosition(x, y);
            }
            else if(direction.contentEquals("right"))
            {
                x=possitionX+1;
                y=possitionY;
                checkPosition(x, y);
            }
           
            try {
                Thread.sleep(800);
            } catch (InterruptedException ex) {
                Logger.getLogger(TankThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
