package day01;

import java.util.*;

/**
 * @author 25322
 */
public class LeetCode1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15},9)));
    }
    public static int[] twoSum(int[] nums, int target) {
        //HashMap中存贮和这个值对应的另一个数以及其下标
        int[] result=new int[2];
        Map<Integer,Integer> m=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(m.containsKey(nums[i])){
                result[1]=i;
                result[0]=m.get(nums[i]);
                return result;
            }
            m.put(target-nums[i],i);
        }
        return null;
    }
}
