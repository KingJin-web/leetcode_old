package csdn;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-05-11 19:45
 */
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> urls = ListLinks.getVisitUrls("http://blog.csdn.net/wangyongge85?viewmode=contents");

        for(int k=0; k<15; k++){// 43*10000*10

            for(String url:urls){
                new VisitThread("http://blog.csdn.net/zhangxin09/article/details/48209239").start();

            }

        }

    }

}