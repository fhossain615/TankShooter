
package Game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;

/* 
    carry all the share data and start the menu

Author : Md.Faruk Hoaasin
Author : Dewan Tariq Hasan
Author : Md Mizanur Rahman
*/
public class Game {

    int numberOfBlocks = 17;
    public static int score = 0;
    public static int lives = 3;
    public static String name="name";
    static JFrame mainFrame;
    
    public int blockForLevel1[][];

    

    public int level;

    public int speedTank;

    public int speedBullet;
    
    public static Graphics g;
    
    public static int userTankX = 0, userTankY = 0;
    
     public static int blockArray[][] = {
        {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0},
        {1, 0, 0, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 2, 0},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0},
        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 2, 0},
        {1, 1, 0, 0, 0, 0, 0, 0, 5, 0, 0, 1, 1, 0, 0, 2, 0},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0},
        {1, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0},
        {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 2, 0},
        {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 2, 0},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0}};

    
    private int x;
    private int y;
    private int dir;
    private String[] commands = {
                                    "UP",
                                    "DOWN",
                                    "LEFT",
                                    "RIGHT"
                                };             

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
        mainFrame.setSize(665,720);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        return mainFrame;
    }
   
    
    public static void main(String[] args) throws IOException 
    {
       
        mainFrame = createFrame();
        Menu menu = new Menu();
        Menu.viewMenu();
    }
    
}
