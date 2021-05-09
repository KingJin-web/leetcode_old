package MyJava.exam;

/**
 * @program: leetcode
 * @description: 2, 定义一个平面图形接口，其中有圆周率和求面积方法。分别定义一个正方形类和一个圆类
 * 都实现了该接口。造两个正方形对象和两个圆对象，用多态的方式求它们的面积之和。
 * @author: King
 * @create: 2021-05-09 23:59
 */
public class T2 {
    public static double sum(Shape[] shapes) {
        double c = 0;
        for (Shape shape : shapes) {
            c += shape.s();
        }
        return c;
    }

    public static void main(String[] args) {
        Circle circle = new Circle(15);
        Square square = new Square(5);
        Circle circle1 = new Circle(1.8);
        Shape[] shapes = {circle, square, circle1};
        System.out.println("面积和为：" + sum(shapes));

    }
}

interface Shape {
    double PI = Math.PI;

    /**
     * 面积
     *
     * @return
     */
    abstract double s();
}

class Square implements Shape {
    private double l;

    public Square(double l) {
        this.l = l;
    }

    @Override
    public double s() {
        return l * l;
    }
}

class Circle implements Shape {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double s() {
        return PI * r * r;
    }
}
