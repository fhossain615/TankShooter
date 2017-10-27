/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author Admin
 */
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

class DrawingPanel extends JPanel {

    int numberOfBlocks = 17;
    //int[][] blockArray = new int[numberOfBlocks][];
    private int x;
    private int y;
    private int dir;
    private String[] commands = {
        "UP",
        "DOWN",
        "LEFT",
        "RIGHT"
    };
    
    public int blockArray[][] = {
        {0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 2, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 2, 0},
        {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0},
        {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0},
        {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0},
        {0, 2, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 1, 0, 0, 2, 0},
        {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0},
        {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0},
        {0, 2, 0, 0, 0, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 2, 0},
        {0, 2, 0, 0, 0, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 2, 0},
        {0, 2, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 0, 0, 0, 2, 0},
        {0, 2, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 0, 0, 0, 2, 0},
        {0, 2, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 0, 0, 0, 2, 0},
        {3, 3, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0},
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0},
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0},};

    public Dimension getPreferredSize() {
        return (new Dimension(650, 650));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        DrawFunc d = new DrawFunc(blockArray);
        d.paint(g);
    }

    private ActionListener panelAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = (String) ae.getActionCommand();
            if (command.equals(commands[0])) {
                dir = 1;
                y -= 10;
                if (y < 0) {
                    y = 0;
                }
            } else if (command.equals(commands[1])) {
                dir = 3;
                y += 10;
                if (y > 450) {
                    y = 450;
                }
            } else if (command.equals(commands[2])) {
                dir = 4;
                x -= 10;
                if (x < 0) {
                    x = 0;
                }
            } else if (command.equals(commands[3])) {
                dir = 2;
                x += 10;
                if (x > 450) {
                    x = 450;
                }
            }
        }
    };

    public DrawingPanel() {
        x = 0;
        y = 0;

        for (int i = 0; i < commands.length; i++) {
            registerKeyboardAction(panelAction,
                    commands[i],
                    KeyStroke.getKeyStroke(commands[i]),
                    JComponent.WHEN_IN_FOCUSED_WINDOW);
        }
    }
}

public class BattleField extends Display {
    
    
    public int[][] blockArray;

    void createAndDisplayGUI() {
        
        frame = Game.mainFrame;
        DrawingPanel contentPane = new DrawingPanel();
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        contentPane.requestFocusInWindow();
        JButton back = new JButton("Back");
        
    }
    

    public void showUpdate() {
    
    
    }

}
