import java.awt.EventQueue;
import javax.swing.JFrame;

package snakeapp;

public class Game extends JFrame{
    
    public Game(){
        add(new Board());
        
        setResizable(false);
        pack();
        
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void runGame() {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                JFrame ex = new Game();
                ex.setVisible(true);                
            }
        });
    }
}




















