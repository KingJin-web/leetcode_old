package com.king.MyJava.third;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-05-08 16:05
 */
public class MyFrame extends JFrame {
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
        new MyFrame("计科1801班 金鹏 38 " + new Date());
    }
}
