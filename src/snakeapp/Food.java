import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

package snakeapp;

public class Food{
    private final int DOT_SIZE = 10;
    
    private final int RAND_POS = 29;
    
    private Image foodImage;
    
    private int x;
    private int y;
    
    public void setFoodImage(Image image){
        foodImage = image;
    }
    
    public void generateFood(){
        int tmp;
        
        tmp = (int) (Math.random() * RAND_POS);
        x = ((tmp * DOT_SIZE));

        tmp = (int) (Math.random() * RAND_POS);
        y = ((tmp * DOT_SIZE));
    }
    
    public void draw(Graphics g){
        g.drawImage(foodImage, x, y, null);
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
}








