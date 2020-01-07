package Engine;

import Galton.Peg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TempGraphics extends JPanel implements ActionListener {

    private int radius;
    private Counter count;
    private int xCoord;
    private int yCoord;
    private Marble ball;
    private int counter;


    private Peg[] myPegs6;
    private Peg[] myPegs7;

    private int myHeight;
    private int myWidth;

    private int vert = 0;
    private int horz = 50;

    //public Timer tm;
    TempGraphics(Marble ball1, Peg[] pegs6, Peg[] pegs7, int h, int w) {

		/*
		currently have the graphics doing everything
		this is just temporary and should change
		when the program becomes more developed.
		*/
        counter = 0;
        //count=crowd;
        ball = ball1;
        xCoord = ball.getXCoord();
        yCoord = ball.getYCoord();
        System.out.println("in constr");
        Timer tm = new Timer(10, this);
        radius = ball.getRadius();
        tm.start();
        boolean grow = true;
        myPegs6 = pegs6;
        myPegs7 = pegs7;
        myHeight = h;
        myWidth = w;
    }

    // }
    public void paintComponent(Graphics g) {


        Rectangle leftSide = new Rectangle();
        leftSide.setLocation(0, 0);
        leftSide.setSize(8, myHeight);
        Rectangle rightSide = new Rectangle();
        rightSide.setLocation(myWidth - 9, 0);
        rightSide.setSize(9, myHeight);

        //paints
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, myWidth, myHeight);
        g2.setColor(Color.BLUE);
        g2.fillOval(ball.getXCoord(), ball.getYCoord(), radius, radius);
        g2.setColor(Color.WHITE);
        g2.fill(leftSide);
        g2.fill(rightSide);
        int pillar = myHeight - 200;


        //drawing pegs 6 per row
        for (Peg peg : myPegs6) {
            Polygon p = createPeg(peg);
            g.fillPolygon(p);
            g.fillRect(p.xpoints[1] - 2, pillar, 5, 200);
        }

        //drawing pogs 7 per row
        for (int i = 1; i < myPegs7.length + 1; ++i) {
            Polygon p = createPeg(myPegs7[i - 1]);
            g.fillPolygon(p);
        }

    }

    private Polygon createPeg(Peg peg) {

        Polygon poly = new Polygon();
        poly.addPoint(peg.getLeftVertex()[0], peg.getLeftVertex()[1]);
        poly.addPoint(peg.getTopVertex()[0], peg.getTopVertex()[1]);
        poly.addPoint(peg.getBotVertex()[0], peg.getBotVertex()[1]);
        poly.addPoint(peg.getRightVertex()[0], peg.getRightVertex()[1]);

        return poly;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        SuperSizeCircle();
        repaint();
        TempDriver.bigCount.incCounter();
    }

    private void SuperSizeCircle() {

        //This is what makes the marble go.
        ball.start();
        ball.checkColl();
    }

    void start() {


        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("big old");
            frame.setBackground(Color.BLACK);
            TempGraphics tg = new TempGraphics(new Marble(myPegs6, myPegs7), myPegs6, myPegs7, myHeight, myWidth);
            frame.add(tg);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocation(100, 10);
            frame.setSize(myWidth, myHeight);
            frame.setVisible(true);
        });
    }
}