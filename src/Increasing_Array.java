import java.util.*;
public class Increasing_Array {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long[] arr = new long[(int)n];
        for (long i = 0; i < n; i++) {
            arr[(int)i] = s.nextLong();
        }
        long moves = 0;
        for (long i = 1; i < n; i++) {
            if(arr[(int)i]<arr[(int)i-1]){
                moves+=arr[(int)i-1]-arr[(int)i];
                arr[(int)i] = arr[(int)i-1];
            }
        }
        System.out.println(moves);


    }
}
