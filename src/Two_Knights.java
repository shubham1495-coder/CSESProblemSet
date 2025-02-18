//Your task is to count for k=1,2,\ldots,n the number of ways
// two knights can be placed on a k
// times k chessboard so that they do not attack each other.

import java.util.Scanner;
public class Two_Knights {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextInt();
        for(long i = 1;i<=n;i++){
            long total_combinations = ((i*i)*((i*i) -1))/2;
            long attacking_combinations = 4*(i-2)*(i-1);
            System.out.println(total_combinations-attacking_combinations);
        }
    }
}
