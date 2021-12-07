package com.king.M12;

import com.king.util.MyPrint;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description: 1816. 截断句子
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/truncate-sentence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-12-06 22:25
 */
public class Test6 {

    //执行用时： 1 ms , 在所有 Java 提交中击败了 53.65% 的用户 内存消耗： 36.9 MB , 在所有 Java 提交中击败了 24.02% 的用户
    public String truncateSentence(String s, int k) {
      String[] strings = s.split(" ");
      StringBuilder stringBuilder = new StringBuilder();
      int i = 0;
      while (i < k - 1){
          stringBuilder.append(strings[i]).append(" ");
          ++i;
      }
      stringBuilder.append(strings[k - 1]);
      return stringBuilder.toString();
    }

    public String truncateSentence2(String s, int k) {
        return Arrays.stream(s.split(" ")).limit(k).collect(Collectors.joining(" "));
    }
    public String truncateSentence1(String s, int k) {
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == ' ' && --k == 0)
                return s.substring(0, i);
        return s;
    }

    public static void main(String[] args) {
        Test6 test6 = new Test6();

        //输入：s = "Hello how are you Contestant", k = 4
        //输出："Hello how are you"
        //解释：
        //s 中的单词为 ["Hello", "how" "are", "you", "Contestant"]
        //前 4 个单词为 ["Hello", "how", "are", "you"]
        //因此，应当返回 "Hello how are you"
        //

        MyPrint.print(test6.truncateSentence("Hello how are you Contestant", 4));
    }
}
