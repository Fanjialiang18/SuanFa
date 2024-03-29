package huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原 IP 地址
 *
 * @author clearlove3
 */
public class LeetCode93 {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return result; // 算是剪枝了
        }
        backTrack(s, 0, 0);
        return result;
    }

    private void backTrack(String s, int startIndex, int pointNum) {
        if (pointNum == 3) {
            // 判断第四段⼦字符串是否合法，如果合法就放进result中
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                //在str的后⾯插⼊⼀个逗点
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum++;
                // 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                backTrack(s, i + 2, pointNum);
                // 回溯
                pointNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else {
                break;
            }
        }
    }

    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
    private Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        // 0开头的数字不合法
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            // 遇到⾮数字字符不合法
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            // 如果⼤于255了不合法
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
