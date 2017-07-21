import Element.ElemFood;
import Line.*;
import Sounds.Sound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dmitrii on 27.06.2017.
 */
public class MainPanel extends JPanel {

    Wall wall;
    Grid grid;
    Snake snake;
    ActionListener timerListener;
    Timer timer;
    Sound sound;
    ElemFood elemFood;
    int countOfEatenFood = 0;

    public MainPanel(){
        grid = new Grid(Main.width - 15, Main.height - 50);
        wall = new Wall(grid);
        snake = new Snake(grid, 5 ,2, 10);
        elemFood = new ElemFood(grid, wall.getSafetyNumber(), wall.getSafetyNumber());
        timerListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
                snake.moveInDirection();
                if (snake.isHit()) {
                    sound = new Sound("Sounds/lose.wav");
                    sound.play();
                    timer.stop();
                }
                boolean foodEaten = false;
                if (snake.isHitFood(elemFood)) {
                    snake.add();
                    sound = new Sound("Sounds/eat.wav");
                    sound.play();
                    elemFood = new ElemFood(grid, wall.getSafetyNumber(),wall.getSafetyNumber());
                    countOfEatenFood++;
                    foodEaten = true;
                }
                if (!foodEaten) {
                    if (snake.isHitBody()) {
                        sound = new Sound("Sounds/lose.wav");
                        sound.play();
                        timer.stop();
                    }
                }
                if (countOfEatenFood == 20) {
                    sound = new Sound("Sounds/win.wav");
                    sound.play();
                    countOfEatenFood = 0;
                }

            }
        };
        timer = new Timer(200, timerListener);
        timer.start();
    }

    public void beginGame(Graphics g) {
        grid.drawGrid(g);
        wall.draw(g);
        snake.draw(g);
        elemFood.print(g);
    }

    @Override
    public void paint(Graphics g) {
        beginGame(g);
    }

}
