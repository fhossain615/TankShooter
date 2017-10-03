/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class Game {

    
    public static int pixelArray[][]={
            {1,1,1,1,1,1,1,1},
            {1,0,1,1,2,1,1,1},
            {1,0,0,2,0,5,0,1},
            {1,1,0,1,1,1,1,1},
            {1,1,0,0,0,1,1,1},
            {1,1,0,0,0,0,0,6},
            {1,1,0,5,5,5,1,1},
            {0,1,0,0,0,0,0,1},
            {0,1,1,1,1,0,0,1},
    };

    public int blockForLevel1[][];

    private String name;

    public int level;

    public int speedTank;

    public int speedBullet;
    
    



    private  void openGame()
    {
        //Show the opening page
         
    }

    public  void showMenu()
    {
        
        //show menu
    }


    public static void drawBackground()
    {
        //change pixelarray for the next round
        new Game().createAndDisplayGUI();
        
    }

    private void createAndDisplayGUI()
    {
        JFrame frame = new JFrame("Tank Field");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanel contentPane = new DrawingPanel();
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        contentPane.requestFocusInWindow();
    }
    
class DrawingPanel extends JPanel
{
    /*int[][] mainArray={
            {1,1,1,1,1,1,1,1},
            {1,0,1,1,2,1,1,1},
            {1,0,0,2,0,5,0,1},
            {1,1,0,1,1,1,1,1},
            {1,1,0,0,0,1,1,1},
            {1,1,0,0,0,0,0,6},
            {1,1,0,5,0,0,1,1},
            {0,1,0,0,0,0,0,1},
            {0,1,0,0,0,0,0,1},
        };*/
    


    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(320,320));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        DrawFunc d = new DrawFunc(pixelArray);
        d.paint(g);
    }
}

 class DrawFunc extends Component {

    BufferedImage[] img = new BufferedImage[12];
    int[][] mainArray;
    public void paint(Graphics g) {
      int p,q;
          for(int i=0;i<8;i++){
              for(int j=0;j<8;j++){
                  g.drawImage(img[mainArray[j][i]],i*40,j*40, null);
              }
          }
    }
    
    public DrawFunc(int[][] mainArray) {
        
        this.mainArray = mainArray;
        try{
            img[1] = ImageIO.read(new File("1.jpg"));
            img[2] = ImageIO.read(new File("2.jpg"));
            img[3] = ImageIO.read(new File("3.jpg"));
            img[4] = ImageIO.read(new File("4.jpg"));
            img[5] = ImageIO.read(new File("5.jpg"));
            img[6] = ImageIO.read(new File("6.jpg"));
            img[7] = ImageIO.read(new File("7.jpg"));
            img[8] = ImageIO.read(new File("8.jpg"));
            /*img[9] = ImageIO.read(new File("512.jpg"));
            img[10] = ImageIO.read(new File("1024.jpg"));
            img[11] = ImageIO.read(new File("2048.jpg"));*/
        } 
        catch (IOException o)
        {
            System.out.println("File not found");
        }
        
    }
 }
   
    public  void exitGame()
    {
        //save every data needed for next time and exit the game

    }
    public static void main(String[] args) 
    {
        //drawBackground();
        LeaderBoard lb = new LeaderBoard();
        lb.showLeaderBoard();
    }
    
}
