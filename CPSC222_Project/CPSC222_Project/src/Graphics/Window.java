package Graphics;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel  {

    private int myHeight;
    private int myWidth;

    public Window(int h, int w) {

        myHeight = h;
        myWidth = w;
    }

    //i dont know what happens here LOL !!!!! xD
    public void createWindow(PaintComponent paint ){

        JFrame frame = new JFrame("big old");
        frame.setBackground(Color.BLACK);
        frame.add(paint);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 10);
        frame.setSize(myWidth, myHeight);
        frame.setVisible(true);

    }
}
