package GFX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TempGFX extends JPanel implements ActionListener {
    private int radius;
    //private Counter count;
    private int xCoord;
    private int yCoord;
    //private Marble ball;
    private int counter;

    //public Timer tm;
    public TempGFX() {

		/*
		currently have the graphics doing everything
		this is just temporary and should change
		when the program becomes more developed.
		*/
        // counter = 0 ;
        // //count=crowd;
        // ball=ball1;
        // xCoord=ball.getXCoord();
        // yCoord=ball.getYCoord();
        System.out.println("in constr");
        Timer tm = new Timer(10, this);
        //radius = ball.getRadius();
        tm.start();
        boolean grow = true;

    }

    public void yoPaint() {

        repaint();

    }

    public void drawMarble(int x, int y, int rad) {

        //super.paintComponent(g);
        //g.drawCircle(x,y,100+rad,100+rad);


    }

    // }
    public void paintComponent(Graphics g) {

        //paints
        super.paintComponent(g);
        g.setColor(Color.green);
       // g.drawOval(ball.getXCoord(), ball.getYCoord() , 100+radius, 100+radius);
//        g.drawOval(45, 510, 20, 20);
//        g.drawLine(100, 100, 100, 100);
//        int[] jej = {100, 150, 200};
//        int[] yey = {550, 500, 550};
//        g.drawPolygon(jej, yey, 3);
        //System.out.println("painted Comoone");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        SuperSizeCircle();
        repaint();
        //	TempDriver.bigCount.incCounter();


    }
    // public static void createBall(Marble ball2){

    // 	ball=ball2;

    public void SuperSizeCircle() {

        //This is what makes the marble go.
        // ball.start();
        // ball.checkColl();


    }

    public void start() {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TempGFX.good kew = new TempGFX.good();
                JFrame frame = new JFrame("big old");
                TempGFX tg = new TempGFX();
                TempGFX.TempCircle tc = new TempGFX.TempCircle();
                TempGFX.good old = new TempGFX.good();
                frame.add(tg);
                frame.add(tc);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocation(100, 10);
                frame.setSize(1000, 3000);
                frame.setVisible(true);

            }


        });


    }

    class good {
    }

    class TempCircle extends JPanel implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {


        }


    }


}