import java.util.*;

public class Sliding_Window_Min{
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
        Deque<Integer> q = new ArrayDeque<>();
        long result = 0;
        for(int i = 0;i<n;i++){
            while(!q.isEmpty() && arr[q.peekLast()]>=arr[i]){
                q.pollLast();
            }
            q.offerLast(i);
            if(q.peekFirst()<=i-k){
                q.pollFirst();
            }
            if(i>=k-1){
                result ^= arr[q.peekFirst()];
            }
        }

        System.out.println(result);
    }
}
