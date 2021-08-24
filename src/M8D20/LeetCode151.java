package M8D20;

/**
 * 翻转字符串里的单词
 * 思路1：
 *  去除多余空格
 *  字符串翻转
 *  单词翻转
 * 思路2：
 *  去除多余空格
 *  利用栈进行倒序
 */
public class LeetCode151 {

    public static void main(String[] args) {
        String s = reverseWords("  hello   lili  ");
    }
    public static String reverseWords(String s) {
        StringBuilder sb = removeSpace(s);
        reverseString(sb,0,sb.length()-1);
        reverseSingleWord(sb);
        return sb.toString();
    }

    /**
     * 去除多余的空格
     */
    private static StringBuilder removeSpace(String s){
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ')
            start++;
        while (s.charAt(end) == ' ')
            end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    /**
     * 字符串翻转
     */
    private static void reverseString(StringBuilder s, int start, int end){
        while (start<end){
            char c=s.charAt(start);
            s.setCharAt(start,s.charAt(end));
            s.setCharAt(end,c);
            start++;
            end--;
        }
    }

    /**
     * 翻转字符串中的每个单词
     */
    private static void reverseSingleWord(StringBuilder s){
        //start标志单词的开始，end标志单词的结尾
        int start=0,end=1;
        while (start<s.length()){
            while (end<s.length()&&s.charAt(end)!=' '){
                end++;
            }
            reverseString(s,start,end-1);
            start=end+1;
            end=start+1;
        }
    }
}
