import Line.Snake;
import Sounds.Sound;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Created by Dmitrii on 26.06.2017.
 */

public class Main extends JFrame {

    public static final int height = 555;
    public static final int width = 890;

    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Snake");
        setLocation(50,5);
        setResizable(false);
        setSize(width, height);
        add(new MainPanel());
        Sound sound = new Sound("Sounds/click.wav");

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                Snake.handleKeyEvent(key);
                repaint();
                sound.play();
            }
            @Override
            public void keyReleased(KeyEvent e) {
                repaint();
            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}
