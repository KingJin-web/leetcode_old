package com.py;


/*编写TimeThread，负责计时，并打出当前的时间,输出小时分钟秒钟，时间格式要求为：12:35:28。并做测试。*/
//        程序分析：1.计时功能要使用线程来实现`
//        　　　　2.显示时间的格式用SimpleDateFormat类*/

import org.apache.tools.ant.taskdefs.Sleep;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-09-28 19:47
 */
public class TimeThread extends Thread {
    //计时时间，秒
    private int s;

    public TimeThread(int s) {
        this.s = s;
    }

    SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");

    @Override
    public void run() {
        for (int i = 0; i < s; i++) {
            try {
                System.out.println(sf.format(new Date()));
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("时间到！");
    }

}

class Test4 {
    public static void main(String[] args) {
        TimeThread timeThread = new TimeThread(10);
        timeThread.start();
    }
}
