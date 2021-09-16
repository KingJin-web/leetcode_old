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
}

//执行用时： 24 ms , 在所有 Java 提交中击败了 31.45% 的用户 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 93.63% 的用户
class FooBar {
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

    public void foo() {
        for (int i = 0; i < n; i++) {
            MyPrint.print("foo");
        }
    }

    public void bar() {
        for (int i = 0; i < n; i++) {
            MyPrint.print("bar");
        }
    }
}

