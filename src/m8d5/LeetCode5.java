package m8d5;

public class LeetCode5 {
    /**
     * 最长回文子串
     * 思路1：从中间向两旁扩充来判断回文
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length()==0) {
            return null;
        }
        int max=1;
        String res=null;
        for(int i=0;i<s.length();i++){
            //奇数为中心
            String k1=Judge(s,i-1,i+1);
            //偶数为中心
            String k2=Judge(s,i,i+1);
            res=res.length()>k1.length()?res:k1;
            res=res.length()>k2.length()?res:k2;
        }
        return res;
    }

    /**
     *  辅助函数：从长度为 n 的字符串 s 的给定位置左右扩展寻找回文串。
     *  输入的 left 和 right 是扩展的左右起始位置。
     *  返回扩展经过的字符数 k .
     * @param s
     * @param left
     * @param right
     * @return
     */
    String Judge(String s,int left,int right){
        int k=0;
        while (left>=0&&right<s.length()){
            if(s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                k++;
            }else {
                break;
            }
        }
        return s.substring(left,right+1);
    }
}
