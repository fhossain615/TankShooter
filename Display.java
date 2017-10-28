
package game;

import javax.swing.JButton;
import javax.swing.JFrame;


public abstract class Display {
    JFrame frame;
    String frameName;
    public static int score;
    public static int lives;
    public static String name;
    public static int battleField[][];
    public void updateData(int score,int lives,String name)
    {
        this.score = score;
        this.lives = lives;
        this.name = name;
    }
    public void updateBattleField(int battleField[][])
    {
        this.battleField = battleField;
    }
    
    
    abstract void createAndDisplayGUI(); 
    
    public void showUpdate()
    {
        
    }
    
}
