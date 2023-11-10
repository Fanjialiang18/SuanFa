package m8d25;

/**
 * 比较版本号
 * 思路：
 * 遍历即可
 * 不需要忽略前导零，直接计算即可
 */
public class LeetCode165 {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        while (i < version1.length() || j < version2.length()) {
            int a = 0, b = 0;
            while (i < version1.length() && version1.charAt(i) != '.') {
                a = a * 10 + version1.charAt(i++) - '0';
            }
            while (j < version2.length() && version2.charAt(j) != '.') {
                b = b * 10 + version2.charAt(j++) - '0';
            }
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
            i++;
            j++;
        }
        return 0;
    }
}
