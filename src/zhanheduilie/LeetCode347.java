package zhanheduilie;

import java.util.*;

/**
 * 前 K 个高频元素
 * @author clearlove3
 */
public class LeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>(nums.length);
        //统计频率
        int[] res=new int[k];
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //用一个优先队列维护前k个数据
        // 根据map的value值正序排，相当于一个小顶堆
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer,Integer>> queue=new PriorityQueue<>(((o1, o2) -> o1.getValue()-o2.getValue()));
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if(queue.size()>k){
                queue.poll();
            }
        }
        for(int i=k-1;i>=0;i--){
            res[i]=queue.poll().getKey();
        }
        return res;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>(nums.length);
        //统计频率
        int[] res=new int[k];
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<int[]> values = new ArrayList<int[]>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count});
        }
        int[] ret = new int[k];
        qSort(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }

    /**
     * 优化的快排
     * 每次排序好一半后，只需要再递归一半就可以了，
     * 若k小于前半部分的长度，前半部分就是
     */
    public void qSort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, picked, start);

        int pivot = values.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start) {
            qSort(values, start, index - 1, ret, retIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {
                qSort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }
}
