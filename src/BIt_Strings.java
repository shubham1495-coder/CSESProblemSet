
import java.util.Scanner;

public class BIt_Strings {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        final int MOD = 1000000007;
        int n = s.nextInt();
        if (n == 1) {
            System.out.println(2);
            return;
        }
        int res = 1;
        while (n >= 1) {
            res = (res * 2) % MOD;
            n--;
        }
        System.out.print(res);
    }
}
