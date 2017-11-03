
package Game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/* 
    show the leader board and chnage leaders when user become one of the top leaders

Author : Md.Faruk Hoaasin

*/
public class LeaderBoard{
    
    private static String[] leaderName = new String[3];
    
    public void showLeaderBoard() throws FileNotFoundException, IOException
    {
        
        File file = new File("leaders.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader lines = new BufferedReader(fileReader);
        
        for(int i=0; i<3 ; i++)
        {
            leaderName[i]=lines.readLine();
        }
        
        JFrame frame = new JFrame("         Tank Shooter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(665,665);
        
        Container pane= frame.getContentPane();
        pane.setLayout(null);
        
        JButton back = new JButton("Back");
        JLabel label = new JLabel("Leader Board");
        JLabel first = new JLabel(leaderName[0]);
        JLabel second = new JLabel(leaderName[1]);
        JLabel third = new JLabel(leaderName[2]);
        pane.add(back);
        pane.add(label);
        pane.add(first);
        pane.add(second);
        pane.add(third);
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

        label.setBounds(230 + insets.left, 100 + insets.top,
                     200, 100);
        label.setFont(new Font("Serif", Font.BOLD, 30));
        
        first.setBounds(250 + insets.left, 200 + insets.top,
                     140, 100);
        first.setForeground(Color.RED);
        first.setFont(new Font("Serif", Font.BOLD, 25));
        
        second.setBounds(250 + insets.left, 250 + insets.top,
                     140, 100);
        second.setForeground(Color.GREEN);
        second.setFont(new Font("Serif", Font.BOLD, 25));
        
        third.setBounds(250 + insets.left, 300 + insets.top,
                     140, 100);
        third.setForeground(Color.BLACK);
        third.setFont(new Font("Serif", Font.BOLD, 25));
        
        
        frame.setVisible(true);
        
    }
    public void changeBoard(int score,String name) throws FileNotFoundException, IOException
    {
      
        File file = new File("leaders.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader lines = new BufferedReader(fileReader);
        
        for(int i=0; i<3 ; i++)
        {
            leaderName[i]=lines.readLine();
        }
        
        int[] topThree = new int[3];
        String[] first = leaderName[0].split("\\s+");
        topThree[0]=Integer.valueOf(first[1]);
        String[] second = leaderName[1].split("\\s+");
        topThree[1]=Integer.valueOf(second[1]);
        String[] thard = leaderName[1].split("\\s+");
        topThree[2]=Integer.valueOf(thard[1]);
        
        if(score<=topThree[2])
            return;
        else
        {
     
            String myPosition = name+"  "+Integer.toString(score);
            if(score>topThree[0])
            {
                leaderName[2]=leaderName[1];
                leaderName[1]=leaderName[0];
                leaderName[0]=myPosition;
            }
            else if(score>topThree[1])
            {
                leaderName[2]=leaderName[1];
                leaderName[1]=myPosition;
                
            }
            else
            {
                leaderName[2]=myPosition;
            }
            PrintWriter pw =new PrintWriter(file);
        
            for(int i=0; i<3 ; i++)
            {
                pw.write(leaderName[i]);
            }
            pw.close();
            
        }
        
    }
}
