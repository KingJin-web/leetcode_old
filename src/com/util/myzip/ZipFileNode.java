package com.util.myzip;

import com.king.ListNode;

import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-09-13 15:00
 */
public class ZipFileNode {
    public List<String> fileName;
    public String dirName;
    public ZipFileNode next;

    public ZipFileNode() {
    }

    public ZipFileNode(List<String> fileName) {
        this.fileName = fileName;
    }

    public ZipFileNode(List<String> fileName, ZipFileNode next) {
        this.fileName = fileName;
        this.next = next;
    }

    public void println() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "ZipFileNode{" +
                "fileName=" + fileName +
                ", next=" + next +
                '}' + '\n';
    }
}
