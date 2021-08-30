package m8d27;

/**
 * 最长公共前缀
 * 思路：
 *  纵向遍历，挨个比较，遇到不同的就返回结果即可
 */
public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c=strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if(i>=strs[j].length()) {
                    return sb.toString();
                }
                char s=strs[j].charAt(i);
                if(s==c&&j==strs.length-1) {
                    sb.append(s);
                }
                if(s!=c) {
                    return sb.toString();
                }

            }
        }
        return sb.toString();
    }
}
