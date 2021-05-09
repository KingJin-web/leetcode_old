package MyJava.exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-05-10 00:00
 */
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
        new MyFrame("我的窗口");
    }
}
