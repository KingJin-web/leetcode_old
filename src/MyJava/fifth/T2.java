package MyJava.fifth;

/**
 * @program: leetcode
 * @description: 2、	用实现Runnable接口的方法来编写一个程序，其中有两个运行的线程，一个线程打印前20个偶数，另一个线程打印前20个奇数，每打印一次休息1秒。
 * @author: King
 * @create: 2021-06-02 16:09
 */
public class T2 {


    public static void main(String[] args) {

        Thread t1 = new Thread(new T2A());
        Thread t2 = new Thread(new T2B());
        t1.start();
        t2.start();
        ;
    }
}

class T2A implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 40; i++) {
            if (i % 2 == 0) {
                System.out.println("偶数" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

class T2B implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 40; i++) {
            if (i % 2 != 0) {
                System.out.println("奇数" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}