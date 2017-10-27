
package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;


public class Game {

    int numberOfBlocks = 17;
    public int score = 0;
    public int lives = 5;
    
    static JFrame mainFrame;
    
    public int blockForLevel1[][];

    public String name;

    public int level;

    public int speedTank;

    public int speedBullet;
    
    
    private int x;
    private int y;
    private int dir;
    private String[] commands = {
                                    "UP",
                                    "DOWN",
                                    "LEFT",
                                    "RIGHT"
                                }; 


    private  void openGame()
    {
        //Show the opening page
         
    }

    public  void showMenu()
    {
        
        //show menu
    }

                     

    private ActionListener panelAction = new ActionListener()
    {   
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            String command = (String) ae.getActionCommand();
            if (command.equals(commands[0])){
                dir = 1;
                y -= 10;   
                if(y<0){y=0;}
            }
            else if (command.equals(commands[1])){
                dir = 3;
                y += 10;
                if(y>450){y=450;}
            }
            else if (command.equals(commands[2])){
                dir = 4;
                x -= 10;
                if(x<0){x=0;}
            }
            else if (command.equals(commands[3])){
                dir = 2;
                x += 10;
                if(x>450){x=450;}
            }
        }
    };

    static JFrame createFrame(){
        mainFrame = new JFrame();
        mainFrame.setSize(665,665);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return mainFrame;
    }
   
    public void exitGame()
    {
        //save every data needed for next time and exit the game

    }
    public static void main(String[] args) throws IOException 
    {
        //drawBackground();
        mainFrame = createFrame();
        Menu menu = new Menu();
        Menu.viewMenu();
    }
    
}
