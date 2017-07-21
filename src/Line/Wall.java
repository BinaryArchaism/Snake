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

    public int[] getSafetyNumber() {
        boolean isHit = false;
        int coords[] = new int[2];
        do {
            coords[0] = (int) (1 + (Math.random() * 15));
            coords[1] = (int) (1 + (Math.random() * 15));
            for (int i = 0; i < barrier.size(); i++) {
                for (int j = 0; j < barrier.get(i).getElem().length; j++) {
                    if (barrier.get(i).getElem()[j].getXX() == coords[0] &&
                            barrier.get(i).getElem()[j].getYY() == coords[1]) {
                        isHit = true;
                    }
                }
            }
        } while (isHit);
//        do {
////            coords[0] = (int) (1 + (Math.random() * 15));
////            coords[1] = (int) (1 + (Math.random() * 15));
////            for (int i = 0; i < barrier.size(); i++) {
////                Element[] elem = barrier.get(i).getElem();
////                for (int j = 0; j < elem.length ; j++) {
////                    if (coords[0] == elem[j].getXX() && coords[1] == elem[j].getYY()) isHit = true;
////                }
////            }
//            for (Line l : barrier) {
//                Element el[] = l.getElem();
//                for (Element e : el) {
//                    if (e.getXX() == coords[0] && e.getYY() == coords[1]) isHit = true;
//                }
//            }
//        } while (!isHit);
        return coords;
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
