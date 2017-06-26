import Line.*;
import Element.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dmitrii on 26.06.2017.
 */
public class Main extends JPanel {
    static int heigth = 600;
    static int width = 600;

    Wall wall;
    Element elem;
    Grid grid;
    Line line;

    public Main(){
        grid = new Grid(30, width, heigth);

          elem = new ElemCircle(grid, 4,6);
          line = new VerticalLine(grid, 0, 0, grid.getCountCellsY());
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

    public static void main(String[] args){
        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, heigth);
        frame.add(new Main());
        frame.setVisible(true);
    }
}
