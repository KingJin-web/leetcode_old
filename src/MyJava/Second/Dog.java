package MyJava.Second;

/**
 * @program: leetcode
 * @description: 狗类
 * @author: King
 * @create: 2021-04-21 16:18
 */
public class Dog implements Animal {
    @Override
    public void cry() {
        System.out.println("汪 汪 汪!");
    }

    @Override
    public String getAnimalName() {
        return "狗";
    }
}
