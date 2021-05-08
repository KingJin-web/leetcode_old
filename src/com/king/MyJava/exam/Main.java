package com.king.MyJava.exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * @program: leetcode
 * @description: 考试
 * @author: King
 * @create: 2021-05-08 15:45
 */
public class Main {
}

//1， 编写一个点类，其中有构造方法，位移方法和展示坐标的方法，定义一个主方法，其中使用到所有这些方法。
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


//2,定义一个平面图形接口，其中有圆周率和求面积方法。分别定义一个正方形类和一个圆类
//都实现了该接口。造两个正方形对象和两个圆对象，用多态的方式求它们的面积之和。
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

class test {
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

//3,编写一个窗口，其中有两个文本框和一个按钮。在第一个文本框中写入文字，点击按钮，
//该文字就会被复制到第二个文本框中，第一个文本框会清空。
class MyFrame extends JFrame {
    JTextField tf1, tf2;
    JButton bt;

    MyFrame(String s) {
        super(s);
        setBounds(100, 200, 600, 500);
        setLayout(new FlowLayout());
        tf1 = new JTextField(20);
        tf2 = new JTextField(20);
        bt = new JButton("COPY");
        add(tf1);
        add(bt);
        add(tf2);
        setVisible(true);
        setDefaultCloseOperation
                (JFrame.EXIT_ON_CLOSE);
        Handler hd = new Handler();
        bt.addActionListener(hd);
    }

    class Handler implements ActionListener {
        public void
        actionPerformed(ActionEvent e) {
            String s = tf1.getText();
            tf2.setText(s);
            tf1.setText("");
        }
    }

    public static void main(String[] args) {
        new MyFrame("Hello");
    }
}

//4，编写一个窗口，其中有一个文本框。其中会显示鼠标在窗口拖动的坐标。
class MyFrame2 extends JFrame {


    JTextField tf;
    Handler hd;

    MyFrame2(String s) {
        super(s);

        this.setSize(400, 400);//设置好宽高
        this.setLocationRelativeTo(null);//窗体居中显示
        setLayout(new FlowLayout());
        tf = new JTextField(20);
        add(tf);
        setVisible(true);
        setDefaultCloseOperation
                (EXIT_ON_CLOSE);
        hd = new Handler();
        addMouseMotionListener(hd);
    }

    class Handler implements MouseMotionListener {
        public void mouseMoved(MouseEvent e) {
        }

        public void mouseDragged(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            tf.setText("x :" + x + "   " + "y :" + y);
        }
    }

    public static void main(String[] args) {
        new MyFrame2("My 3rd Window");
    }
}