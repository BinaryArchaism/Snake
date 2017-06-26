package Line;

import Element.ElemRect;

/**
 * Created by Dmitrii on 26.06.2017.
 */
public class VerticalLine extends Line {
    public VerticalLine(Grid grid, int x, int y, int len) {
        super(x, y, len);
        for (int i = 0; i < length; i++) {
            if (y+i <= grid.getCountCellsY())
                elem[i] = new ElemRect(grid, x, y+i);
            else{
                length = i;
                break;
            }
        }
    }
}
