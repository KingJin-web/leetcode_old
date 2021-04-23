package com.king;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("aaa");
        //new B().a.eat();
    }
}

class A{
    public void eat(){
        System.out.println("a");
    }
}

class B{
    private A a = new A();

    public static void main(String[] args) {
       B b =  new B();
       b.a.eat();
    }
}