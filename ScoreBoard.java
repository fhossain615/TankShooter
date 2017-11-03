
package Game;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/* 
    shows the score board on top of the display

Author : Dewan Tarikh Hasan

*/
public class ScoreBoard extends JPanel {

    BulletThread bthread = new BulletThread();
    JFrame frame;
    JLabel labelName = new JLabel();
    JLabel labelScore = new JLabel();
    JLabel labelLife = new JLabel();
    Game game = new Game();
    
    ScoreBoard(){
            Thread fieldThread = new Thread() {
         public void run() {
            while (true) { 
               
               showUpdate(); 
               try {
                  Thread.sleep(100);  // milliseconds
               } catch (InterruptedException ex) { }
            }
         }
      };
      fieldThread.start();
    }
   
    void createAndDisplayGUI() {

        frame = Game.mainFrame;
        JPanel panel = new JPanel();
        panel.setBounds(150, 0, 400, 150);
        Font defaultFont = panel.getFont();
        
        labelName.setLayout(null);
        labelName.setBackground(Color.yellow);
        labelName.setFont(new Font("Courier", 1, 12));
        labelName.setText("      Player: " + game.name + "      ");
        panel.add(labelName);
        
        labelScore.setLayout(null);
        labelScore.setBackground(Color.yellow);
        labelScore.setFont(new Font("Courier", 1, 12));
        labelScore.setText("     Score: " + game.score + "     ");
        panel.add(labelScore);
        
        labelLife.setOpaque(false);
        labelLife.setLayout(null);
        labelLife.setBackground(Color.yellow);
        labelLife.setFont(new Font("Courier", 1, 12));
        labelLife.setText("      Lives: " + game.lives + "     ");
        panel.add(labelLife);
        frame.add(panel);
        JButton returnToMenu = new JButton("Return to menu");
        returnToMenu.setLayout(null);
        returnToMenu.setBounds(900, 800, 30, 30);
        returnToMenu.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x =BattleField.xIndex;
                int y =BattleField.yIndex;
                Game.blockArray[x][y] = 0;
                x =BattleField.prevXIndex;
                y =BattleField.prevYIndex;
                Game.blockArray[x][y] = 0;
               // bthread.killThread();
                EnemyThread0 e0Thread = new EnemyThread0(0, 0, "up");
                //e0Thread.killThread();
                EnemyThread1 e1Thread = new EnemyThread1(0, 0, "up");
                Menu.viewMenu();
                frame.setVisible(false);
                return;
            }
        }));
        panel.add(returnToMenu);
        panel.setVisible(true);
        frame.setVisible(true);

        
    }
    
    public void showUpdate() {
        labelName.setText("      Player: " + game.name + "      ");
        labelScore.setText("     Score: " + game.score + "     ");
        labelLife.setText("      Lives: " + game.lives + "     ");
    }

}
