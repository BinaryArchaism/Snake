package Line;

import Element.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Dmitrii on 26.06.2017.
 */

public class Snake{
    int length;
    int x, y;
    ArrayList<ElemCircle> snk;
    static Direction direction;

    public Snake(Grid grid, int x, int y, int length) {
        this.x = x;
        this.y = y;
        y += 1;
        this.length = length;
        snk = new ArrayList<ElemCircle>();
        for (int i = 0; i < length; i++) {
            snk.add(new ElemCircle(grid, x, y - 1));
        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i > length; i++) {
            snk.get(i).print(g);
        }
    }

    public void moveInDirection(){
        if (direction == Direction.Up ) y = y-1;
        if (direction == Direction.Down) y = y+1;
        if (direction == Direction.Left) x = x-1;
        if (direction == Direction.Right) x = x+1;
    }

    public static void handleKeyEvent(int key){
        switch (key){
            case KeyEvent.VK_W : {
                direction = Direction.Up;
                break;
            }
            case KeyEvent.VK_S : {
                direction = Direction.Down;
                break;
            }
            case KeyEvent.VK_A : {
                direction = Direction.Left;
                break;
            }
            case KeyEvent.VK_D : {
                direction = Direction.Right;
                break;
            }
        }
    }

    public enum Direction { Up, Right, Down, Left }

}
