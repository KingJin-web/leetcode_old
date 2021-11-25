package com.king.M11;

import java.io.*;

/**
 * @program: leetcode
 * @description: 384. ´òÂÒÊý×é
 * @author: King
 * @create: 2021-11-22 22:56
 */
public class Test22 {
    class Solution {

        public Solution(int[] nums) {

        }

        public int[] reset() {

            return null;
        }

        public int[] shuffle() {
            return null;
        }

    }

    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream(new File("D:\\a\\a\\ha.txt"));
             ObjectInputStream o = new ObjectInputStream(fileInputStream);) {
            while (true) {
                System.out.println(o.readObject());
            }
        } catch (EOFException e) {
            System.out.println("aaa");
        } catch (IOException e) {
            System.out.println("aa");
        } catch (Exception e) {
            System.out.println("a");
        }
    }


    public static class ObjectStream {
        public static void main(String[] args) throws Exception {


            try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
                 ObjectOutputStream oos = new ObjectOutputStream(bos);) {
                User user1 = new User("yiwangzhibujian", 27);
                User user2 = new User("laizhezhikezhui", 24);
                oos.writeObject(user1);
                oos.writeObject(user2);
                oos.writeObject(null);

                byte[] data = bos.toByteArray();
                ByteArrayInputStream bis = new ByteArrayInputStream(data);
                ObjectInputStream ois = new ObjectInputStream(bis);

                System.out.println(ois.readObject());
                System.out.println(ois.readObject());
                System.out.println(ois.readObject());
                System.out.println(ois.readObject());
            } catch (EOFException e) {
                System.err.println("EOFException");
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println("IOException");
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Exception");
                e.printStackTrace();
            }
        }
    }

    static class User implements Serializable {
        private static final long serialVersionUID = 1L;
        public String name;
        public int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User [name=" + name + ", age=" + age + "]";
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}


