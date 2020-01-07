package Engine;

import Galton.Peg;
import java.util.Random;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Marble implements ActionListener {

	/*
	The marble class essentially does everything
	it checks collisions for example.
	*/

    public int tempTest;
    private int some;
    Peg[] peg7row;
    private Peg[] peg6row;
    private int radius;
    private int what;
    private Vector velocity;
    private int xcoord = 450;
    private int ycoord;
    private boolean flag;
    private boolean hasCollide;
    private int counter;
    private int currentDirection;
    private int savedCounter;
    private Timer tm;
    private int previousDirection;
    private boolean access=false;
    private int savedPos;
    private int savedXPos;
    private double savedXVel;
    private int counter2;
    private double savedVel;
    private int ternaryCounter;
    private int temp2;
    private int tempj;
    private int counter3;
    private Random rand;
    private boolean goneLeft=false;
    private boolean goneRight=false;


    public Marble(Peg[] p1, Peg[] p2) {
        flag=false;
        currentDirection=-2;
        previousDirection=-1;
        what=0;
        some=0;
        savedCounter=-1;
        tempTest=0;
        rand=new Random();
        tempj = 0;
        temp2 = 0;
        savedVel = 0;
        savedPos = 0;
        hasCollide = false;
        radius = 30;
        velocity = new Vector();
        tm = new Timer(10, this);
        tm.start();
        peg6row = p1;
        peg7row = p2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //These counters serve as a type of timer/watch.
        counter += 1;
        ternaryCounter+=1;
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
            if(!goneRight&&!goneLeft){
                int k = rand.nextInt(3);
                //System.out.println(k);
            // if(k!=1)
            // goneRight=true;
            // else goneLeft=true;
            }else;
            if(goneRight){
                calcCollideX();
            }
            else {
                System.out.println("value of right "+goneRight);
                System.out.println("value of left "+goneLeft);
                calcCollideNegX();

            }

        } else ;
        if(flag)doNothing();
        else;

    }
    private void doNothing(){

        while(true);

    }
    private void calcCollideX() {
        
        velocity.setXVel(.0200);
        System.out.println("went in a good one");
        xcoord = savedXPos+(int) (counter3 *(savedXVel+ (10 * velocity.getXVel())));
      //  goneRight=false;

      //  goneLeft=false;
    
    }
    private void calcCollideNegX(){
       
        velocity.setXVel(.0200);
        System.out.println("went out a bad two");
        xcoord = savedXPos-(int) (counter3 *(savedXVel+ (10 * velocity.getXVel())));
       // goneLeft=false;
        //goneRight=false;
        
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

    public void collide(boolean b) {
        //changes has collide so the marble knows
        //it needs to move up now.

        //velocity.collide1();
        //ycoord-=100;
  
        if(b){
            goneRight=false;
            goneLeft=true;
            System.out.println("set gone left true");
        }
        else {
            goneLeft=false;
            goneRight=true;
            System.out.println("set gone right true");
        }
        tempj = 0;
        hasCollide = true;
        savedPos = ycoord;
       //  if(currentDirection!=previousDirection){
       // // savedXPos=xcoord;
       //      counter3=0;
       //  ++tempTest;
       //  System.out.println("went here per se");
       //   }
       //  else;
       //
        savedXPos=xcoord;
        counter3=0;
        savedXVel=velocity.getXVel();

    }

    public void checkColl() {
        if(ternaryCounter>what){
       
        what=ternaryCounter;
        checkPegs(peg6row);
        checkPegs(peg7row);
        checkWalls();
        
        }
    }
    private void checkWalls(){

        if(getYCoord()>800 && getYCoord()<1000){
            flag=true;


        }

    }
    private void checkPegs(Peg[] pegRow) {

        

            for (Peg p : pegRow) {
            if (((getXCoord() > p.getTopVertex()[0] - radius && getXCoord() < p.getTopVertex()[0] + radius)) && ((getYCoord() > p.getTopVertex()[1] - radius && getYCoord() < p.getTopVertex()[1] + radius))) {
                if(getXCoord()<p.getTopVertex()[0]){
                collide(true);
                System.out.println("collided true");
                System.out.println(getXCoord() + " " + p.getTopVertex()[0]);
                if(currentDirection==-2){
                    currentDirection=2;
                    previousDirection=2;

                }else{
                previousDirection=currentDirection;
                currentDirection=2;
            }
            }
                else{ collide(false);
                System.out.println("collided false");

                if(currentDirection==-2){
                    currentDirection=1;
                    previousDirection=1;

                }else{
                previousDirection=currentDirection;
                currentDirection=1;
            }
                }
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

/*    private void checkPegs(Peg[] pegRow) {

        for (Peg p : pegRow) {
            if (((getXCoord() > p.getTopVertex()[0] - radius && getXCoord() < p.getTopVertex()[0] + radius)) && ((getYCoord() > p.getTopVertex()[1] - radius && getYCoord() < p.getTopVertex()[1] + radius))) {
                collide();
            }
        }
    }*/