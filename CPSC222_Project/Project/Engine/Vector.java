package Engine;

public class Vector {

    private double xVel;
    private double yVel;
    private double gravity;
    private double momentum;

    public Vector() {
        momentum = 0;
        xVel = 0;
        yVel = 0;
        gravity = .000981;

    }

    protected void startFall() {

        //sw1.start();


    }

    public double getXVel() {
        return xVel;


    }

    public void setXVel(double a) {

        xVel = a;


    }

    public double getYVel(double a) {
        yVel = gravity * a;

        return yVel;

    }

    public void setYVel(double a) {

        yVel = a;

    }

    protected void collide1() {


        yVel *= 0.5;

    }
}
