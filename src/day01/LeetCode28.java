package day01;

public class LeetCode28 {

    public static void main(String[] args) {
        System.out.println(strStr("hello","ll"));
    }

    public static int strStr(String haystack, String needle) {
        if(needle==null||needle.length()==0) {
            return 0;
        }
        int[] next=new int[needle.length()];
        int j=0,k=-1;
        next[0]=-1;
        while(j<needle.length()-1)
        {
            if(k == -1 || needle.charAt(j) == needle.charAt(k))
            {
                j++;k++;
                next[j] = k;
            }
            else {
                k = next[k];
            }
        }
        int i=0;
        j=0;
        while(i<haystack.length()&&j<needle.length())
        {
            if(j==-1 || haystack.charAt(i)==needle.charAt(j))
            {
                i++;
                j++;
            }
            else {
                j=next[j];               //j回退。。。
            }
        }
        if(j>=needle.length()) {
            return (i-needle.length());         //匹配成功，返回子串的位置
        } else {
            return (-1);                  //没找到
        }
    }
}
