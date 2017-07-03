import Line.Grid;
import Line.Snake;
import Line.Wall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dmitrii on 27.06.2017.
 */
public class MainPanel extends JPanel {

    Wall wall;
    Grid grid;
    Snake snake = new Snake(grid, 2, 5,5);
    ActionListener timerListener;
    Timer timer;

    public MainPanel(){
        grid = new Grid(Main.width - 15, Main.height - 50);
        wall = new Wall(grid);
        timerListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                snake.moveInDirection();
                repaint();
            }
        };
        timer = new Timer(20, timerListener);
        timer.start();
    }

    public void beginGame(Graphics g) {
        grid.drawGrid(g);
        wall.draw(g);
        snake.draw(g);
    }

    @Override
    public void paint(Graphics g) {
        beginGame(g);
    }

}
