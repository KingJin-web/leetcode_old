# 笔记

```java
//消耗的内存
Runtime r=Runtime.getRuntime();
        r.gc();
        long startMem=r.freeMemory(); // 开始时的剩余内存
        long endMem=r.freeMemory(); // 结束时的剩余内存
        long mem=startMem-endMem; // 

//消耗的时间
        double startTime=System.currentTimeMillis();
        double endTime=System.currentTimeMillis();
        double time=endTime-startTime;

```

### 二分查找

当我们要从一个序列中查找一个元素的时候，二分查找是一种非常快速的查找算法， 二分查找又叫折半查找。 它对要查找的序列有两个要求，

一是该序列必须是有序的 （即该序列中的所有元素都是按照大小关系排好序的，升序和降序都可以）

二是该序列必须是顺序存储的

[整个例子](test/TestBinarySearch.java)
