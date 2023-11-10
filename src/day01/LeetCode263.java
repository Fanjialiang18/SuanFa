package day01;

public class LeetCode263 {

    public static boolean isUgly(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (true) {
            if (n % 2 == 0) {
                n /= 2;
            }
            if (n % 3 == 0) {
                n /= 3;
            }
            if (n % 5 == 0) {
                n /= 5;
            }
            if (n == 1) {
                return true;
            }
            if (n % 2 != 0 && n % 5 != 0 && n % 3 != 0) {
                return false;
            }
        }
    }

    public static boolean isUgly2(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(5));

    }
}
