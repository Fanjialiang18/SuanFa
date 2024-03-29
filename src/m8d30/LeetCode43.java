package m8d30;

/**
 * 字符串相乘
 * 思路：
 * 逐个相乘然后累加
 * 注意：
 * 第i个数和第j个数的乘积的两位数会坐落在结果的i+j和i+j+1的位置上
 * 结果的长度最多为i+j+2位
 *
 * @author clearlove3
 */
public class LeetCode43 {
    public String multiply(String num1, String num2) {
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        if (n1 < 0 || n2 < 0) {
            return "";
        }
        int[] mul = new int[n1 + n2 + 2];

        for (int i = n1; i >= 0; --i) {
            for (int j = n2; j >= 0; --j) {
                int bitmul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 先加低位判断是否有新的进位
                bitmul += mul[i + j + 1];

                mul[i + j] += bitmul / 10;
                mul[i + j + 1] = bitmul % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // 去掉前导0
        while (i < mul.length - 1 && mul[i] == 0) {
            i++;
        }
        for (; i < mul.length; ++i) {
            sb.append(mul[i]);
        }
        return sb.toString();
    }
}
