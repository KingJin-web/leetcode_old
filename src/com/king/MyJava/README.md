# java实验课

## [实验一 学习使用JDK，定义类](first)

### 实验目的

```
1、	学会使用JDK编译和运行Java程序
2、	学习定义类。
```

### 实验内容

一．学习使用JDK


1、创建一个目录来保存你的源程序。 例如创建目录 D:\MyJava。

2、用记事本编写一个Java程序


```java
class MyProg {
    public static void main(String[] args) {
        System.out.println("Welcome to Java!");
    }
}
```

3、将上面的程序取名 MyProg.java ,保存到D:\MyJava 目录中。注意查看源文件 后缀，确保其为java无误，保存类型选所有文件。注意标点符号都要用英文键盘输入。       

4、开始--> 运行，键入 CMD，进入命令界面。在命令界面中键入D: 回车。再         
再键入 cd MyJava 回车。 5、编译源程序。 在命令界面键入 javac MyProg.java 回车。如果编译不成功， 则修改源程序， 然后保存。 再重新键入上面的命令来编译，直到成功。 6、运行程序。 在命令界面键入命令
java MyProg 回车。命令界面中会出现： Welcome to Java！ 7、修改上面的例子：

```java
class MyProg1 {
    public static void main(String[] args) {
        System.out.println("This is  " + args[0]);
    }
}
```

运行时键入命令： java MyProg1 软件1801班张三（你的班名和姓名）回车。 

运行结果： This is 软件1801班张三

二、定义类 定义一个点类，有横坐标和纵坐标两个成员变量， 有构造方法，
还定义了位移方法和展示点的坐标的方法。定义主函数，其中使用了所有这些方法。


 
