package be.smals;

class Rectangle {
    protected int width, height;

    public Rectangle(int width,
                     int height) {
        this.width = width;
        this.height = height;
    }
    public Rectangle(){

    }

    public Rectangle(int side) {
        if (side < 0) throw new IllegalArgumentException("side should be greater than 0");
        this.width = side;
        this.height = side;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}