import Element.ElemCircle;
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
    Snake snake;
    ActionListener timerListener;
    Timer timer;

    public MainPanel(){
        grid = new Grid(Main.width - 15, Main.height - 50);
        wall = new Wall(grid);
        snake = new Snake(grid, 5 ,2, 10);
        timerListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
                snake.moveInDirection();
            }
        };
        timer = new Timer(200, timerListener);
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
