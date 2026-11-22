package be.smals;

public class Square extends Rectangle {

    private int side;

    public Square(int side) {
        super(side, side);
    }

    public Square() {
    }

    @Override
    public void setWidth(int side) {
        this.width = side;
        this.height = side;
    }

    @Override
    public void setHeight(int side) {
        this.width = side;
        this.height = side;
    }
}
