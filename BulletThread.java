
package game;

import static game.TankThread.direction;
import static game.TankThread.possitionX;
import static game.TankThread.possitionY;


public class BulletThread extends Thread{
    public static int possitionX;
    public static int possitionY;
    public static String direction;
    public static String owner;
    
    UserBullet uBullet = new UserBullet();
    EnemyBullet eBullet = new EnemyBullet();
    SuperBullet sBullet = new SuperBullet();
    
    Game game =new Game();
    
    public BulletThread(int possitionX,int possitionY, String direction, String Owner) {
        this.possitionX = possitionX;
        this.possitionY = possitionY;
        this.direction = direction;
        this.owner = owner;
    }
    private void checkPosition(int x, int y)
    {
        
    }
    public void run()
    {
        int x,y;
        while(true)
        {
            if(game.blockArray[possitionX][possitionY]!=0)
            {
                if(owner.contentEquals("user") && (game.blockArray[possitionX][possitionY] ==9 || game.blockArray[possitionX][possitionY] == 10 || game.blockArray[possitionX][possitionY] == 11|| game.blockArray[possitionX][possitionY] ==12))
                {
                    game.blockArray[possitionX][possitionY] = 0;
                    game.score += 10;
                }
                
               else if(owner.contentEquals("enemy") && (game.blockArray[possitionX][possitionY] ==5 || game.blockArray[possitionX][possitionY] == 6 || game.blockArray[possitionX][possitionY] == 7|| game.blockArray[possitionX][possitionY] ==8))
               {
                   game.lives--;
               }
                break;
            }
            else
            {
                if(direction.contentEquals("up"))
                {
                    if(owner.contentEquals("user"))
                    {
                        uBullet.moveBullet(possitionX, possitionY);
                    }
                    else if(owner.contentEquals("super user"))
                    {
                        sBullet.moveBullet(possitionX, possitionY);
                    }
                    else if(owner.contentEquals("enemy"))
                    {
                        eBullet.moveBullet(possitionX, possitionY);
                    }
                    possitionY--;
                    
                
                }
                else if(direction.contentEquals("down"))
                {
                    if(owner.contentEquals("user"))
                    {
                        uBullet.moveBullet(possitionX, possitionY);
                    }
                    else if(owner.contentEquals("super user"))
                    {
                        sBullet.moveBullet(possitionX, possitionY);
                    }
                    else if(owner.contentEquals("enemy"))
                    {
                        eBullet.moveBullet(possitionX, possitionY);
                    }
                    possitionY++;
                }
                else if(direction.contentEquals("left"))
                {
                    if(owner.contentEquals("user"))
                    {
                        uBullet.moveBullet(possitionX, possitionY);
                    }
                    else if(owner.contentEquals("super user"))
                    {
                        sBullet.moveBullet(possitionX, possitionY);
                    }
                    else if(owner.contentEquals("enemy"))
                    {
                        eBullet.moveBullet(possitionX, possitionY);
                    }
                    possitionX--;
                }
                else if(direction.contentEquals("right"))
                {
                    if(owner.contentEquals("user"))
                    {
                        uBullet.moveBullet(possitionX, possitionY);
                    }
                    else if(owner.contentEquals("super user"))
                    {
                        sBullet.moveBullet(possitionX, possitionY);
                    }
                    else if(owner.contentEquals("enemy"))
                    {
                        eBullet.moveBullet(possitionX, possitionY);
                    }
                    possitionX++;
                }
            }
        }
    }
    
}