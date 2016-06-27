package classBox;


public class Box {

    private double length;
    private double width;
    private double height;

    Box(double length, double width, double height) {
        this.setWidth(width);
        this.setLength(length);
        this.setHeight(height);
    }

    public double getSurfaceArea() {
        return (2 * this.length * this.height) + (2 * this.length * this.width) + (2 * this.width * this.height);
    }

    public double getVolume() {
        return this.width * this.height * this.length;
    }

    public double getLateralSurfaceArea() {
        return (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    private double getLength() {
        return length;
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private double getWidth() {
        return width;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }
}
