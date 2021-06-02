package MyJava.fifth;

/**
 * @program: leetcode
 * @description: 2、	用实现Runnable接口的方法来编写一个程序，其中有两个运行的线程，一个线程打印前20个偶数，另一个线程打印前20个奇数，每打印一次休息1秒。
 * @author: King
 * @create: 2021-06-02 16:09
 */
public class T2 {


    public static void main(String[] args) {
        T2Test t1 = new T2Test(1);
        T2Test t2 = new T2Test(2);
        new Thread(t1).start();
        new Thread(t2).start();
        ;
    }
}

class T2Test implements Runnable {
    private int k;

    public T2Test(int k) {
        this.k = k;
    }

    @Override
    public void run() {

        for (int i = 0; i < 40; i += k) {
            if (i % 2 == 0) {
                System.out.println("偶数" + i);
            } else {
                System.out.println("奇数" + i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}