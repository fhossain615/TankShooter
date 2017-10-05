
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


public class LeaderBoard extends Menu{
    private static String[] leaderName = new String[3];
    
    public void showLeaderBoard()
    {
        //read from file
        File file = new File("leaders.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader lines = new BufferedReader(fileReader);
        
        for(int i=0; i<3 ; i++)
        {
            leaderName[i]=lines.readLine();
        }
         ///////////////////////////////  
        JFrame frame = new JFrame("         Tank Shooter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1000, 600);
        
        JPanel panel = new JPanel();
        
     
        JLabel label = new JLabel("Leader Board",JLabel.CENTER);
        label.setFont(new Font("Calibri", 1, 40));
      
        //////////////
        DefaultListModel<String> l1 = new DefaultListModel<>();  
        l1.addElement(leaderName[0]);  
        l1.addElement(leaderName[1]);  
        l1.addElement(leaderName[2]);  
 
        JList<String> list = new JList<>(l1);  
        list.setBounds(400,200, 200,100);  
        list.setFont(list.getFont().deriveFont(22.0f));
        frame.add(list);  
        /////////////////////
        
        
        JButton back = new JButton("Back");
        //panel.setLayout(null);
        back.setBounds(20,800,30,30);
        back.addActionListener((new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
             frame.setVisible(false);
             return;
            }  
        }));  
        panel.add(back);
        panel.add(label);
        frame.add(panel);
          
        frame.setVisible(true);
        
    }
    public void changeBoard(int score,String name)
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
        //System.out.println(topThree[0]);
        String[] second = leaderName[1].split("\\s+");
        topThree[1]=Integer.valueOf(second[1]);
        String[] thard = leaderName[1].split("\\s+");
        topThree[2]=Integer.valueOf(thard[1]);
        
        if(score<=topThree[2])
            return;
        else
        {
            //topThree[2]=score;
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
            
            //write on  file
            
            PrintWriter pw =new PrintWriter(file);
        
            for(int i=0; i<3 ; i++)
            {
                pw.write(leaderName[i]);
            }
            pw.close();
            ///////////////////////////////  
        }
        
    }
}
