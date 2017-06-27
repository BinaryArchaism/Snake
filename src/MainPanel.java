import Line.Grid;
import Line.Wall;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dmitrii on 27.06.2017.
 */
public class MainPanel extends JPanel {

    static int heigth = 600;
    static int width = 900;

    Wall wall;
    Grid grid;

    public MainPanel(){
        grid = new Grid(width, heigth);
        wall = new Wall(grid);
    }
    public void beginGame(Graphics g) {
        grid.drawGrid(g);
        wall.draw(g);
    }

    @Override
    public void paint(Graphics g) {
        beginGame(g);
    }

}
