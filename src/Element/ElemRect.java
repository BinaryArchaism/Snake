package Element;

import Line.Grid;

import java.awt.*;

/**
 * Created by Dmitrii on 26.06.2017.
 */
public class ElemRect extends Element {
    public ElemRect(Grid grid, int x, int y) {
        super(grid, x, y);
    }

    @Override
    public void print(Graphics g) {
        g.setColor(Colors.clrWall);
        g.fillRect(getXX(), getYY(), grid.getCellPx(), grid.getCellPx());
    }

    @Override
    public void clear(Graphics g) {
        g.setColor(Colors.clrBack);
        g.fillRect(getXX(), getYY(), grid.getCellPx(), grid.getCellPx());
    }

    @Override
    public Element getElement  (){
        return this;
    }
}
