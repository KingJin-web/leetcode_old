package MyJava.exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @program: leetcode
 * @description: //4，编写一个窗口，其中有一个文本框。其中会显示鼠标在窗口拖动的坐标。
 * @author: King
 * @create: 2021-05-10 00:02
 */


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
