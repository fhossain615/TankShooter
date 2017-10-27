/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Menu.viewMenu;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class ScoreBoard extends Display {

    public static int score = 0;
    public static int lives = 3;
    public static String name = "Player Name";

    public void showUpdate() {

    }

    void createAndDisplayGUI(JFrame frame) {

        JPanel panel = new JPanel();
        Container pane = frame.getContentPane();
        //pane.setLayout(null);
        //panel.setLayout(null);
        panel.setBounds(600, 100, 300, 300);
        Font defaultFont = panel.getFont();
        //System.out.println("getX of panel "+panel.getX()+100);
        //pane.setLocation(900,100);
        JLabel labelName = new JLabel();
        labelName.setLayout(null);
        labelName.setFont(new Font("Courier", 1, 12));
        labelName.setText("      Player: " + name + "      ");
        //labelName.setBounds(600, 100, 300, 100);
        panel.add(labelName);
        JLabel labelScore = new JLabel();
        labelScore.setLayout(null);
        labelScore.setFont(new Font("Courier", 1, 12));
        labelScore.setText("     Score: " + score + "     ");
        //labelScore.setBounds(900, 500, 300, 100);
        panel.add(labelScore);
        JLabel labelLife = new JLabel();
        labelLife.setLayout(null);
        labelLife.setFont(new Font("Courier", 1, 12));
        //labelLife.setBounds(1200, 800, 300, 100);
        labelLife.setText("      Lives: " + lives + "     ");
        panel.add(labelLife);
        frame.add(panel);
        JButton returnToMenu = new JButton("Return to menu");
        returnToMenu.setLayout(null);
        //panel.setLayout(null);
        returnToMenu.setBounds(900, 800, 30, 30);
        returnToMenu.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewMenu();
                frame.setVisible(false);
                return;
            }
        }));
        panel.add(returnToMenu);
        panel.setVisible(true);
        frame.setVisible(true);

        
    }

}
