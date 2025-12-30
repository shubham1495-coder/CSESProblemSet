import java.util.Scanner;

public class Sliding_Window_Sum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k  = sc.nextInt();
        int x = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        long[] arr = new long[n];
        arr[0] = x;
        for (int i = 1; i < n; i++) {
            arr[i] = (a*arr[i-1] +b)%c;
        }
        int first = 0;
        int last = 0;
        long sum = 0;
        long prev = 0;
        for(last = 0;last<n;last++){
            if(last-first<k){
                sum += arr[last];
                prev = sum;
            }else if(last-first==k){
                sum += arr[last];
                sum -= arr[first];
                first++;
                prev ^= sum;
            }
        }
        System.out.println(prev);
    }
}
