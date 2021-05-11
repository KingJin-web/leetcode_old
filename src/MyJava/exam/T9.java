package MyJava.exam;

/**
 * @program: leetcode
 * @description: //9，编一个程序，喊口号“中国”，20次， 每次休息1秒钟;
 * //同时喊“加油!”，20次，每次休息2秒钟。
 * @author: King
 * @create: 2021-05-10 00:13
 */
public class T9 {
    public static void main(String[] args) {
        T9China t9China = new T9China();
        T9Refuel t9Refuel = new T9Refuel();

        t9China.start();
        t9Refuel.start();
    }


}


class T9China extends Thread {
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

class T9Refuel extends Thread {
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
