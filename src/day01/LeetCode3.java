package day01;

import java.util.Arrays;

public class LeetCode3 {
    /**
     * 双指针算法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int[] index=new int[128];//用来记录字母出现的位置，用字母的ascii码作为下标
        Arrays.fill(index, -1);//初始化为-1
        int start=0,max=0;//窗口开启的下标和最长子数组长度
        for (int i = 0; i < s.length(); i++) {
            int symbol=s.charAt(i);//获取当前字符
            start= Math.max(start,index[symbol]+1);//取重复的单词的后一位作为start
            max=Math.max(max,i-start+1);//计算长度
            index[symbol]=i;
        }
        return max;
    }
}
