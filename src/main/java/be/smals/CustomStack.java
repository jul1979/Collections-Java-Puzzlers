package be.smals;

public class CustomStack {

    private final Object[] elements;

    private final int size;

    public CustomStack(int capacity) {
        this.size = 0;
        this.elements = new Object[capacity];
    }

    public CustomStack(CustomStack original) {
        this.elements = original.elements.clone();
        this.size = original.size;
    }

    public Object[] getElements() {
        return elements;
    }

    public int getSize() {
        return size;
    }
}