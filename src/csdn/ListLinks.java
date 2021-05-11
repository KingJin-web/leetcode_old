package csdn;

import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-05-11 19:45
 */
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;

import java.io.IOException;

import java.util.ArrayList;

import java.util.List;

/**
 * Example program to list links from a URL.
 */

public class ListLinks {
    public static void main(String[] args) throws IOException {
        getVisitUrls("http://blog.csdn.net/lmj623565791?viewmode=contents");

    }

    public static List getVisitUrls(String url) {
        Document doc = null;

        try {
            doc = Jsoup.connect(url).data("query", "Java") // 请求参数

                    .userAgent("Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0; BIDUBrowser 2.x)")

                    .timeout(3000000) // 设置连接超时时间

                    .post(); // 使用post方法访问 URL

        } catch (IOException ex) {
            ex.printStackTrace();

        }

        Elements links = doc.select("span").attr("class", "link_title").select("a");

        List<String> urls = new ArrayList<>();

        for (int i = 0; i <= Integer.MAX_VALUE; i++) {
            if (i % 3 == 0) {
                urls.add(links.get(i).attr("abs:href"));

                System.out.println(links.get(i).attr("abs:href"));

            }
        }

        return urls;
    }


}

