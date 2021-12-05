package com.king.util;

import MyJava.exam.T1;
import com.king.Helper;

import java.lang.reflect.*;
import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-09-04 11:26
 */
public class MyPrint {




    public static void println(Object o) {
        System.out.println(o);
    }

    public static void print(List... os) {
        for (Object o : os) {
            print(o);
        }
    }

    public static void printf(Object o) {
        System.out.print(o);
    }

    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    //输出一个空行
    public static void print() {
        printf('\n');
    }

    /**
     * https://www.cnblogs.com/fjdingsd/p/5272242.html
     * //自己封装的输出，可以直接打印数组，list，Iterator等
     *
     * @param o
     */
    public static void print(Object o) {

        if (o == null) {
            print("null");
            return;
        }
        if (isArray(o)) {
            //print(Arrays.deepToString(o));

            List<Object> coll = new ArrayList<>();
            int length = Array.getLength(o);
            for (int i = 0; i < length; i++) {
                Object value = Array.get(o, i);
                if (isArray(value)) {
                    print(value);
                } else {
                    coll.add(value);
                }
            }

            if (!coll.isEmpty()) {
                print(toString(coll.toArray()));
            }

        } else if (o instanceof List) {
            List list = (List) o;
            print("=========list-start=========");
            if (list.size() <= 0) {
                print("null");
                return;
            }
            if (!isArray(list.get(0))) {
                if (list.get(0) instanceof Number || list.get(0) instanceof String) {
                    print(toString(list.toArray()));
                } else {
                    list.forEach(MyPrint::println);
                }
            } else {
                for (Object o1 : list) {
                    int length = Array.getLength(o1);
                    List<Object> coll = new ArrayList<>();
                    for (int i = 0; i < length; i++) {
                        Object value = Array.get(o1, i);
                        coll.add(value);
                    }
                    print(toString(coll.toArray()));
                }
            }
            print("=========list-end=========");
        } else if (o instanceof Iterator) {
            Iterator<?> iterator = ((Iterator<?>) o);

            List<Object> list = new ArrayList<>();
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
            print(list.toArray());
        } else {
            println(o);
        }

    }

    public static void print(String s) {
        System.out.println(s);
    }

    public static void printIsLn(Object o) {
        print(o, true);
        print();
    }

    //    print(MyPrint.class);
    public static void print(Class<?> c) {
        println(c);
        if (c.isArray()) {
            println("isArray");
        }
        if (c.isInterface()) {
            println("isInterface");
        }


        try {
            // 根据传入的类的全名来创建Class对象,注意必须是全名

            // 得到包路径
            System.out.println("package " + c.getPackage().getName() + ";\n");
            // 得到类修饰符
            System.out.print(Modifier.toString(c.getModifiers()));
            //得到类名
            System.out.print(" class " + c.getSimpleName());
            //得到父类名
            System.out.print(" extends " + c.getSuperclass().getSimpleName());
            //得到类实现的接口数组
            Class[] inters = c.getInterfaces();
            if (inters.length > 0) {
                System.out.print(" implements ");
                for (int i = 0; i < inters.length; i++) {
                    System.out.print(inters[i].getSimpleName());
                    if (i < inters.length - 1) {
                        System.out.print(", ");
                    }
                }
            }
            System.out.println(" {");
            // 获取类属性
            printField(c);
            // 获取类构造器
            printConstructor(c);
            // 获取类方法
            printMethods(c);
            System.out.println(" }");

        } catch (Exception e) {
            e.printStackTrace();
        }


//        Field[] fields = c.getFields();
//        print(fields.length);
//        Method[] methods1 = c.getMethods();
//        print(methods1, 1);
//        print();
//        Method[] methods2 = c.getDeclaredMethods();
//        print(methods2, 1);
    }


    /**
     * https://www.cnblogs.com/fjdingsd/p/5272242.html
     *
     * @param o
     */
    public static void print(Object o, boolean b) {

        if (isArray(o)) {
            List<Object> coll = new ArrayList<>();
            int length = Array.getLength(o);
            for (int i = 0; i < length; i++) {
                Object value = Array.get(o, i);
                if (isArray(value)) {
                    print(value, true);
                } else {
                    coll.add(value);
                }
            }
            if (!coll.isEmpty()) {
                print(coll, true);
            }
        } else if (getType(o).contains("List")) {
            List list = (List) o;
            print("[", false);
            for (Object object : list) {
                print(object, false);
            }
            print("]", false);
        } else {
            if (b) {
                System.out.println(o);
            } else {
                System.out.print(o);
            }
        }

    }
//    public static void print(int[]... s) {
//        print(Arrays.deepToString(s));
//    }

    public static void print(Object o, int n) {
        if (isArray(o)) {
            Collection<Object> coll = new ArrayList<>();
            int length = Array.getLength(o);
            for (int i = 0; i < length; i++) {
                Object value = Array.get(o, i);
                coll.add(value);
            }
            print(toString(coll.toArray(), n));
        } else {
            print("这不是数组 !");
            print(o);
        }
    }

    public static void print(Object[] o, int l) {
        if (o.length <= 0) {
            print("null");
            return;
        }
        if (o.length == 1) {
            print(o[0]);
            return;
        }
        for (int i = 1; i < o.length; ++i) {
            System.out.print(o[i - 1] + ", ");
            if (i % l == 0) {
                print();
            }
        }
        System.out.println(o[o.length - 1]);

    }

    public static String toString(Object[] a) {
        if (a == null)
            return "null";

        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }

    public static void printA(int[][] a) {
        print(Arrays.deepToString(a));
    }

    public static void println(int... objects) {
        print(objects);
    }

    public static void print(Object[]... o) {
        print(Arrays.deepToString(o));
    }


    public static void print(String[]... s) {
        print(Arrays.deepToString(s));
    }

    public static void print(char[]... chars) {
        print(Arrays.deepToString(chars));
    }

//    public static void print(List<List<Integer>> o) {
//        o.forEach(MyPrint::print);
//    }

    public static void printList(List list) {


        for (Object o : list) {
            if (o instanceof List) {
                printList((List) o);
            } else {
                System.out.print(o + " ");
            }
        }
        System.out.println();
    }

    /**
     * 对象是否为数组对象
     *类型
     * @param obj 对象
     * @return 是否为数组对象，如果为{@code null} 返回空指针
     */
//    public static boolean isType(Object obj,Class type) {
//        if (null == obj) {
//            throw new NullPointerException("Object is null");
//        }
//        return obj instanceof type;
//    }

    /**
     * 对象是否为数组对象
     *
     * @param obj 对象
     * @return 是否为数组对象，如果为{@code null} 返回空指针
     */
    public static boolean isArray(Object obj) {
        if (null == obj) {
            //throw new NullPointerException("Object check for isArray is null");
            print("null");
        }
//        反射 获得类型
        return obj.getClass().isArray();
    }


    /**
     * 数组分页
     *
     * @param o 数组
     * @param l 每页数据量
     * @return
     */
    private static String toString(Object[] o, int l) {
        if (o == null)
            return "null";
        int iMax = o.length - 1;
        if (iMax == -1)
            return "[]";
        StringBuilder b = new StringBuilder();
        b.append("[ ");
        for (int i = 1; i < o.length; ++i) {

            b.append(String.format("%-5s ", o[i - 1]));
            if (i % l == 0) {
                b.append("]\n[ ");
            }

        }
        b.append(o[iMax]).append(" ]\n");

        return b.toString();
    }

    /**
     * 获取变量数据类型
     *
     * @param o
     * @return
     */
    public static String getType(Object o) {
        return o.getClass().getSimpleName();
    }

    public static void printError(String message) {
        System.err.println(message);
    }

    public static void printf(int... nums) {
        print(nums);
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            // 根据传入的类的全名来创建Class对象,注意必须是全名
            c = Class.forName("test.Person");
            // 得到包路径
            System.out.println("package " + c.getPackage().getName() + ";\n");
            // 得到类修饰符
            System.out.print(Modifier.toString(c.getModifiers()));
            //得到类名
            System.out.print(" class " + c.getSimpleName());
            //得到父类名
            System.out.print(" extends " + c.getSuperclass().getSimpleName());
            //得到类实现的接口数组
            Class[] inters = c.getInterfaces();
            if (inters.length > 0) {
                System.out.print(" implements ");
                for (int i = 0; i < inters.length; i++) {
                    System.out.print(inters[i].getSimpleName());
                    if (i < inters.length - 1) {
                        System.out.print(", ");
                    }
                }
            }
            System.out.println(" {");
            // 获取类属性
            printField(c);
            // 获取类构造器
            printConstructor(c);
            // 获取类方法
            printMethods(c);
            System.out.println(" }");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printConstructor(Class c){
        Constructor[] cs = c.getConstructors();
        for (int i = 0; i < cs.length; i++) {
            System.out.println();
            System.out.print("\t");
            // 得到整数形式构造函数修饰符，使用Modifier进行解码
            System.out.print(Modifier.toString(cs[i].getModifiers()) + " ");
            // 得到方法名
            System.out.print(cs[i].getName() + "(");
            // 得到方法参数数组
            Class[] paras = cs[i].getParameterTypes();
            for (int j = 0; j < paras.length; j++) {
                System.out.print(paras[j].getSimpleName() + " arg" + j);
                if (j < paras.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print(")");
            System.out.println(" {");
            System.out.println("\t\t\\\\方法体");
            System.out.println("\t}");
        }
    }

    private static void printField(Class c) {
        // 得到属性数组
        Field[] fs = c.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            System.out.print("\t");
            // 得到整数形式属性修饰符，使用Modifier进行解码
            System.out.print(Modifier.toString(fs[i].getModifiers()) + " ");
            // 得到属性类型
            System.out.print(fs[i].getType().getSimpleName() + " ");
            // 得到属性名
            System.out.println(fs[i].getName() + ";");
        }
    }

    public static void printMethods(Class c) {
        // 得到方法数组
        Method[] md = c.getMethods();
        for (int i = 0; i < md.length; i++) {
            System.out.println();
            System.out.print("\t");
            // 得到整数形式方法修饰符，使用Modifier进行解码
            System.out.print(Modifier.toString(md[i].getModifiers()) + " ");
            // 得到方法返回类型
            System.out.print(md[i].getGenericReturnType() + " ");
            // 得到方法名
            System.out.print(md[i].getName() + "(");
            // 得到方法参数数组
            Class[] paras = md[i].getParameterTypes();
            for (int j = 0; j < paras.length; j++) {
                System.out.print(paras[j].getSimpleName() + " arg" + j);
                if (j < paras.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print(")");
            // 得到抛出的异常类数组
            Class[] exceps = md[i].getExceptionTypes();
            if (exceps.length > 0) {
                System.out.print(" throws ");
                for (int k = 0; k < exceps.length; k++) {
                    System.out.print(exceps[k].getSimpleName());
                    if (k < exceps.length - 1) {
                        System.out.print(", ");
                    }
                }
            }
            System.out.println(" {");
            System.out.println("\t\t\\\\方法体");
            System.out.println("\t}");
        }
    }
}
