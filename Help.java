
package Game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/* 
    show the instruction of the game

Author : Md Mizanur Rahman
*/
public class Help {
    private static final String[] help = {"1.Press 'Z' button to shoot","2.Use  left((<<) right(>>) to move"
            ,"3.Achieve 10 Points hitting enemy","4.Life decreases when enemy bullets hit",
            "5.End of lives will turn the Game over"};
    
    
    
    public void showInstruction()
    {
        JFrame frame = new JFrame("         Tank Shooter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(665,665); 
        Container pane= frame.getContentPane();
        pane.setLayout(null);
        
        JButton back = new JButton("Back");
        JLabel label = new JLabel("Help");
        JLabel instruction0 = new JLabel(help[0]);
        JLabel instruction1 = new JLabel(help[1]);
        JLabel instruction2 = new JLabel(help[2]);
        JLabel instruction3 = new JLabel(help[3]);
        JLabel instruction4 = new JLabel(help[4]);
        
        pane.add(back);
        pane.add(label);
        pane.add(instruction0);
        pane.add(instruction1);
        pane.add(instruction2);
        pane.add(instruction3);
        pane.add(instruction4);
        
        Insets insets = pane.getInsets();
        back.setBounds(50 + insets.left, 50 + insets.top,
                     100, 30);
        back.addActionListener((new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
             Menu.viewMenu();
             frame.setVisible(false);
             return;
            }  
        }));
        
        label.setBounds(250 + insets.left, 100 + insets.top,
                     200, 100);
        label.setFont(new Font("Serif", Font.BOLD, 30));
        
        instruction0.setBounds(80 + insets.left, 150 + insets.top,
                     400, 100);
        instruction0.setForeground(Color.RED);
        instruction0.setFont(new Font("Serif", Font.BOLD, 20));
        
        instruction1.setBounds(80 + insets.left, 200 + insets.top,
                     400, 100);
        instruction1.setForeground(Color.RED);
        instruction1.setFont(new Font("Serif", Font.BOLD, 20));
        
        instruction2.setBounds(80 + insets.left, 250 + insets.top,
                     400, 100);
        instruction2.setForeground(Color.RED);
        instruction2.setFont(new Font("Serif", Font.BOLD, 20));
        
        instruction3.setBounds(80 + insets.left, 300 + insets.top,
                     400, 100);
        instruction3.setForeground(Color.RED);
        instruction3.setFont(new Font("Serif", Font.BOLD, 20));
        
        instruction3.setBounds(80 + insets.left, 350 + insets.top,
                     400, 100);
        instruction3.setForeground(Color.RED);
        instruction3.setFont(new Font("Serif", Font.BOLD, 20));
        
        instruction4.setBounds(80 + insets.left, 400 + insets.top,
                     400, 100);
        instruction4.setForeground(Color.RED);
        instruction4.setFont(new Font("Serif", Font.BOLD, 20));
        
        frame.setVisible(true);
        
    }
    
}
