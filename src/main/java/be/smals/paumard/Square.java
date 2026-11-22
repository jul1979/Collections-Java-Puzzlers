package be.smals.paumard;

public record Square(double edge) implements Shape {
    @Override
    public double surface() {
        return edge*edge;
    }
}
