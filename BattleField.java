package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.*;
/* 
    Draw the battle ground

Author : Dewan Tariq Hasan
Author : Md. Faruk Hossain (only inside the action litchener of 'Z')

*/

@SuppressWarnings("serial")
public class BattleField extends JPanel{

    private static final String UP = "UP";
    private static final String DOWN = "DOWN";
    private static final String LEFT = "LEFT";
    private static final String RIGHT = "RIGHT";
    private static final String Z = "Z";
    private static final Color BACKGROUND = Color.black;
    private static final Dimension PREF_SIZE = new Dimension(665, 665);
    private int x = 300;
    private int y = 300;
   
    public static int xIndex = 8;
    public static int yIndex = 8;
    public static  int prevXIndex = 8;
    public static int prevYIndex = 8;
    boolean isFieldDrawn;
    int imageNum;
    String direction = "up";
    static JFrame frame;
    BufferedImage[] img = new BufferedImage[25];
    BulletThread bthread =new BulletThread();
    public BattleField() throws IOException {
        Game.blockArray[xIndex][yIndex] = 5;
        frame = Game.mainFrame;
        isFieldDrawn = false;
        imageNum = 5;
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
            img[9] = ImageIO.read(new File("9.jpg"));
            img[10] = ImageIO.read(new File("10.jpg"));
            img[11] = ImageIO.read(new File("11.jpg"));
            img[12] = ImageIO.read(new File("12.jpg"));
            img[13] = ImageIO.read(new File("13.gif"));
            img[14] = ImageIO.read(new File("0.jpg")); // background
            img[15] = ImageIO.read(new File("15.gif")); //enemybullet
            img[16] = ImageIO.read(new File("16.gif")); //bossbullet
        } catch (IOException o) {
            System.out.println("File not found");
        }
        setBackground(BACKGROUND);

        int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
        InputMap inputMap = getInputMap(condition);
        ActionMap actionMap = getActionMap();

        BulletThread bullet = new BulletThread();
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), UP);
        actionMap.put(UP, new AbstractAction() {
            public void actionPerformed(ActionEvent arg0) {
                if(x>=5) x -= 5;
                imageNum = 5;   
                direction = "up";
                yIndex = (y-10)/35;
                xIndex = (x-10)/35;
                
                if(xIndex<=16 && xIndex>=0 && Game.blockArray[xIndex][yIndex]==0 && prevXIndex != xIndex ){
                    Game.blockArray[xIndex][yIndex] = 5;
                    Game.blockArray[prevXIndex][yIndex] = 14;
                    prevXIndex = xIndex;
                }
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), DOWN);
        actionMap.put(DOWN, new AbstractAction() {
            public void actionPerformed(ActionEvent arg0) {
                if(y<=595) x += 5;
                imageNum = 7;
                direction = "down";
                yIndex = (y-10)/35;
                xIndex = (x-10)/35;
                
                if(xIndex<=16 && xIndex>=0 && Game.blockArray[xIndex][yIndex]==0 && prevXIndex != xIndex ){
                    Game.blockArray[xIndex][yIndex] = 7;
                    Game.blockArray[prevXIndex][yIndex] = 14;
                    prevXIndex = xIndex;
                }
                
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), LEFT);
        actionMap.put(LEFT, new AbstractAction() {
            public void actionPerformed(ActionEvent arg0) {
                if(y>=5) y -= 5;
                imageNum = 8;
                direction = "left";
                xIndex = (x-10)/35;
                yIndex = (y-10)/35;
                
                if(xIndex<=16 && xIndex>=0 && Game.blockArray[xIndex][yIndex]==0 && prevYIndex != yIndex ){
                    Game.blockArray[xIndex][yIndex] = 8;
                    Game.blockArray[xIndex][prevYIndex] = 14;
                    prevYIndex = yIndex;
                } 
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), RIGHT);
        actionMap.put(RIGHT, new AbstractAction() {
            public void actionPerformed(ActionEvent arg0) {
                if(y<=595) y += 5;
                imageNum = 6;
                direction = "right";
                xIndex = (x-10)/35;
                yIndex = (y-10)/35;
                
                if(xIndex<=16 && xIndex>=0 && Game.blockArray[xIndex][yIndex]==0 && prevYIndex != yIndex ){
                    Game.blockArray[xIndex][yIndex] = 6;
                    Game.blockArray[xIndex][prevYIndex] = 14;
                    prevYIndex = yIndex;
                }
            }
        });
        
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0), Z);
        
        actionMap.put(Z, new AbstractAction() {
            public void actionPerformed(ActionEvent arg0) {
               
                int x=0,y=0;
                x=xIndex;
                y=yIndex;
                if(direction.contentEquals("up"))
                {
                    x=x-1;
                    if(Game.blockArray[x][y]==0)
                    {
                        bthread.fireBullet(x, y, direction, "user");
                    }
                }
                else if(direction.contentEquals("down"))
                {
                    x=x+1;
                    if(Game.blockArray[x][y]==0)
                    {
                        bthread.fireBullet(x, y, direction, "user");
                    }
                }
                else if(direction.contentEquals("left"))
                {
                    y=y-1;
                    if(Game.blockArray[x][y]==0)
                    {
                        bthread.fireBullet(x, y, direction, "user");
                    }
                }
                else if(direction.contentEquals("right"))
                {
                    y=y+1;
                    if(Game.blockArray[x][y]==0)
                    {
                        bthread.fireBullet(x, y, direction, "user");
                    }
                }
                
               
            }
        });
        
        this.setPreferredSize(new Dimension(665, 665));
  
      Thread fieldThread = new Thread() {
         public void run() {
            while (true) { 
               // Refresh the display
               repaint(); // Callback paintComponent()
               // Delay for timing control and give other threads a chance
               try {
                  Thread.sleep(100);  // milliseconds
               } catch (InterruptedException ex) { }
            }
         }
      };
      fieldThread.start();  // Callback run()
    
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
            
            
                for (int i = 0; i < 17; i++) {
                    for (int j = 0; j < 17; j++) {               
                        if(Game.blockArray[j][i]>0) {
                            g2.drawImage(img[Game.blockArray[j][i]], (i + 1) * 35 - 10, (j + 1) * 35 + 10, null);
                            if(Game.blockArray[j][i]==14){
                                Game.blockArray[j][i]=0;
                            }
                        }
                    }
                }
        
    }

    static void createAndDisplayGUI() throws IOException {
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.add(new BattleField());
        panel.setBounds(25, 60, 600, 600);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndDisplayGUI();
                } catch (IOException ex) {
                    Logger.getLogger(BattleField.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
}
