
package game;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
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
    
    JFrame createFrame(){
        frame = new JFrame();
        frame.setSize(665,665);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }
    
    abstract void createAndDisplayGUI(JFrame frame); 
    
    public void showUpdate()
    {
        
    }
    
}
