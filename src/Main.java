//Your task is to calculate the number of bit strings of length n.
//For example, if n=3, the correct answer is 8, because the possible bit strings are
// 000, 001, 010, 011, 100, 101, 110, and 111.
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        final int MOD = 1000000007;
        int n = s.nextInt();
        if(n==1){
            System.out.println(2);
            return;
        }
        int res = 1;
        while(n>=1){
            res = (res * 2)%MOD;
            n--;
        }
        System.out.print(res);
    }
}