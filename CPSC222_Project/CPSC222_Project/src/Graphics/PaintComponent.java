package Graphics;

import GaltonParts.Marble;
import GaltonParts.Peg;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class PaintComponent extends JComponent {

    Graphics2D myGraphics;
    private int myHeight;
    private int myWidth;
    private ArrayList<Shape> shapes = new ArrayList<>();
    private Shape[] marbles = new Shape[10];
    private Color[] colours = new Color[10];


    public PaintComponent(int h, int w) {

        myHeight = h;
        myWidth = w;

    }


    @Override
    public void paintComponent(Graphics g) {


        //this section creates background of window
        myGraphics = (Graphics2D) g;
        myGraphics.setColor(Color.BLACK);
        myGraphics.fillRect(0, 0, myWidth, myHeight);

        //creating 2 rectangles to be used as border
        Rectangle leftSide = new Rectangle();
        leftSide.setLocation(0, 0);
        leftSide.setSize(8, myHeight);
        Rectangle rightSide = new Rectangle();
        rightSide.setLocation(myWidth - 9, 0);
        rightSide.setSize(9, myHeight);
        shapes.add(leftSide);
        shapes.add(rightSide);

        //prints each shape that is inside shape array list
        myGraphics.setColor(Color.WHITE);
        for (Shape s : shapes) {
            myGraphics.fill(s);
        }

        //paints every marble that should be painted
        if (marbles.length > 0) {
            for (int i = 0; i < marbles.length; ++i) {
                myGraphics.setColor(colours[i]);
                myGraphics.fill(marbles[i]);
            }

        }

    }


    //when a marble is called to be created in graphics
    //it will have its own id
    //the marble will be placed in the marble array at a position corresponding to its id
    //when the marble is called to be drawn again, it will replace the old marble in its array position
    public void drawMarble(Marble m, int id) {
        Ellipse2D.Double marble = new Ellipse2D.Double(m.getXCoord(), m.getYCoord(), m.getRadius(), m.getRadius());
        marbles[id] = marble;
        colours[id] = m.getMarbleColour();
        repaint();
    }


    //simple method to create pegs
    //this method is passed the array of peg objects from the ObjectCreator class
    public void drawPegs(Peg[] myPegs6, Peg[] myPegs7) {
        for (Peg peg : myPegs6) {
            //for every peg in the array, a polygon will be made with the same vertices
            Polygon p = createPeg(peg);

            //these rectangles are the bottom pillar things on the board
            Rectangle r = new Rectangle(p.xpoints[1] - 3, myHeight - 200, 5, 200);

            //both peg polygons and pillars are added to shapes array to be painted
            shapes.add(p);
            shapes.add(r);
        }


        //repeat for second array of pegs, minus the pillars
        for (int i = 1; i < myPegs7.length + 1; ++i) {
            Polygon p = createPeg(myPegs7[i - 1]);
            shapes.add(p);
        }
        repaint();
    }

    //makes polygons with matching vertices of each peg
    private Polygon createPeg(Peg peg) {
        Polygon poly = new Polygon();
        poly.addPoint(peg.getLeftVertex()[0], peg.getLeftVertex()[1]);
        poly.addPoint(peg.getTopVertex()[0], peg.getTopVertex()[1]);
        poly.addPoint(peg.getBotVertex()[0], peg.getBotVertex()[1]);
        poly.addPoint(peg.getRightVertex()[0], peg.getRightVertex()[1]);
        return poly;
    }
}
