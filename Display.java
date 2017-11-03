
package Game;

import javax.swing.JFrame;
import javax.swing.JPanel;

/* 
    Abstruct class for display
Author : Md.Faruk Hoaasin

*/
public abstract class Display extends JPanel{
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
    
    
    public void showUpdate()
    {
        
    }
    
}
