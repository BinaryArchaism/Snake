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
    Grid grid;
    int x, y;
    ArrayList<ElemCircle> snake;
    static Direction direction;

    public Snake(Grid grid, int length, int x, int y) {
        this.grid = grid;
        this.length = length+1;
        this.x = x;
        this.y = y;
        snake = new ArrayList<ElemCircle>();
        for (int i = 0; i < this.length ; i++) {
            snake.add(new ElemCircle(grid, x, y+i));
        }
    }

    public ElemCircle getTail() {
        return snake.get(snake.size()-1);
    }

    public ElemCircle getHead() {
        return snake.get(0);
    }

    public void add(){
        snake.add(0, new ElemCircle(grid, x, y));
        length++;
    }

    public void remove() {
        snake.remove(getTail());
        length--;
    }


    public void draw(Graphics g) {
        for (int i = 0; i < length; i++) {
            snake.get(i).print(g);
            if (i == length-1) snake.get(i).clear(g);
        }
    }

    public boolean isHitWall(Element[] elem){
        boolean hit = false;
        for (Element l : elem) {
            if ((getHead().getXX() == l.getXX()) && (getHead().getYY() == l.getYY())) hit = true;
        }
        return hit;
    }

    public void moveInDirection(){
        //ElemCircle nextPos;
        if (direction == Direction.Up ) {
            // nextPos = new ElemCircle(grid, getHead().getXX(), getHead().getYY()-1);
            y = y -1;
            add(); remove();
        }
        else if (direction == Direction.Down) {
            //nextPos = new ElemCircle(grid, getHead().getXX(), getHead().getYY()+1);
            y += 1;
            add(); remove();

        }
        else if (direction == Direction.Left) {
            //nextPos = new ElemCircle(grid, getHead().getXX()-1, getHead().getYY());
            x -= 1;
            add(); remove();

        }
        else if (direction == Direction.Right){
            x += 1;
            add(); remove();
            //nextPos = new ElemCircle(grid, getHead().getXX()+1, getHead().getYY());
        }
        //return nextPos;
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
