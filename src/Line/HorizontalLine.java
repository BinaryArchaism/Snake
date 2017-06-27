package Line;

import Element.ElemRect;

/**
 * Created by Dmitrii on 26.06.2017.
 */

public class HorizontalLine extends Line {
    public HorizontalLine(Grid grid, int x, int y, int len) {
        super(x, y, len);
        for (int i = 0; i < length; i++) {
            if (x+i < grid.getCountCellsX())
                elem[i] = new ElemRect(grid, x+i, y);
            else{
                length = i;
                break;
            }
        }
    }
}
