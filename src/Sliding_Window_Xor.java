import java.util.*;

public class Sliding_Window_Xor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        long[] arr = new long[n];
        arr[0] = x;
        for (int i = 1; i < n; i++) {
            arr[i] = (a * arr[i - 1] + b) % c;
        }
        long result = 0;
        for(int i = 0;i<k;i++){
            result ^= arr[i];
        }
        long ans = result;
        for(int i=k;i<n;i++){
            result ^= arr[i];
            result ^= arr[i-k];
            ans  ^= result;
        }
        System.out.println(ans);
    }
}
