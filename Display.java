
package game;

import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public abstract class Display {
    JFrame frame;
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
