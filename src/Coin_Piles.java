import java.util.Scanner;
import java.util.*;
public class Coin_Piles {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        StringBuilder res = new StringBuilder();
        while(t-->0){
            int A  = s.nextInt();
            int B = s.nextInt();
            if((2*A-B)%3!=0||(2*A-B)<0||
                    (2*B-A)%3!=0||(2*B-A)<0){
                res.append("NO\n");
            }
            else{
                res.append("YES\n");
            }
        }
        System.out.println(res.toString());
    }
}
