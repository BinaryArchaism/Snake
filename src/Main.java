import javax.swing.*;

/**
 * Created by Dmitrii on 26.06.2017.
 */

public class Main {

    static int heigth = 600;
    static int width = 900;

    public static void main(String[] args){
        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(width, heigth);
        frame.add(new MainPanel());
    }
}
