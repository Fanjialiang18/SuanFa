package huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 *
 * @author clearlove3
 */
public class LeetCode17 {
    StringBuilder sb = new StringBuilder();
    List<String> res = new ArrayList<>();
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        //迭代处理
        backTracking(digits, 0);
        return res;
    }

    public void backTracking(String digits, int num) {
        //遍历全部一次记录一次得到的字符串
        if (num == digits.length()) {
            res.add(sb.toString());
            return;
        }
        //str 表示当前num对应的字符串
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            //c
            backTracking(digits, num + 1);
            //剔除末尾的继续尝试
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
