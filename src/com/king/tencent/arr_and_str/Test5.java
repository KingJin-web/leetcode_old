package com.king.tencent.arr_and_str;

import com.king.Helper;
import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.text.DecimalFormat;

/**
 * @program: leetcode
 * @description: 最长公共前缀
 * @author: King
 * @create: 2021-04-18 20:19
 */
public class Test5 extends Helper {
    static Test5 t5 = new Test5();
    static int a = 0;

    public static void main(String[] args) {
        print(a);
    }

    private static void print(int aa) {

        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        // 椎内存使用情况
        MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage();

        // 初始的总内存
        long initTotalMemorySize = memoryUsage.getInit();
        // 最大可用内存
        long maxMemorySize = memoryUsage.getMax();
        // 已使用的内存
        long usedMemorySize = memoryUsage.getUsed();

        // 操作系统
        String osName = System.getProperty("os.name");
        // 总的物理内存
        String totalMemorySize = new DecimalFormat("#.##")
                .format(osmxb.getTotalPhysicalMemorySize() / 1024.0 / 1024 / 1024) + "G";
        // 剩余的物理内存
        String freePhysicalMemorySize = new DecimalFormat("#.##")
                .format(osmxb.getFreePhysicalMemorySize() / 1024.0 / 1024 / 1024) + "G";
        // 已使用的物理内存
        String usedMemory = new DecimalFormat("#.##").format(
                (osmxb.getTotalPhysicalMemorySize() - osmxb.getFreePhysicalMemorySize()) / 1024.0 / 1024 / 1024)
                + "G";
        // 获得线程总数
        ThreadGroup parentThread;
        for (parentThread = Thread.currentThread().getThreadGroup(); parentThread
                .getParent() != null; parentThread = parentThread.getParent()) {
            Helper.print("");
        }
        print(totalMemorySize + " " + freePhysicalMemorySize + " " + usedMemory);

        print(initTotalMemorySize);
        print(maxMemorySize);
        print(usedMemorySize);
        print(osName);

    }
}
