package Engine;

public class CheckColl implements Runnable {

    private Marble ball;

    public CheckColl(Marble ball1) {


        ball = ball1;

    }

    public void run() {

        System.out.println("in run");
        while (true) {
            try {
                Thread.sleep(50);
                if (ball.getYCoord() > 400 && ball.getYCoord() < 500) {
                    //ball.collide(true);
                    //	TempGraphics.createBall(ball);
                } else ;
            } catch (InterruptedException e) {
                System.out.println("gold");
            }
        }


    }



}