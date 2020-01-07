package Engine;

import Galton.Peg;


public class TempDriver {
    static Counter bigCount;

    public static void main(String[] args) {

        int height = 1000;
        int width = 800;

        int startX = -3;
        int startY = 215;


        int leftX = startX;
        int leftY = startY;
        int topX = startX + 10;
        int topY = startY - 10;
        int bottomX = startX + 20;
        int bottomY = startY;
        int rightX = startX + 10;
        int rightY = startY + 10;


        Peg[] bunchaPegs1 = new Peg[32];
        Peg[] bunchaPegs2 = new Peg[28];

        for (int i = 1; i < bunchaPegs1.length + 1; ++i) {
            Peg p = new Peg(i);
            bunchaPegs1[i - 1] = p;
            bunchaPegs1[i - 1].setLeftVertex(leftX, leftY);
            bunchaPegs1[i - 1].setTopVertex(topX, topY);
            bunchaPegs1[i - 1].setBotVertex(bottomX, bottomY);
            bunchaPegs1[i - 1].setRightVertex(rightX, rightY);
            leftX += ((width) / 7) - 2;
            topX += ((width) / 7) - 2;
            bottomX += ((width) / 7) - 2;
            rightX += ((width) / 7) - 2;
            System.out.println("left is "+leftX);
            System.out.println("right is "+rightX);
            System.out.println("top y is "+topY);
            if (i % 8 == 0) {
                leftX = startX;
                leftY += 150;
                topX = startX + 10;
                topY += 150;
                bottomX = startX + 20;
                bottomY += 150;
                rightX = startX + 10;
                rightY += 150;
            }
        }
        startX = ((width - 600) / 2) / 2;
        startY = 290;

        leftX = startX;
        leftY = startY;
        topX = startX + 10;
        topY = startY - 10;
        bottomX = startX + 20;
        bottomY = startY;
        rightX = startX + 10;
        rightY = startY + 10;

        for (int i = 1; i < bunchaPegs2.length + 1; ++i) {
            Peg p = new Peg(i);
            bunchaPegs2[i - 1] = p;
            bunchaPegs2[i - 1].setLeftVertex(leftX, leftY);
            bunchaPegs2[i - 1].setTopVertex(topX, topY);
            bunchaPegs2[i - 1].setBotVertex(bottomX, bottomY);
            bunchaPegs2[i - 1].setRightVertex(rightX, rightY);
            leftX += ((width) / 7) - 2;
            topX += ((width) / 7) - 2;
            bottomX += ((width) / 7) - 2;
            rightX += ((width) / 7) - 2;
            if (i % 7 == 0) {
                leftX = startX;
                leftY += 150;
                topX = startX + 10;
                topY += 150;
                bottomX = startX + 20;
                bottomY += 150;
                rightX = startX + 10;
                rightY += 150;
            }
        }


        Marble ball1 = new Marble(bunchaPegs1, bunchaPegs2);
        Thread t1 = new Thread(new CheckColl(ball1));
        t1.start();
        bigCount = new Counter();

        TempGraphics gui = new TempGraphics(ball1, bunchaPegs1, bunchaPegs2, height, width);

        gui.start();
        TempMarble goodBall = new TempMarble();


    }


}