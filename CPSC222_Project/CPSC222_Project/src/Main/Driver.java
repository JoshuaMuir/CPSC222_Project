package Main;

import GaltonParts.Peg;
import Graphics.PaintComponent;

public class Driver {


    public static void main(String[] args) {


        //thinking about having a class to store all of these values instead of passing through multiple methods
        int height = 1000;
        int width = 800;
        int numThreads = 10;

        MarbleThreads[] myThreads = new MarbleThreads[numThreads];

        //this part controls the graphics
        PaintComponent myPaint = new PaintComponent(height, width);
        Graphics.Window window = new Graphics.Window(height, width);
        javax.swing.SwingUtilities.invokeLater(() -> {
            window.createWindow(myPaint);
        });

        Peg[] bunchaPegs1 = new Peg[32];//pegs with 8 per row
        Peg[] bunchaPegs2 = new Peg[28];//pegs with 7 per row

        //this class creates the pegs and marbles, then sends them to graphics to be displayed
        ObjectCreator oc = new ObjectCreator(bunchaPegs1, bunchaPegs2, myPaint, width);
        oc.makePegs();

        //each thread created will create one marble
        for (int i = 0; i < myThreads.length; ++i) {
            myThreads[i] = new MarbleThreads(oc, i, width);
            myThreads[i].start();
        }
    }
}


