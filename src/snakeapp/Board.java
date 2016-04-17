import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

package snakeapp;

public class Board extends JPanel implements ActionListener {
    private final int B_WIDTH = 300;
    private final int B_HEIGHT = 300;
    
    private int speed = 140;
    
    private Timer timer;
    
    private boolean inGame = true;

    private Snake s;
    private Food f;
    
    public Board(){
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        
        s = new Snake();
        f = new Food();
        
        loadImages();
        initGame();
    }
    
    private void loadImages(){
        ImageIcon iid = new ImageIcon("../pic/dot.png");
        s.setBodyImage(iid.getImage());

        ImageIcon iia = new ImageIcon("../pic/apple.png");
        f.setFoodImage(iia.getImage());
        
        ImageIcon iih = new ImageIcon("../pic/head.png");
        s.setHeadImage(iih.getImage());
    }
    
    private void initGame(){
        f.generateFood();
        
        timer = new Timer(speed, this);
        timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        if (inGame) {
            f.draw(g);
            s.draw(g);

            Toolkit.getDefaultToolkit().sync();
        } 
        else
            gameOver(g);    
    }
    
    private void gameOver(Graphics g) {
        
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            s.checkFood(f);
            s.move();
            inGame = s.checkCollision(B_WIDTH, B_HEIGHT);
            
            if(!inGame) {
                timer.stop();
            }
        }
        repaint();
    }
    
    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            s.setDirection(key);
        }
    }
}










