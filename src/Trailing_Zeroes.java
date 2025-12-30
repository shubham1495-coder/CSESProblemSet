import java.util.Scanner;
import java.util.*;
public class Trailing_Zeroes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        System.out.println(solve(n));
    }

    static long solve(long n){
        if(n==0){
            return 0;
        }
        return n/5 + solve(n/5);
    }
}
