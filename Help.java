/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class Help {
    private static String[] help = {"1.Press Space button to shoot","2.Use  left((<<) right(>>) to move"
            ,"3.Destroying each tank will give you 20 points","4.Catching lives add a live and 10 points",
            "5.End of lives will turn the game over"};
    
    /*Menu menu;
    
    Help(Menu menu) {
        this.menu = menu;
    }*/
    
    public void showInstruction()
    {
        JFrame frame = new JFrame("         Tank Shooter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(665,665);
        
        JPanel panel = new JPanel();
        
     
        JLabel label = new JLabel("Help",JLabel.CENTER);
        label.setFont(new Font("Courier", 1, 15));
      
        //////////////
        DefaultListModel<String> l1 = new DefaultListModel<>();  
        l1.addElement(help[0]);  
        l1.addElement(help[1]);  
        l1.addElement(help[2]);  
        l1.addElement(help[3]);
        l1.addElement(help[4]);
        JList<String> list = new JList<>(l1);  
        list.setBounds(160,200,320,200); 
        list.setFont(new Font("Courier", 1, 15));
        frame.add(list);  
        /////////////////////
        
        
        JButton back = new JButton("Back");
        
        back.setBounds(20,800,30,30);
        back.addActionListener((new ActionListener(){  
            public void actionPerformed(ActionEvent e){ 
                Menu.viewMenu();
                
             frame.setVisible(false);
             return;
            }  
        }));  
        panel.add(back);
        panel.add(label);
        frame.add(panel);
          
        frame.setVisible(true);
        
    }
    
}
