package Element;

import Line.Grid;

import java.awt.*;

/**
 * Created by Dmitrii on 26.06.2017.
 */
public abstract class Element {
    int x, y;
    Grid grid;

    public Element(int x, int y, Grid grid) {
        this.x = x;
        this.y = y;
        this.grid = grid;
    }

    public int getXX() {
        return x * grid.getCellPx();
    }

    public int getY() {
        return y * grid.getCellPx();
    }

    public abstract void print(Graphics g);
    public abstract  Element getElement();
    public abstract void clear(Graphics g);
}
