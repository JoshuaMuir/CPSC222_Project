package GaltonParts;

public class Peg {

    private int[] leftVertex = new int[2];
    private int[] topVertex = new int[2];
    private int[] botVertex = new int[2];
    private int[] rightVertex = new int[2];
    private int id;

    public Peg(int x) {

        id = x;

    }

    public int getId() {
        return id;
    }

    public int[] getTopVertex() {
        return topVertex;
    }

    public void setTopVertex(int x, int y) {
        topVertex[0] = x;
        topVertex[1] = y;
    }

    public int[] getBotVertex() {
        return botVertex;
    }

    public void setBotVertex(int x, int y) {
        botVertex[0] = x;
        botVertex[1] = y;
    }

    public int[] getLeftVertex() {
        return leftVertex;
    }

    public void setLeftVertex(int x, int y) {
        leftVertex[0] = x;
        leftVertex[1] = y;
    }

    public int[] getRightVertex() {
        return rightVertex;
    }

    public void setRightVertex(int x, int y) {
        rightVertex[0] = x;
        rightVertex[1] = y;
    }


}
