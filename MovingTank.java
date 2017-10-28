package game;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MovingTank
{
    void createAndDisplayGUI()
    {
        JFrame frame = Game.mainFrame;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanel contentPane = new DrawingPanel();
        frame.setContentPane(contentPane);
        frame.pack();
        //frame.setLocationByPlatform(true);
        frame.setVisible(true);
        contentPane.requestFocusInWindow();
    }

    public static void main(String... args)
    {
        //SwingUtilities.invokeLater(new Runnable()
        //{
            //public void run()
            //{
                new MovingTank().createAndDisplayGUI();
            //}
        //});
    }
}

class DrawingPanel extends JPanel
{
    DrawingPanel(int x)
    {
        
    }
    private int x;
    private int y;
    int cmd=100;
    int number_key=0;
    int Score;
    private String[] commands = {
                                    "UP",
                                    "DOWN",
                                    "LEFT",
                                    "RIGHT"
                                };   
    int z;
   void  update_array()
    {
        
        
    }
   String sw;
   
   
   
   
   
   int[][]   Array_change(String s,int[][] k)
   {
       
       
   sw=s;
   String d;
   int match;
       if(s.equalsIgnoreCase("Left"))
       {
           if(Game.userTankY>0) Game.userTankY--;
           Game.blockArray[Game.userTankX][Game.userTankY] = 5;
           
       }
       if(s.equalsIgnoreCase("Right"))
       {
           if(Game.userTankY<16)Game.userTankY++;
           Game.blockArray[Game.userTankX][Game.userTankY] = 5;
           
       }
       
       
        if(s.equalsIgnoreCase("Up"))
       {
           
           if(Game.userTankX>0) Game.userTankX--;
           Game.blockArray[Game.userTankX][Game.userTankY] = 5;
           
       }
          if(s.equalsIgnoreCase("Down"))
       {
          
           if(Game.userTankX<16) Game.userTankX++;
           Game.blockArray[Game.userTankX][Game.userTankY] = 5;
           
       }
        
      
       return k;
      
   }
   int X,Y;
   int [][]number=new int[][]{
       {0,0,0,0},{0,0,0,0},{0,0,0,0},{1,0,0,0}};
 
   

  
    
    


    private ActionListener panelAction = new ActionListener()
    {   
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            String command = (String) ae.getActionCommand();
            if (command.equals(commands[0]))
            {
                cmd =0;
            }
            else if (command.equals(commands[1]))
            {
                 cmd =1;
            }
            else if (command.equals(commands[2]))
            {
                 cmd =2;
            }
            else if (command.equals(commands[3]))
            {
                 cmd =3;
            }

            repaint();  
        }
    };

    public DrawingPanel()
    {
        x = 0;
        y = 0;

        for (int i = 0; i < commands.length; i++)       
            registerKeyboardAction(panelAction,
                            commands[i],
                            KeyStroke.getKeyStroke(commands[i]),
                            JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    
    public Dimension getPreferredSize()
    {
        return (new Dimension(600,600));
    }

    
    public void paintComponent(Graphics g)
    {
       
        String s="qq";
        
        int r2,r1,p1=0,p2=0;
        super.paintComponent(g);
        
    
       
        int a,c=0;
        Random rand =new Random();
        if(cmd==1)
            s="Down";
        if(cmd==0)
            s="Up";
        if(cmd==3)
            s="Right";
        if(cmd==2)
            s="Left";
        number_key=0;
        for(int h=0;h<4;h++)
        {
            for(int tr=0;tr<4;tr++)
            {
                if(number[h][tr]!=0)
                    number_key++;
            }
        }
       
        r1=rand.nextInt(4);
        r2=rand.nextInt(4);
        while(number[r1][r2]!=0&&number_key!=16){
            r1=rand.nextInt(4);
            r2=rand.nextInt(4);
        }
        number[r1][r2]=1;
      
        if(number_key<16 && c!=0) {
            DrawFunc d = new DrawFunc(Game.blockArray);
            d.paint(g);
        }               
        X=x;
        Y=y;
         int [][]l;
         for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
        a=number[i][j];
        if(a!=0)
        {
            int w=0,e=0;
            l=Array_change(s,number);
            for(j=0;j<4;j++)
            {
             for( i=0;i<4;i++)
             {
                number[i][j]=l[i][j];
                 a=l[i][j];
               
                   c=1;
                  
                 if(a!=0)
                 {
                     w=j;
                     e=i;
                   
                 }
                
  
     
        if(true){
            int abd=9;
           if(number_key==16 && abd==9){
                String d;
                ImageIcon icon =new ImageIcon("2048.jpg");
                setVisible(false);
                d=Integer.toString(Score);
                JFrame fd=new JFrame();
                fd.setBounds(50,50,600,600);
                abd=0;
                setVisible(false);
                JLabel label=new JLabel(icon);
                 JLabel label_1=new JLabel(icon);
                label_1.setText("  Game over !!!");
                label.setText("Score "+d);
                label_1.setBounds(00,00,160,150);
                Font ft=new Font("Arival",Font.PLAIN,40);
                label.setFont(ft);
                label_1.setFont(ft);
                label.setBounds(200, 200, 230, 250);
                 
                fd.add(label);
                fd.add(label_1);
                
                
                fd.setVisible(true);
                number_key=115;
           }
       
        DrawFunc d1 = new DrawFunc(Game.blockArray);
        d1.paint(g);
        }
        }
             System.out.println();
        }
        }
        }
        }
    }
}



 class DrawFunc extends Component {

    int numberOfBlocks = 17;
    public int score = 0;
    public int lives = 5;
    BufferedImage[] img = new BufferedImage[12];
    public int[][] blockArray;

    public void paint(Graphics g) {
        int p, q;
        for (int i = 0; i < numberOfBlocks; i++) {
            for (int j = 0; j < numberOfBlocks; j++) {
                g.drawImage(img[this.blockArray[j][i]], (i+1) * 35 - 10, (j+1) * 35 + 20, null);
                System.out.println("i " + i + " " + "j " + j);
            }
        }

    }

    public DrawFunc(int[][] blockArray) {

        this.blockArray = blockArray;
        try {
            img[0] = ImageIO.read(new File("0.jpg"));
            img[1] = ImageIO.read(new File("1.jpg"));
            img[2] = ImageIO.read(new File("2.jpg"));
            img[3] = ImageIO.read(new File("3.jpg"));
            img[4] = ImageIO.read(new File("4.jpg"));
            img[5] = ImageIO.read(new File("5.jpg"));
            img[6] = ImageIO.read(new File("6.jpg"));
            img[7] = ImageIO.read(new File("7.jpg"));
            img[8] = ImageIO.read(new File("8.jpg"));
        } catch (IOException o) {
            System.out.println("File not found");
        }

    }
 }