package Line;

import java.awt.*;

/**
 * Created by Dmitrii on 26.06.2017.
 */

public class Wall {
    Line wall[];
    Line barrier[];
    int countOfWalls = 4;
    int countOfBarriers = 4;
    Grid grid;

    public Wall(Grid grid){
        this.grid = grid;
        wall = new Line[countOfWalls];

        wall[0] = new HorizontalLine(grid, 0, 0, grid.getCountCellsX());
        wall[1] = new HorizontalLine(grid, 0, grid.getCountCellsY(), grid.getCountCellsX());
        wall[2] = new VerticalLine(grid, 0, 0, grid.getCountCellsY());
        wall[3] = new VerticalLine(grid, grid.getCountCellsX()-1, 0, grid.getCountCellsY());
        buildBarrier(grid);
    }

    public void buildBarrier(Grid grid) {
        barrier = new Line[countOfBarriers];
        barrier[0] = new VerticalLine(grid, 7,3,6);
        barrier[1] = new HorizontalLine(grid, 4,3,4);
        barrier[2] = new VerticalLine(grid, 17, 7, 5);
        barrier[3] = new HorizontalLine(grid, 17, 12, 4);
    }

    public void draw(Graphics g){
        for(int i = 0; i < countOfWalls; i++) {
            wall[i].draw(g);
        }
        for (int i = 0; i < countOfBarriers; i++) {
            barrier[i].draw(g);
        }
    }

}
