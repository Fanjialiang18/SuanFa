package m8d25;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 * 多看carl的题解
 * 思路：
 *  回溯
 */
public class LeetCode93 {
    List<String> res=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return res;
        }
        backTrack(s,0,1);
        return res;
    }

    /**
     * 回溯算法
     * @param s 原字符串
     * @param start 开始下标
     * @param parts 分割好的部分
     */
    private void backTrack(String s,int start,int parts){
        //分割成了4段后判断是否成立
        if(parts==4){
            if (isVaild(s,start,s.length()-1)){
                res.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(isVaild(s,start,i)){
                s=s.substring(0,i+1)+"."+s.substring(i+1);//加上点号
                parts++;
                backTrack(s,i+2,parts);//插⼊逗点之后下⼀个⼦串的起始位置为i+2
                parts--;//回溯
                s=s.substring(0,i+1)+s.substring(i+2);//删除点号
            }else {
                break;
            }
        }
    }

    /**
     * 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
     */
    private boolean isVaild(String s,int start,int end){
        if(start>end) {
            return false;
        }
        if(s.charAt(start)=='0'&&start!=end)//0开头的不合法
        {
            return false;
        }
        int num=0;
        for (int i = start; i <= end; i++) {
            char c=s.charAt(i);
            if(c>'9'||c<'0') {
                return false;
            }
            num=num*10+c-'0';
            if(num>255) {
                return false;
            }
        }
        return true;
    }
}
