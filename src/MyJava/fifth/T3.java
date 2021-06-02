package MyJava.fifth;

import javax.swing.*;
import java.awt.*;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-06-02 17:03
 */
public class T3 extends JFrame implements Runnable {
    JLabel jl;
    int x;

    public T3(String s) throws HeadlessException {
        super(s);
        setBounds(100, 150, 400, 300);
        setLayout(null);
        jl = new JLabel("Hello World");
        add(jl);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    @Override
    public void run() {
        while (true) {
            x++;
            x = x % getWidth();
            jl.setBounds(x,50,200,100);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        T3 t3 = new T3("King");

        Thread thread = new Thread(t3);
        thread.start();
    }
}
