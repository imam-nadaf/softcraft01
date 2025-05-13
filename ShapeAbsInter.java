// Example of abstract class
abstract class Shape {
    // Abstract method (no implementation)
    abstract double area();

    // Concrete method (has implementation)
    void display() {
        System.out.println("This is a shape.");
    }
}

class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

// Example of interface
interface Drawable {
    void draw();
}

class Rectangle implements Drawable {
    int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing rectangle with width " + width + " and height " + height);
    }
}

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("Circle area: " + circle.area());
        circle.display();

        Rectangle rectangle = new Rectangle(10, 20);
        rectangle.draw();
    }
}
