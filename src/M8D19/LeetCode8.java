package M8D19;

/**
 * atoi函数
 */
public class LeetCode8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
    }
    public static int myAtoi(String s) {
        //首先去除首尾空格
        s=s.trim();
        int num=s.length();
        int res=0;
        boolean negative=false;
        for (int i = 0; i < num; i++) {
            char c=s.charAt(i);
            //判断第一位
            if(i==0) {
                if (c == '-'){
                    negative = true;
                    continue;
                }
                else if (c == '+') {
                    continue;
                }
                else if(c<'0'||c>'9')
                    return 0;
            }
            //第一位以外的遇到字符则跳过
            if(c<'0'||c>'9')
                break;
            int digit=c-'0';
            //进行计算
            if(res>(Integer.MAX_VALUE-digit)/10){
                return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res*=10;
            res+=digit;
        }
        return negative?-res:res;
    }
}
