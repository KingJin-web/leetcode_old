package MyJava.fifth;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-06-02 16:00
 */
public class T1 {
    public static void main(String[] args) {
        T1Test t1 = new T1Test("快线程",1000);
        T1Test t2 = new T1Test("慢线程",2000);
        t1.start();
        t2.start();
    }
}

class T1Test extends Thread {
    private String k;
    private long m;


    public T1Test(String k, long m) {
        this.k = k;
        this.m = m;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                System.out.println(k);
                Thread.sleep(m);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
