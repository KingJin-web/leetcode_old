package MyJava.Second;

/**
 * @program: leetcode
 * @description: 正方形
 * @author: King
 * @create: 2021-04-21 16:10
 */
public class Square implements Shape {
    private double l;

    public Square(double l) {
        this.l = l;
    }

    @Override
    public double s() {
        return l * l;
    }
}
