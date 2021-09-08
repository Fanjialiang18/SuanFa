package zifuchuan;

/**
 * @author clearlove3
 */
public class LeetCode28 {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = -1;
        for(int i = 0; i<haystack.length();i++){
            // j 寻找之前匹配的位置
            while(j>=0 && haystack.charAt(i) != needle.charAt(j+1)){
                j = next[j];
            }
            // 匹配，j和i同时向后移动
            if(haystack.charAt(i)==needle.charAt(j+1)){
                j++;
            }
            // 文本串s里出现了模式串t
            if(j==needle.length()-1){
                return (i-needle.length()+1);
            }
        }

        return -1;
    }

    private void getNext(int[] next, String s){
        int j = -1;
        next[0] = j;
        for (int i = 1; i<s.length(); i++){
            //前后缀不相同则向前回退
            while(j>=0 && s.charAt(i) != s.charAt(j+1)){
                j=next[j];
            }
            //前后缀相同则判断下一位
            if(s.charAt(i)==s.charAt(j+1)){
                j++;
            }
            // 将j（前缀的长度）赋给next[i]
            next[i] = j;
        }
    }
}
