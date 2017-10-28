/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import java.awt.Color;
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

    
    
    /*Menu menu;
    
    ScoreBoard(Menu menu) {
        this.menu = menu;
    }*/

    void createAndDisplayGUI() {

        frame = Game.mainFrame;
        JPanel panel = new JPanel();
        //Container pane = frame.getContentPane();
        panel.setBounds(600, 100, 100, 300);
        Font defaultFont = panel.getFont();
        JLabel labelName = new JLabel();
        labelName.setLayout(null);
        labelName.setBackground(Color.yellow);
        labelName.setFont(new Font("Courier", 1, 12));
        labelName.setFont(new Font("Courier", 1, 12));
        labelName.setText("      Player: " + name + "      ");
        panel.add(labelName);
        JLabel labelScore = new JLabel();
        labelScore.setLayout(null);
        labelScore.setBackground(Color.yellow);
        labelScore.setFont(new Font("Courier", 1, 12));
        labelScore.setText("     Score: " + score + "     ");
        panel.add(labelScore);
        JLabel labelLife = new JLabel();
        labelLife.setOpaque(false);
        labelLife.setLayout(null);
        labelLife.setForeground(Color.yellow);
        labelLife.setBackground(Color.yellow);
        labelLife.setFont(new Font("Courier", 1, 12));
        labelLife.setText("      Lives: " + lives + "     ");
        panel.add(labelLife);
        frame.add(panel);
        JButton returnToMenu = new JButton("Return to menu");
        returnToMenu.setLayout(null);
        returnToMenu.setBounds(900, 800, 30, 30);
        returnToMenu.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
        createAndDisplayGUI();
    }

}
