package Main;

import java.awt.*;
import java.util.Random;

public class MarbleThreads extends Thread {

    Color colour;
    int ID;
    private Random rnd = new Random();
    //when the marble stops having x an y velocities, it should set this boolean to false
    //when this is false, the marble wll stop moving
    private boolean falling;
    private int width;
    private ObjectCreator oc;

    MarbleThreads(ObjectCreator oc, int id, int width) {
        falling = true;
        this.width = width;
        this.oc = oc;
        ID = id;
        colour = new Color(rnd.nextInt(236) + 20, rnd.nextInt(236) + 20, rnd.nextInt(236) + 20);
        oc.makeMarble(rnd.nextInt(width - (2 * (width / 60)) - 20) + 10, 20, ID, colour);
    }

    public void run() {

        while (falling) {

            //have physics
            //after all the physics part here, the marble should then have updated coords, so..
            // myOC.makeMarble(marble x, marble y, id); will be called
            //or instead we call an external method from this loop which will call the marble calss itself at the end
            //instead of sending new marble coords back here
            //whichever is easier
            oc.drawMarble(ID);

        }
    }

}