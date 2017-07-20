package Element;

import Line.Grid;

import java.awt.*;
import java.util.Random;

/**
 * Created by Dmitrii on 26.06.2017.
 */
public class ElemFood extends Element {
    public ElemFood(Grid grid, int x, int y) {
        super(grid, x, y);
    }

    public boolean isHit(Element[] elements) {
        boolean hit = false;
        for (Element l : elements) {
            if ((x == l.getXX()) && y == l.getYY()) hit = true;
        }
        return hit;
    }

    public int getRandom(Grid grid) {
        Random random= new Random();
        return random.nextInt()*grid.getCellPx();
    }

    @Override
    public void print(Graphics g) {
        g.setColor(Colors.clrCherry);
        g.fillOval(getXX(), getYY(), grid.getCellPx(), grid.getCellPx());
    }

    @Override
    public void clear(Graphics g) {
        g.setColor(Colors.clrBack);
        g.fillOval(getXX(), getYY(), grid.getCellPx(), grid.getCellPx());
    }

    @Override
    public Element getElement  (){
        return this;
    }
}
