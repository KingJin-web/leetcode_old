package com.king;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-07-07 21:04
 */
public class Helper {
    public static int[] getArrays(int... nums) {
        return nums;
    }

    public static String[] getArrays(String... s) {
        return s;
    }

    public static int[][] getArrays(int[]... arr) {
        return arr;
    }

    public static List<String> getList(String... s) {
        return Arrays.asList(s);
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void print(int[] o) {
        print(toString(o, 5));
    }

    private static String toString(int[] o, int l) {
        if (o == null)
            return "null";
        int iMax = o.length - 1;
        if (iMax == -1)
            return "[]";
        StringBuilder b = new StringBuilder();
        for (int i = 1; i < o.length; ++i) {
            b.append(o[i - 1]).append(", ");
            if (i % l == 0) {
                b.append('\n');
            }
        }
        b.append(o[iMax]).append("\n");
        return b.toString();
    }

    public static void print(boolean[] o) {
        print(print(o, 5));
    }

    private static String print(boolean[] o, int l) {
        if (o == null)
            return "null";
        int iMax = o.length - 1;
        if (iMax == -1)
            return "[]";
        StringBuilder b = new StringBuilder();
        for (int i = 1; i < o.length; ++i) {
            b.append(o[i - 1]).append(", ");
            if (i % l == 0) {
                b.append('\n');
            }
        }
        b.append(o[iMax]).append("\n");
        return b.toString();
    }

    public static void print(Object[] o, int l) {

        for (int i = 1; i < o.length; ++i) {
            System.out.print(o[i - 1] + ", ");
            if (i % l == 0) {
                System.out.print('\n');
            }
        }
        System.out.println(o[o.length - 1]);

    }

    public static void print(Object[] o) {
        System.out.println(Arrays.toString(o));
    }

    public static void print(Object[]... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public static void print(int[]... s) {
        System.out.println(Arrays.deepToString(s));
    }

    public static void print(String[]... s) {
        System.out.println(Arrays.deepToString(s));
    }

    public static void print(char[]... chars) {
        System.out.println(Arrays.deepToString(chars));
    }


    public static void print(List<List<Integer>> o) {
        for (List<Integer> l : o) {
            System.out.println(l);
        }
    }

    public static void printList(List l) {

        for (Object o : l) {
            if (o.getClass().getSimpleName().endsWith("List")) {
                printList((List) o);
            } else {
                System.out.print(o + " ");
            }
        }
        System.out.println();
    }

    static final Unsafe unsafe = getUnsafe();
    static final boolean is64bit = true; // auto detect if possible.

    /**
     * 返回变量的地址
     *
     * @param label
     * @param objects
     */
    public static void printAddresses(String label, Object... objects) {
        System.out.print(label + ": 0x");
        long last = 0;
        int offset = unsafe.arrayBaseOffset(objects.getClass());
        int scale = unsafe.arrayIndexScale(objects.getClass());
        switch (scale) {
            case 4:
                long factor = is64bit ? 8 : 1;
                final long i1 = (unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor;
                System.out.print(Long.toHexString(i1));
                last = i1;
                for (int i = 1; i < objects.length; i++) {
                    final long i2 = (unsafe.getInt(objects, offset + i * 4) & 0xFFFFFFFFL) * factor;
                    if (i2 > last)
                        System.out.print(", +" + Long.toHexString(i2 - last));
                    else
                        System.out.print(", -" + Long.toHexString(last - i2));
                    last = i2;
                }
                break;
            case 8:
                throw new AssertionError("Not supported");
        }
        System.out.println();
    }

    private static Unsafe getUnsafe() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    /**
     * 返回类中的所有变量名
     *
     * @param obj
     */
    public static void getName(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields)
            System.out.println("变量名：" + field.getName());
    }

    public static void printFieldNames(Object obj, Object... foos) {
        List<Object> fooList = Arrays.asList(foos);
        for (Field field : obj.getClass().getFields()) {

            System.out.println(field.getName());

        }
    }
}
