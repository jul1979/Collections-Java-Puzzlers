package be.smals.paumard;

public class D_PlayWithShape {

    public static double area(Shape shape) {
        return switch (shape) {
            case Square square -> square.surface();
            case Circle circle -> circle.surface();
        };
    }


    public static void main(String[] args) {
        System.out.println("area of shape= " + area(new Square(4.0)));
    }
}
