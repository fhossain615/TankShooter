package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.*;

@SuppressWarnings("serial")
public class BattleField extends JPanel {

    private static final String UP = "UP";
    private static final String DOWN = "DOWN";
    private static final String LEFT = "LEFT";
    private static final String RIGHT = "RIGHT";
    private static final Color BACKGROUND = Color.black;
    private static final Color BALL_COLOR = Color.yellow;
    private static final int BALL_WIDTH = 30;
    private static final int PREF_WIDTH = 500;
    private static final int PREF_HEIGHT = PREF_WIDTH;
    private static final Dimension PREF_SIZE = new Dimension(665, 665);
    private int x = PREF_WIDTH / 2;
    private int y = PREF_HEIGHT / 2;
    int imageNum;
    static JFrame frame;
    BufferedImage[] img = new BufferedImage[12];

    public BattleField() throws IOException {
        frame = Game.mainFrame;
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
        } catch (IOException o) {
            System.out.println("File not found");
        }
        setBackground(BACKGROUND);

        int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
        InputMap inputMap = getInputMap(condition);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), UP);
        actionMap.put(UP, new AbstractAction() {
            public void actionPerformed(ActionEvent arg0) {
                y -= 5;
                imageNum = 5;
                repaint();
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), DOWN);
        actionMap.put(DOWN, new AbstractAction() {
            public void actionPerformed(ActionEvent arg0) {
                y += 5;
                imageNum = 7;
                repaint();
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), LEFT);
        actionMap.put(LEFT, new AbstractAction() {
            public void actionPerformed(ActionEvent arg0) {
                x -= 5;
                imageNum = 8;
                repaint();
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), RIGHT);
        actionMap.put(RIGHT, new AbstractAction() {
            public void actionPerformed(ActionEvent arg0) {
                x += 5;
                imageNum = 6;
                repaint();
            }
        });

      // etc for left and right
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 17; j++) {
                System.out.println("block array " + Game.blockArray[j][i]);
                
                g2.drawImage(img[Game.blockArray[j][i]], (i + 1) * 35 -10, (j + 1) * 35 + 50, null);
                System.out.println("i " + i + " " + "j " + j);
            }
        }
        g2.drawImage(img[imageNum], null, x, y);
    }

    @Override
    public Dimension getPreferredSize() {
        return PREF_SIZE;
    }

    static void createAndDisplayGUI() throws IOException {
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new BattleField());
        frame.pack();
        frame.setAlwaysOnTop(true);
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
