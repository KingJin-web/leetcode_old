package com.king.M10;

import MyJava.exam.T5;
import com.king.Helper;
import com.king.util.MyPrint;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @program: leetcode
 * @description: 284. 窥探迭代器
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/peeking-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-10-05 00:44
 */
public class Test5 {

    //请你设计一个迭代器，除了支持 hasNext 和 next 操作外，还支持 peek 操作。
    //
    //实现 PeekingIterator 类：
    //
    //PeekingIterator(int[] nums) 使用指定整数数组 nums 初始化迭代器。
    //int next() 返回数组中的下一个元素，并将指针移动到下个元素处。
    //bool hasNext() 如果数组中存在下一个元素，返回 true ；否则，返回 false 。
    //int peek() 返回数组中的下一个元素，但 不 移动指针。

    public static void main(String[] args) {
        //输入：
        //["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
        //[[[1, 2, 3]], [], [], [], [], []]
        //输出：
        //[null, 1, 2, 2, 3, false]

        Iterator<Integer> iterator = Arrays.stream(Helper.getArrays(1,2,3)).iterator();
       // iterator.forEachRemaining(System.out::println);
        MyPrint.print(iterator);
        PeekingIterator test5 = new PeekingIterator(iterator);
        MyPrint.print(test5);
        MyPrint.print(test5.next());
        MyPrint.print(test5.peek());
        MyPrint.print(test5.next());
        MyPrint.print(test5.peek());
        MyPrint.print(test5.hasNext());

    }
}
//执行用时： 4 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 36.47% 的用户
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer next = null; // 第一次peek时, 缓存迭代的元素

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        next = iterator.next();
    }

    public Integer peek() {
        return next;
    }

    @Override
    public Integer next() {
        Integer ret = next;
        next = iterator.hasNext() ? iterator.next() : null;
        return ret;

    }
    @Override
    public boolean hasNext() {
        return next != null;
    }
}

