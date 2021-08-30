package m8d30;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 最大数
 * 思路：
 *  比较s1+s2和s2+s1的大小，重新排序即可
 * @author clearlove3
 */
public class LeetCode179 {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));
    }

    public static String largestNumber(int[] nums) {
        StringBuilder s=new StringBuilder();
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        collect.stream().sorted((o1,o2)->{
            String oo1=o1.toString();
            String oo2=o2.toString();
            return (oo2+oo1).compareTo(oo1+oo2);
        }).forEach(s::append);
        String result=s.toString();
        if(result.charAt(0)=='0') {
            result="0";
        }
        return result;
    }
}
