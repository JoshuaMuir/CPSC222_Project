package Main;

import GaltonParts.Marble;
import GaltonParts.Peg;
import Graphics.PaintComponent;

import java.awt.*;

public class ObjectCreator {

    private Marble[] theMarbs = new Marble[10];
    private Peg[] myPeg6;
    private Peg[] myPeg7;
    private PaintComponent myPaintComponent;
    private int myWidth;

    private int pegSize;

    public ObjectCreator(Peg[] p6, Peg[] p7, PaintComponent p, int w) {
        myPeg6 = p6;
        myPeg7 = p7;
        myPaintComponent = p;
        myWidth = w;
        pegSize = w / 60;
    }


    public void drawMarble(int id) {
        //update coords
        myPaintComponent.drawMarble(theMarbs[id], id);
    }

    public void makeMarble(int x, int y, int id, Color c) {

        theMarbs[id] = new Marble(myPeg6, myPeg7, x, y, myWidth, c);
        myPaintComponent.drawMarble(theMarbs[id], id);

    }

    public void makePegs() {

        int startX = -pegSize / 2;
        int startY = 215;


        int leftX = startX;
        int leftY = startY;
        int topX = startX + pegSize;
        int topY = startY - pegSize;
        int bottomX = startX + pegSize * 2;
        int bottomY = startY;
        int rightX = startX + pegSize;
        int rightY = startY + pegSize;


        for (int i = 1; i < myPeg6.length + 1; ++i) {
            Peg p = new Peg(i);
            myPeg6[i - 1] = p;
            myPeg6[i - 1].setLeftVertex(leftX, leftY);
            myPeg6[i - 1].setTopVertex(topX, topY);
            myPeg6[i - 1].setBotVertex(bottomX, bottomY);
            myPeg6[i - 1].setRightVertex(rightX, rightY);
            leftX += ((myWidth) / 7) - 2;
            topX += ((myWidth) / 7) - 2;
            bottomX += ((myWidth) / 7) - 2;
            rightX += ((myWidth) / 7) - 2;
            if (i % 8 == 0) {
                leftX = startX;
                leftY += 150;
                topX = startX + pegSize;
                topY += 150;
                bottomX = startX + pegSize * 2;
                bottomY += 150;
                rightX = startX + pegSize;
                rightY += 150;
            }
        }
        startX = ((myWidth) / 7) / 2 - 5;
        startY = 290;

        leftX = startX;
        leftY = startY;
        topX = startX + pegSize;
        topY = startY - pegSize;
        bottomX = startX + pegSize * 2;
        bottomY = startY;
        rightX = startX + pegSize;
        rightY = startY + pegSize;

        for (int i = 1; i < myPeg7.length + 1; ++i) {
            Peg p = new Peg(i);
            myPeg7[i - 1] = p;
            myPeg7[i - 1].setLeftVertex(leftX, leftY);
            myPeg7[i - 1].setTopVertex(topX, topY);
            myPeg7[i - 1].setBotVertex(bottomX, bottomY);
            myPeg7[i - 1].setRightVertex(rightX, rightY);
            leftX += ((myWidth) / 7) - 2;
            topX += ((myWidth) / 7) - 2;
            bottomX += ((myWidth) / 7) - 2;
            rightX += ((myWidth) / 7) - 2;
            if (i % 7 == 0) {
                leftX = startX;
                leftY += 150;
                topX = startX + pegSize;
                topY += 150;
                bottomX = startX + pegSize * 2;
                bottomY += 150;
                rightX = startX + pegSize;
                rightY += 150;
            }
        }
        myPaintComponent.drawPegs(myPeg6, myPeg7);
    }
}

