package allclasses.Bezrukih;
public class BezrukihClass {

    public static int add(int a, int b) {
        return a + b;
    }
    public static boolean isEvent(int number) {
        return number % 2 == 0;
    }
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n == 0) return 1;
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}


