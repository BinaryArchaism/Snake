package Line;

import Element.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Dmitrii on 26.06.2017.
 */

public class Snake extends Line{
    int length;
    int x, y;
    ArrayList<ElemCircle> snake;
    static Direction direction;

    public Snake(int x, int y, int length) {
        super(x, y, length);
    }

    public void draw(Graphics g, Grid grid, int length) {
        this.length = length;
        snake = new ArrayList<ElemCircle>();
        for (int i = 0; i < length ; i++) {
            snake.add(new ElemCircle(grid, x, y));
        }for (int i = 0; i < length; i++) {
            snake.get(i).print(g);
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
            case KeyEvent.VK_UP : {
                direction = Direction.Up;
                break;
            }
            case KeyEvent.VK_DOWN : {
                direction = Direction.Down;
                break;
            }
            case KeyEvent.VK_LEFT : {
                direction = Direction.Left;
                break;
            }
            case KeyEvent.VK_RIGHT : {
                direction = Direction.Right;
                break;
            }
        }
    }

}
