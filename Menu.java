
package game;

import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Menu extends JPanel{
    int option;
    static JFrame frame;
    Menu menu;
    
    static Scanner sc = new Scanner(System.in);
      static  int n;
    
    public static void addComponentsToPane(Container pane) {
        pane.setLayout(null);

        JButton b1 = new JButton("Start Game");
        JButton b2 = new JButton("Help");
        JButton b3 = new JButton("Leader Board");
        JButton b4 = new JButton("Exit");

        pane.add(b1);
        pane.add(b2);
        pane.add(b3);
        pane.add(b4);
        
        

        Insets insets = pane.getInsets();
        b1.setBounds(250 + insets.left, 220 + insets.top,
                     140, 30);
        b1.addActionListener( new ActionListener(){
            @Override
            
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("The game starts.");
                TankThread tt1 = new TankThread(6, 4, "up");
                tt1.start();
                //TankThread tt2 = new TankThread(1, 1, "down");
                //tt2.start();
                
                frame.setVisible(false);
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        
                        ScoreBoard score = new ScoreBoard();
                        
                       BattleField field = null; 
                        try {
                            field = new BattleField();
                        } catch (IOException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            field.createAndDisplayGUI();
                        } catch (IOException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        score.createAndDisplayGUI();
                       frame.pack();
                    }
                 });
                
            }
        });
        b2.setBounds(250 + insets.left, 270 + insets.top,
                     140, 30);
        b2.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("The help info is displayed.");
                Help help = new Help();
                help.showInstruction();
                
                frame.setVisible(false);
            }
        });
        b3.setBounds(250 + insets.left, 320 + insets.top,
                     140, 30);
        b3.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("The leaderboard is displayed.");
                LeaderBoard lb = new LeaderBoard();
                try {
                    lb.showLeaderBoard();
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                frame.setVisible(false);
            }
        });
        b4.setBounds(250 + insets.left, 380 + insets.top,
                     140, 30);
        b4.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("The game is exited.");
                frame.setVisible(false);
                
                frame.dispose();
                System.exit(WIDTH);
                
            }
        });
        
    }
    
    static void viewMenu() {
        
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        Insets insets = frame.getInsets();
        frame.setSize(665,665);
        frame.setVisible(true);
    }
   
}