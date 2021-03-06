package teamamerica;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentListener;

public class DisplayWindow extends JFrame implements KeyListener {
    private Paint draw;
    
    public DisplayWindow() {
       
        this.draw=new Paint();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);    
    }
    
     /** Handle the key typed event */
    public void keyTyped(KeyEvent e) {
    }

    /** Handle the key-pressed event */
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_RIGHT)
            draw.moveRight();
        else if(e.getKeyCode()== KeyEvent.VK_LEFT)
            draw.moveLeft();
        else if(e.getKeyCode()== KeyEvent.VK_DOWN)
            draw.moveDown();
        else if(e.getKeyCode()== KeyEvent.VK_UP)
            draw.moveUp();
    }

    /** Handle the key-released event */
    public void keyReleased(KeyEvent e) {
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DisplayWindow frame = new DisplayWindow();
                frame.setTitle("Team America");
                frame.setResizable(false);
                frame.setSize(1440, 700);
                frame.setMinimumSize(new Dimension(1440, 700));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(frame.draw);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    
}
