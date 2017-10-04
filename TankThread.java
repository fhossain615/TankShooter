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
public class TankThread extends Thread{
     public static int possitionX;
    public static int possitionY;
    public static String direction;
    
    private static String[] rotate = {"up","down","left","right"};
    Game gm =new Game();

    public TankThread(int possitionX,int possitionY, String direction) {
        this.possitionX = possitionX;
        this.possitionY = possitionY;
        this.direction = direction;
    }
    
    private void checkPosition(int x, int y)
    {
        if(gm.pixelArray[x][y]==0)
        {
            possitionX = x;
            possitionY = y;
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
            if(gm.pixelArray[possitionX][possitionY]==0)
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
