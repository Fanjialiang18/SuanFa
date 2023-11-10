package m8d30;

/**
 * 斐波那契
 * 思路1：
 * 迭代，动态规划
 * 思路2：
 * 递归
 *
 * @author clearlove3
 */
public class Offer10 {
    /**
     * 迭代法
     * int tmp=a,a=a+b,b=tmp
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 1, b = 0;
        for (int i = 1; i < n; i++) {
            a = a + b;
            b = a - b;
            if (a > 1000000007) {
                a -= 1000000007;
            }
        }
        return a;
    }

    /**
     * 递归
     */
    public int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        return (fib2(n - 1) + fib2(n - 2)) % 1000000007;
    }
}
