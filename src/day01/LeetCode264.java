package day01;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LeetCode264 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1407));
    }

    public static int nthUglyNumber(int n) {
        if (n <= 10) {
            return new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10, 12}[n - 1];
        } else {
            long m = 1;
            PriorityQueue<Long> p = new PriorityQueue<>();
            int[] base = new int[]{2, 3, 5};
            Set<Long> set = new HashSet<>();
            set.add(m);
            p.add(m);
            for (int i = 1; i <= n; i++) {
                m = p.poll();
                if (i == n) {
                    return (int) m;
                }
                for (int q : base) {
                    long temp2 = m * q;
                    if (!set.contains(temp2)) {
                        set.add(temp2);
                        p.add(temp2);
                    }
                }

            }
        }
        return -1;
    }
}
