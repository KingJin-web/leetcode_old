package MyJava.Second;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-04-21 16:09
 */
public class Test {
    /**
     * @param s1
     * @param s2
     */
    public Test(Shape s1, Shape s2) {
        System.out.println(s1.s() + s2.s());
    }

    /**
     * @param S
     */
    public Test(Shape[] S) {
        double sa = 0;
        for (Shape s : S) {
            sa += s.s();
        }
        System.out.println("面积和：" + sa);
    }

    public static void main(String[] args) {

        Square s1 = new Square(5);
        Square s2 = new Square(4);
        System.out.println("正方形面积之和：" + (s1.s() + s2.s()));
        new Test(s1, s2);
        Circle c1 = new Circle(5);
        Circle c2 = new Circle(4);

        new Test(c1, c2);
        new Test(s1, s2);


        Shape[] shapes = new Shape[]{s1, s2, c1, c2};
        new Test(shapes);
    }
}
