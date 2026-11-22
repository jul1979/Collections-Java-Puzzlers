package be.smals.paumard;

public record Circle(double radius) implements Shape {
    @Override
    public double surface() {
        return Math.PI*radius*radius;
    }
}
