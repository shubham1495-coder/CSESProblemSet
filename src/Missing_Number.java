import java.util.*;
public class Missing_Number {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if(n==1) System.out.println(1);
//        int sum = 0;
//        for(int i=0;i<n-1;i++){
//            sum+= s.nextInt();
//
//        }
//        System.out.print((n*(n+1)/2)-sum);


        //using xor operator for large case
        long xor1 = 0;
        for(long i =1;i<=n;i++){
            xor1^=i;
        }
        long xor2 = 0;
        for(long i =0;i<n-1;i++){
            xor2^=s.nextInt();
        }
        System.out.println(xor1^xor2);

    }
}
