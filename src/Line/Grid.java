package Line;

import java.awt.*;

/**
 * Created by Dmitrii on 26.06.2017.
 */
public class Grid {
    private int cellPx = 30;
    private int countCellsX;
    private int countCellsY;

    public Grid(int width, int heigh) {
        this.countCellsX = width/cellPx - 1;
        this.countCellsY = heigh/cellPx - 3;
    }

    public int getCellPx() {
        return cellPx;
    }

    public int getCountCellsX() {
        return countCellsX;
    }

    public int getCountCellsY() {
        return countCellsY;
    }

    public void drawGrid(Graphics g) {
        g.setColor(Color.black);
        for (int i = 1; i < countCellsX; i += 1)
            g.drawLine(i * cellPx , 0, i * cellPx, countCellsY * cellPx);
        for (int i = 1; i < countCellsY; i += 1)
            g.drawLine(0, i * cellPx, countCellsX  * cellPx, i * cellPx);
        }
}

