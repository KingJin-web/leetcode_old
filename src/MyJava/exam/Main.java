package MyJava.exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


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
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
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
        new MyFrame("我的窗口");
    }
}

//4，编写一个窗口，其中有一个文本框。其中会显示鼠标在窗口拖动的坐标。
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
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
        new MyFrame2("我的窗口");
    }
}

//5，编程序将D:\MyJava\1MG.jpg图片复制到D:\Pic.jpg
//import java.io.*;
class T5 {
    /**
     * 实现文件的复制粘贴
     *
     * @param oldFile
     * @param newFile
     * @throws IOException
     */
    public static void copyFile(String oldFile, String newFile) {
        File srcFile = new File(oldFile);
        File targetFile = new File(newFile);

        if (!srcFile.exists()) {
            System.out.println("文件不存在");
            return;
        }
        try (InputStream in = new FileInputStream(srcFile);
             OutputStream out = new FileOutputStream(targetFile);
        ) {
            targetFile.createNewFile();
            //根据抽象路径创建一个新的空文件，当抽象路径制定的文件存在时，创建失败。
            byte[] bytes = new byte[1024];
            int len;
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件复制成功");


    }

    /**
     * 实现文件的复制粘贴
     * 更快
     *
     * @param oldFile
     * @param newFile
     * @throws IOException
     */
    public static void copyFile2(String oldFile, String newFile) {
        File srcFile = new File(oldFile);
        File targetFile = new File(newFile);
        if (!srcFile.exists()) {
            System.out.println("文件不存在");
            return;
        }

        try (InputStream in = new FileInputStream(srcFile);
             OutputStream out = new FileOutputStream(targetFile);
             BufferedInputStream bin = new BufferedInputStream(in);
             BufferedOutputStream bout = new BufferedOutputStream(out);
        ) {
            targetFile.createNewFile();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bin.read(bytes)) != -1) {
                bout.write(bytes, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件复制成功");

    }

    public static void main(String[] args) {
        T5.copyFile("D:\\MyJava\\1MG.jpg", "D:\\Pic1.jpg");
        T5.copyFile2("D:\\MyJava\\1MG2.jpg", "D:\\Pic2.jpg");
    }

}

//6，编程序从键盘写日记到D: \日记. txt中。
//import java.io.*;
//import java.util.Scanner;
class T6 {

    public static void writeTxt(String outFile) throws IOException {
        File file = new File(outFile);
        file.createNewFile();
        try (Scanner input = new Scanner(System.in);
             FileWriter fw = new FileWriter(file, true); //表示追加
             BufferedWriter bw = new BufferedWriter(fw);
        ) {
            String inString;
            //当输入为空时结束
            while ((inString = input.nextLine()).length() >= 1) {
                bw.write(inString);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        T6.writeTxt("D:/aa/日记.txt");
    }

}

//7，编一个服务器程序，接收到客户的名字后，向该客户问好。
class T7 {
    public static int port = 9999;

    public static void main(String[] args) throws IOException {

        Socket client = new Socket(InetAddress.getLocalHost(), 9999); //客户端链接服务器 9999 端口 并随机选用一个端口作为发送端

        OutputStream os = client.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        InputStream is = client.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        dos.writeUTF("我是一个客户端");
        dos.flush();
        System.out.println("客户端发送完毕");
        String s;
        if ((s = dis.readUTF()) != null) {
            System.out.println("服务器" + client.getRemoteSocketAddress() + "的问候为: "
                    + s);
        }
        client.close();
        dos.close();
        dis.close();
    }
}

class T8 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器" + serverSocket.getLocalSocketAddress() + "在等待客户端链接");
        while (true) {
            Socket client = serverSocket.accept();

            System.out.println("一个新的客户端：" + client.getRemoteSocketAddress() + "链接成功");

            OutputStream os = client.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            InputStream is = client.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            dos.writeUTF("hello :" + dis.readUTF());
            dos.flush();
            os.flush();

            os.close();
            dos.close();
            client.close();
            dis.close();
        }
    }
}
//9，编一个程序，喊口号“中国”，20次， 每次休息1秒钟;
//同时喊“加油!”，20次，每次休息2秒钟。
class T9China extends Thread{
    @Override   // 重写了Thread类中的 run()
    public void run() {     //
        //操作:
        for (int i = 0; i < 20; i++) {
            System.out.println("中国");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class T9Refuel extends Thread{
    @Override   // 重写了Thread类中的 run()
    public void run() {     //
        //操作:
        for (int i = 0; i < 20; i++) {
            System.out.println("加油");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class T9Test{
    public static void main(String[] args) {
        T9China t9China = new T9China();
        T9Refuel t9Refuel = new T9Refuel();

        t9China.start(); t9Refuel.start();
    }
}