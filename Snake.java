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

public class Snake{
    private final int MAX_LENGTH = 900;
    private final int DOT_SIZE = 10;
    private final int UP = KeyEvent.VK_UP;
    private final int DOWN = KeyEvent.VK_DOWN;
    private final int LEFT = KeyEvent.VK_LEFT;
    private final int RIGHT = KeyEvent.VK_RIGHT;
    
    private int length;
    private int direction;
    private int x[];
    private int y[];
    
    private Image head;
    private Image body;
    
    public Snake(){
        length = 3;
        
        x = new int[MAX_LENGTH];
        y = new int[MAX_LENGTH];
        
        direction = RIGHT;
        
        for(int i = 0; i < length; i++){
            x[i] = 50 - i * 10;
            y[i] = 50;
        }
    }
    
    public void setHeadImage(Image image){
        head = image;
    }
    
    public void setBodyImage(Image image){
        body = image;
    }
    
    public void draw(Graphics g){
        for (int i = 0; i < length; i++) {
            if (i == 0)
                g.drawImage(head, x[i], y[i], null);
            else
                g.drawImage(body, x[i], y[i], null);
        }
    }
    
    public void checkFood(Food f){
        if(x[0] == f.getX() && y[0] == f.getY()){
            length++;
            f.generateFood();
        }
    }
    
    public void move(){
        for (int i = length; i > 0; i--) {
            x[i] = x[(i - 1)];
            y[i] = y[(i - 1)];
        }
        
        switch(direction){
            case LEFT:
                x[0] -= DOT_SIZE;
                break;
            case RIGHT:
                x[0] += DOT_SIZE;
                break;
            case UP:
                y[0] -= DOT_SIZE;
                break;
            default:
                y[0] += DOT_SIZE;
                break;
        }
    }
    
    public boolean checkCollision(int B_WIDTH, int B_HEIGHT){
        for (int i = length; i > 0; i--) {
            if ((i > 4) && (x[0] == x[i]) && (y[0] == y[i])) {
                return false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            return false;
        }

        if (y[0] < 0) {
            return false;
        }

        if (x[0] >= B_WIDTH) {
            return false;
        }

        if (x[0] < 0) {
            return false;
        }
        
        return true;
    }
    
    public void setDirection(int newDirect){
        switch(newDirect){
            case UP:
                if(direction != DOWN)
                    direction = UP;
                break;
            case DOWN:
                if(direction != UP)
                    direction = DOWN;
                break;
            case LEFT:
                if(direction != RIGHT)
                    direction = LEFT;
                break;
            case RIGHT:
                if(direction != LEFT)
                    direction = RIGHT;
                break;
            default:
                break;
        }
    }
}











