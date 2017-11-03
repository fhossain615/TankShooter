
package Game;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/* 
    manage the 2nd enemy tank's movement

Author : Md.Faruk Hoaasin

*/
public class EnemyThread1 extends Thread{
    public static int possitionX;
    public static int possitionY;
    public static String direction;
    public static int checker = 0;
    private static String[] rotate = {"up","down","left","right"};
    Game Game =new Game();
    BulletThread bt = new BulletThread();
    public EnemyThread1(int possitionX,int possitionY, String direction) {
        if(possitionX == 0 && possitionY == 0)
        {
            Game.blockArray[this.possitionX][this.possitionY] = 0;
        }
        else
        {
            this.possitionX = possitionX;
            this.possitionY = possitionY;
            this.direction = direction;
        }
    }
    public void killThread()
    {
        Game.blockArray[possitionX][possitionY] = 0;
        return;
    }
    private void checkPosition(int x, int y)
    {
        if(Game.blockArray[x][y]==0)
        {
            possitionX = x;
            possitionY = y;
            if(direction.contentEquals("up"))
            {
                Game.blockArray[x+1][y] = 0;
            }
            else if(direction.contentEquals("down"))
            {
                Game.blockArray[x-1][y] = 0;
            }
            else if(direction.contentEquals("left"))
            {
                Game.blockArray[x][y+1] = 0;
            }
            else if(direction.contentEquals("right"))
            {
                Game.blockArray[x][y-1] = 0;
            }
            EnemyTank et = new EnemyTank(possitionX, possitionY, direction);
            et.moveTank();
            
        }
        else
        {
            
             Random randomGenerator = new Random();
             int randomInt = randomGenerator.nextInt(4);
             String newDirection = rotate[randomInt];
             if(newDirection.contentEquals(direction))
             {
                 
             }
             else
             {
                direction = newDirection;
                EnemyTank et = new EnemyTank(possitionX, possitionY, direction);
                et.moveTank();
             }
             
             
             
        }
        return;
    }
    
    public void run()
    {
        int x=0,y=0;
        while(true)
        {
            if(Game.blockArray[possitionX][possitionY]==0 )
            {
                break;
            }
            
            if(direction.contentEquals("up"))
            {
                if(possitionX>0) x=possitionX-1;
                y=possitionY;
                
                checkPosition(x, y);
                
            }
            else if(direction.contentEquals("down"))
            {
                if(possitionX<16) x=possitionX+1;
                y=possitionY;
                checkPosition(x, y);
                
            }
            else if(direction.contentEquals("left"))
            {
                x=possitionX;
                if(possitionY>0) y=possitionY-1;
                checkPosition(x, y);
            }
            else if(direction.contentEquals("right"))
            {
                x=possitionX;
                if(possitionY<16) y=possitionY+1;
                checkPosition(x, y);
            }
           
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(EnemyThread1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Random randomGenerator = new Random();
            int gunLoder = randomGenerator.nextInt(3);
            if(direction.contentEquals("up")&& Game.blockArray[possitionX-1][possitionY] ==0 && gunLoder ==1)
            {
                bt.fireBullet(possitionX-1, possitionY, "up", "enemy1");
            }
            else if(direction.contentEquals("down")&& Game.blockArray[possitionX+1][possitionY] ==0 && gunLoder ==1)
            {
                bt.fireBullet(possitionX+1, possitionY, "down", "enemy1");
            }
            else if(direction.contentEquals("left")&& Game.blockArray[possitionX][possitionY-1] ==0 && gunLoder ==1)
            {
                bt.fireBullet(possitionX, possitionY-1, "left", "enemy1");
            }
            else if(direction.contentEquals("right")&& Game.blockArray[possitionX][possitionY-1] ==0 && gunLoder ==1)
            {
                bt.fireBullet(possitionX, possitionY+1, "right", "enemy1");
            }
            
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(EnemyThread1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return;
    }
    
}
