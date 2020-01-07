package GaltonParts;

import Main.Vector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Marble implements ActionListener {

	/*
	The marble class essentially does everything
	it checks collisions for example.
	*/


    private Peg[] peg7row;
    private Peg[] peg6row;
    private int radius;
    private Vector velocity;
    private int xcoord;
    private int ycoord;
    private boolean hasCollide;
    private int counter;
    private Timer tm;
    private int savedPos;
    private int counter2;
    private double savedVel;
    private int temp2;
    private int tempj;
    private int counter3;

    private Color marbleColour;

    public Marble(Peg[] p1, Peg[] p2, int x, int y, int w, Color c) {


        tempj = 0;
        temp2 = 0;
        savedVel = 0;
        savedPos = 0;
        hasCollide = false;
        radius = 2 * (w / 60);
        velocity = new Vector();
        tm = new Timer(10, this);
        tm.start();
        peg6row = p1;
        peg7row = p2;
        xcoord = x;
        ycoord = y;
        marbleColour = c;
    }

    public Color getMarbleColour() {
        return marbleColour;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //These counters serve as a type of timer/watch.
        counter += 1;
        if (hasCollide) {
            counter2 += 1;
            counter3 += 1;
        } else counter += 1;
        if (counter3 > 0) counter3 += 1;
        else ;

    }

    public void start() {

        if (!hasCollide) {

            calcDisp();
        } else {

            calcCollide(tempj++);
            //calcCollideX();
        }

        if (counter3 > 0) {
            //	counter3+=1;
            calcCollideX();
        } else ;

    }

    private void calcCollideX() {

        velocity.setXVel(.0200);
        xcoord = (int) (counter3 * (10 * velocity.getXVel()));

    }

    private void calcCollide(int temper) {

		/*
		Function for when the marble collides with an object
		and moves upward.
		*/

        double z = (double) counter;
        double temp;
        ycoord = savedPos - (int) (counter2 * (savedVel - (10 * velocity.getYVel(counter2 * 1.5))));
        if (temper == 0) {
            temp2 = ycoord;
        } else ;
        if (ycoord > temp2) {
            velocity.setYVel(0);
            counter2 = 0;
            counter = 0;
            savedPos = ycoord;
            hasCollide = false;
        } else ;
        temp2 = ycoord;
        //savedPos=ycoord;

    }

    private void calcDisp() {

        //Function for simple free fall.

        if (tempj == 0) {
            //This if should be removed and a general case should
            //be created.
            double z = (double) counter;
            double temp;
            //	velocity.getYVel(z);
            //	temp=velocity.getYVel(z*1000000);
            //ycoord=(int)(100*velocity.getYVel(counter*1.0));
            ycoord = (int) (counter * (10 * velocity.getYVel(counter * 1.0)));
            savedPos = ycoord;
            savedVel = 10 * velocity.getYVel(counter * 1.0);
        } else {
            ycoord = (savedPos) + (int) (counter * (10 * velocity.getYVel(counter * 1.0)));

            //savedPos=ycoord;//fix this guy!
            savedVel = 10 * velocity.getYVel(counter * 1.0);


        }
    }

    public void collide() {
        //changes has collide so the marble knows
        //it needs to move up now.

        //velocity.collide1();
        //ycoord-=100;
        tempj = 0;
        hasCollide = true;
        savedPos = ycoord;

    }

    public void checkColl() {
        checkPegs(peg6row);
        checkPegs(peg7row);
    }

    private void checkPegs(Peg[] pegRow) {

        for (Peg p : pegRow) {
            if (((getXCoord() > p.getTopVertex()[0] - radius && getXCoord() < p.getTopVertex()[0] + radius)) && ((getYCoord() > p.getTopVertex()[1] - radius && getYCoord() < p.getTopVertex()[1] + radius))) {
                collide();
            }
        }
    }

    public int getRadius() {
        return radius;
    }

    public int getYCoord() {
        return ycoord;
    }

    public void setYCoord(int a) {
        ycoord = a;
    }

    public int getXCoord() {
        return xcoord;
    }

    public void setXCoord(int b) {
        xcoord = b;
    }
}