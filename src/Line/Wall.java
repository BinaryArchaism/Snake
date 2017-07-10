package Line;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Dmitrii on 26.06.2017.
 */

public class Wall {
    ArrayList<Line> wall;
    ArrayList<Line> barrier;
    Grid grid;

    public Wall(Grid grid){
        this.grid = grid;
        wall = new ArrayList<Line>();
        wall.add(new HorizontalLine(grid, 0, 0, grid.getCountCellsX()));
        wall.add(new HorizontalLine(grid, 0, grid.getCountCellsY(), grid.getCountCellsX()));
        wall.add(new VerticalLine(grid, 0, 0, grid.getCountCellsY()));
        wall.add(new VerticalLine(grid, grid.getCountCellsX()-1, 0, grid.getCountCellsY()));
        buildBarrier(grid);
    }

    public void buildBarrier(Grid grid) {
        barrier = new ArrayList<Line>();
        barrier.add(new VerticalLine(grid, 7,3,6));
        barrier.add(new HorizontalLine(grid, 4,3,4));
        barrier.add(new VerticalLine(grid, 17, 7, 5));
        barrier.add(new HorizontalLine(grid, 17, 12, 4));
        barrier.add(new VerticalLine(grid, 21, 9,4));
    }

    public void draw(Graphics g){
        for(int i = 0; i < wall.size(); i++) {
            wall.get(i).draw(g);
        }
        for (int i = 0; i < barrier.size(); i++) {
            barrier.get(i).draw(g);
        }
    }

}
