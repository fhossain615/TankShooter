
package Game;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* 
    manage the bullet's movement and scoring

Author : Md.Faruk Hoaasin

*/

public class BulletThread extends Thread{
    private static int[] checker ={0,0,0,0,0};
    private static int[] possitionX ={0,0,0,0,0};
    private static int[] possitionY ={0,0,0,0,0};
    public static String[] direction = new String[5];
    public static int[] previousX ={0,0,0,0,0};
    public static int[] previousY ={0,0,0,0,0};
    public static int killer=0;
    UserBullet uBullet = new UserBullet();
    EnemyBullet eBullet = new EnemyBullet();
    SuperBullet sBullet = new SuperBullet();
    
    
    public BulletThread() {
       
    }
    public void fireBullet(int possitionX,int possitionY, String direction, String owner)
    {
        if(owner.contentEquals("enemy0") && checker[0] ==0)
        {
            this.possitionX[0]=possitionX;
            this.possitionY[0]=possitionY;
            this.direction[0]=direction;
            this.checker[0]=1;
            System.out.println(direction+" "+owner+" "+" "+possitionX+" "+possitionY);
           
        }
        else if(owner.contentEquals("enemy1") && checker[1] ==0)
        {
            this.possitionX[1]=possitionX;
            this.possitionY[1]=possitionY;
            this.direction[1]=direction;
            this.checker[1]=1;
        }
        else if(owner.contentEquals("boss") && checker[2] ==0)
        {
            this.possitionX[2]=possitionX;
            this.possitionY[2]=possitionY;
            this.direction[2]=direction;
            this.checker[2]=1;
        }
        else if(owner.contentEquals("user") && checker[3] ==0)
        {
            this.possitionX[3]=possitionX;
            this.possitionY[3]=possitionY;
            this.direction[3]=direction;
            this.checker[3]=1;
        }
        else
        {
           
        }
    }
    public void killThread()
    {
        
        for(int i=0; i<5; i++)
        {
            if(checker[i] == 1)
            {
                Game.blockArray[possitionX[i]][possitionY[i]] = 13;
            }
            checker[i]=0;
        }
       Thread.interrupted();
        return;
    }
    public void run()
    {
        while(true)
        {
            
            for(int checkerIndex=0; checkerIndex<5; checkerIndex++ )
            {
                if(checker[checkerIndex] == 1)
                {
                    
                    if(Game.blockArray[possitionX[checkerIndex]][possitionY[checkerIndex]]!=0)
                    {
                        System.out.println(Game.blockArray[possitionX[checkerIndex]][possitionY[checkerIndex]]);
                        if(checkerIndex == 3 && (Game.blockArray[possitionX[checkerIndex]][possitionY[checkerIndex]] ==9 || Game.blockArray[possitionX[checkerIndex]][possitionY[checkerIndex]] == 10 || Game.blockArray[possitionX[checkerIndex]][possitionY[checkerIndex]] == 11|| Game.blockArray[possitionX[checkerIndex]][possitionY[checkerIndex]] ==12))
                        {
                            //never cut off comment below. if you want to destroy user Tank if a bullet hits it then uncomment it
                     
                            Game.score += 10;
                            checker[checkerIndex]=0;
                            
                        }
                        else if((checkerIndex == 0 || checkerIndex==1) && (Game.blockArray[possitionX[checkerIndex]][possitionY[checkerIndex]] ==5 || Game.blockArray[possitionX[checkerIndex]][possitionY[checkerIndex]] == 6 || Game.blockArray[possitionX[checkerIndex]][possitionY[checkerIndex]] == 7|| Game.blockArray[possitionX[checkerIndex]][possitionY[checkerIndex]] ==8))
                        {
                            Game.lives--;
                            checker[checkerIndex] = 0;
                            if(Game.lives<0){
                                EnemyThread0 e0Thread = new EnemyThread0(0, 0, "up");
                                EnemyThread1 e1Thread = new EnemyThread1(0, 0, "up");
                                
                                Game.score = 0;
                                Game.lives = 3;
                                LeaderBoard leaderboard = new LeaderBoard();
                                try {
                                    leaderboard.changeBoard(Game.score, Game.name);
                                    Menu.viewMenu();
                                } catch (IOException ex) {
                                    Logger.getLogger(BulletThread.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                Game.mainFrame.setVisible(false);
                                //Menu.viewMenu();
                            }
                        }
                        else
                        {
                            checker[checkerIndex] = 0;
                        }
                        
                    } 
                    else
                    {
                        if(direction[checkerIndex].contentEquals("up"))
                        {
                            if(checkerIndex == 3)
                            {
                                uBullet.moveBullet(possitionX[checkerIndex], possitionY[checkerIndex]);
                            }
                            else if(checkerIndex == 3 && Game.score>50)
                            {
                                sBullet.moveBullet(possitionX[checkerIndex], possitionY[checkerIndex]);
                            }
                            else if(checkerIndex == 0 || checkerIndex == 1 || checkerIndex == 2)
                            {
                                eBullet.moveBullet(possitionX[checkerIndex], possitionY[checkerIndex]);
                            }
                            previousX[checkerIndex] = possitionX[checkerIndex];
                            previousY[checkerIndex] = possitionY[checkerIndex];
                            possitionX[checkerIndex]--;
                            
                            
                        }
                        else if(direction[checkerIndex].contentEquals("down"))
                        {
                            if(checkerIndex == 3)
                            {
                                uBullet.moveBullet(possitionX[checkerIndex], possitionY[checkerIndex]);
                            }
                            else if(checkerIndex == 3 && Game.score>50)
                            {
                                sBullet.moveBullet(possitionX[checkerIndex], possitionY[checkerIndex]);
                            }
                            else if(checkerIndex == 0 || checkerIndex == 1 || checkerIndex == 2)
                            {
                                eBullet.moveBullet(possitionX[checkerIndex], possitionY[checkerIndex]);
                            }
                            previousX[checkerIndex] = possitionX[checkerIndex];
                            previousY[checkerIndex] = possitionY[checkerIndex];
                            possitionX[checkerIndex]++;
                            
                            
                        }
                        else if(direction[checkerIndex].contentEquals("right"))
                        {
                            if(checkerIndex == 3)
                            {
                                uBullet.moveBullet(possitionX[checkerIndex], possitionY[checkerIndex]);
                            }
                            else if(checkerIndex == 3 && Game.score>50)
                            {
                                sBullet.moveBullet(possitionX[checkerIndex], possitionY[checkerIndex]);
                            }
                            else if(checkerIndex == 0 || checkerIndex == 1 || checkerIndex == 2)
                            {
                                eBullet.moveBullet(possitionX[checkerIndex], possitionY[checkerIndex]);
                            }
                            previousX[checkerIndex] = possitionX[checkerIndex];
                            previousY[checkerIndex] = possitionY[checkerIndex];
                            possitionY[checkerIndex]++;
                            
                            
                        }
                        if(direction[checkerIndex].contentEquals("left"))
                        {
                            if(checkerIndex == 3)
                            {
                                uBullet.moveBullet(possitionX[checkerIndex], possitionY[checkerIndex]);
                            }
                            else if(checkerIndex == 3 && Game.score>50)
                            {
                                sBullet.moveBullet(possitionX[checkerIndex], possitionY[checkerIndex]);
                            }
                            else if(checkerIndex == 0 || checkerIndex == 1 || checkerIndex == 2)
                            {
                                eBullet.moveBullet(possitionX[checkerIndex], possitionY[checkerIndex]);
                            }
                            previousX[checkerIndex] = possitionX[checkerIndex];
                            previousY[checkerIndex] = possitionY[checkerIndex];
                            possitionY[checkerIndex]--;
                            
                            
                        }
                        else
                        {
                            
                        }
                        
                    }
                }
                
            }
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(BulletThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for(int i=0; i<5; i++)
            {
                if(previousX[i] != 0 && previousY[i] !=0)
                {
                    Game.blockArray[previousX[i]][previousY[i]] = 0;
                    previousX[i] =0;
                    previousY[i] =0;
                }
            }
            
        }
       
    }
    
}
