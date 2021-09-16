package com.king.M09;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 1115. 交替打印FooBar
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-09-16 19:34
 */
public class Test16 {
    static class FooBar {
        private int n;
        private volatile boolean finish = false;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                while (finish) {
                    Thread.yield();
                }
                printFoo.run();
                finish = true;
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                while (!finish) {
                    Thread.yield();
                }
                printBar.run();
                finish = false;
            }
        }


    }

    public static void main(String[] args) {
        //a，b这两个runnable 实际上在foo，和bar里面执行的是原生的run方法。
        Runnable a = ()->{
            System.out.print("foo");
        };

        Runnable b = ()->{
            System.out.print("bar");
        };

        FooBar fooBar2 = new FooBar(11);

        //真正start的是这个。lamada表达式创建的匿名类
        new Thread(()->{
            try {
                fooBar2.bar(b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                fooBar2.foo(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

//执行用时： 24 ms , 在所有 Java 提交中击败了 31.45% 的用户 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 93.63% 的用户


