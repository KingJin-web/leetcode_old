package MyJava.exam;

/**
 * @program: leetcode
 * @description: 1， 编写一个点类，其中有构造方法，位移方法和展示坐标的方法，定义一个主方法，其中使用到所有这些方法。
 * @author: King
 * @create: 2021-05-09 23:57
 */
public class T1 {

}

class Point {
    private double X;
    private double Y;

    public Point(double x, double y) {
        X = x;
        Y = y;
    }

    @Override
    public String toString() {
        return "X=" + X + ", Y=" + Y;
    }

    public void moveTo(double x, double y) {
        this.X = x;
        this.Y = y;

    }

    public static void main(String[] args) {
        Point point = new Point(5, -5);
        System.out.println(point);
        point.moveTo(18, 19);
        System.out.println(point);
    }
}


