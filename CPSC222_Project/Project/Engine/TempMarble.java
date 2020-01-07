package Engine;

import GFX.TempGFX;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TempMarble implements ActionListener {

	/*
	The marble class essentially does everything
	it checks collisions for example.
	*/


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
    private TempGFX gfx;
//	private Graphics t;

    public TempMarble() {

        //	t=new Graphics();
        tempj = 0;
        temp2 = 0;
        savedVel = 0;
        savedPos = 0;
        hasCollide = false;
        radius = 10;
        velocity = new Vector();
        tm = new Timer(10, this);
        tm.start();
        gfx = new TempGFX();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
            System.out.println("we back here yo");

        } else {

            calcCollide(tempj++);
            //calcCollideX();
        }

        if (counter3 > 0) {
            //	counter3+=1;
            calcCollideX();
            System.out.println("calccollided");
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
        ycoord = savedPos - (int) (counter2 * (savedVel - (10 * velocity.getYVel(counter2 * 1.0))));
        if (temper == 0) {
            temp2 = ycoord;
            System.out.println("nnnoooooooooooooooooo");
        } else ;
        if (ycoord > temp2) {
            velocity.setYVel(0);
            counter2 = 0;
            counter = 0;
            savedPos = ycoord;
            hasCollide = false;
        } else ;
        temp2 = ycoord;
        System.out.println("val of ycoord " + ycoord);


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
            //System.out.println("this is ycoord "+temp);
            //ycoord=(int)(100*velocity.getYVel(counter*1.0));
            ycoord = (int) (counter * (10 * velocity.getYVel(counter * 1.0)));
            savedPos = ycoord;
            savedVel = 10 * velocity.getYVel(counter * 1.0);
        } else {
            //System.out.println("ycoord in this domain is "+ycoord);
            ycoord = (savedPos) + (int) (counter * (10 * velocity.getYVel(counter * 1.0)));
            System.out.println("ycoord in this domain is " + ycoord);
            //savedPos=ycoord;//fix this guy!
            savedVel = 10 * velocity.getYVel(counter * 1.0);


        }
    }

    public void collide() {
        //changes has collide so the marble knows
        //it needs to move up now.

        //velocity.collide1();
        System.out.println("we colliding");
        //ycoord-=100;
        tempj = 0;
        hasCollide = true;
        savedPos = ycoord;

    }

    public void checkColl() {


        if (getYCoord() > 400 && getYCoord() < 500 && (getXCoord() >= 0 && getXCoord() < 50)) {
            System.out.println("joshua howard");
            collide();


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