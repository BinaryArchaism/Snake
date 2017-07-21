package Line;

import Element.Element;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Dmitrii on 26.06.2017.
 */

public class Wall {
    ArrayList<Line> wall;
    ArrayList<Line> barrier;
    Grid grid;
    int num;
    int check;
    boolean checker;

    public Wall(Grid grid){
        this.grid = grid;
        wall = new ArrayList<Line>();
        wall.add(new HorizontalLine(grid, 0, 0, grid.getCountCellsX()));
        wall.add(new HorizontalLine(grid, 0, grid.getCountCellsY(), grid.getCountCellsX()));
        wall.add(new VerticalLine(grid, 0, 0, grid.getCountCellsY()));
        wall.add(new VerticalLine(grid, grid.getCountCellsX()-1, 0, grid.getCountCellsY()));
        buildBarrier(grid);
    }

    public ArrayList<Line> getWall() {
        return wall;
    }
    public ArrayList<Line> getBarrier() {
        return barrier;
    }
    public void buildBarrier(Grid grid) {
        barrier = new ArrayList<Line>();
        barrier.add(new VerticalLine(grid, 7,3,6));
        barrier.add(new HorizontalLine(grid, 4,3,4));
        barrier.add(new VerticalLine(grid, 17, 7, 5));
        barrier.add(new HorizontalLine(grid, 17, 12, 4));
        barrier.add(new VerticalLine(grid, 21, 9,4));
    }

    public boolean isHitWall(Element[] elem){
        boolean hit = false;
        for (Element l : elem) {
            if ((num == l.getXX())) hit = true;
        }
        return hit;
    }
    public boolean isHit() {
        Wall wall = new Wall(grid);
        boolean hit = false;
        do {
            for (Line l : wall.getWall()) {
                if (isHitWall(l.getElem())) {
                    hit = true;
                    checker = hit;
                }
            }
            for (Line l : wall.getBarrier()) {
                if (isHitWall(l.getElem())) {
                    hit = true;
                }
            }
        } while (checker != hit);
        return hit;
    }

    public int getSafetyNumber() {
        do {
            for (Line l : wall) {
                do {
                    num = (int) (1 + (Math.random() * 15));
                    check = num;
                } while (isHit());
            }
            for (Line l : barrier) {
                do {
                    num = (int) (1 + (Math.random() * 15));
                } while (isHit());
            }
        } while (check != num);
        return num;
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
