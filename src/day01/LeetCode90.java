package day01;

import java.util.*;

public class LeetCode90 {
    public static void main(String[] args) {
        subsetsWithDup(new int[]{1, 2, 2});
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        //首先获取各个元素的数目
        for (int num : nums) {
            if (!m.containsKey(num)) {
                m.put(num, 1);
            } else {
                m.replace(num, (m.get(num) + 1));
            }
        }
        List<List<Integer>> l = new ArrayList<>();
        l.add(new ArrayList<Integer>());
        //遍历map
        Set<Map.Entry<Integer, Integer>> entries = m.entrySet();
        for (Map.Entry<Integer, Integer> ent : entries
        ) {
            //复制一份原集合，在该集合的基础上加元素，即按照元素的个数进行子集的计算
            List<List<Integer>> temp = new ArrayList<>(l);
            for (List<Integer> i : temp
            ) {
                List<Integer> temp2 = new ArrayList<>(i);
                for (int k = 0; k < ent.getValue(); k++) {
                    temp2.add(ent.getKey());
                    List<Integer> temp3 = new ArrayList<>(temp2);
                    l.add(temp3);
                }
            }
        }
        return l;
    }
}
