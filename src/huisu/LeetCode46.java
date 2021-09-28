package huisu;

import java.util.ArrayList;
import java.util.List;

/**
 *  全排列
 * @author clearlove3
 */
public class LeetCode46 {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> list=new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used=new boolean[nums.length];
        helper(nums);
        return res;
    }

    private void helper(int[] nums){
        if(list.size()== nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                used[i]=true;
                list.add(nums[i]);
                helper(nums);
                used[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
}
