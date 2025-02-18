import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        if(n==1){
            System.out.println(1);
            return;
        }
        if(n<=3) {
            System.out.println("NO SOLUTION");
            return;
        }
        if(n==4){
            System.out.println(2+" "+4+" "+1+" "+3);
            return;
        }
        StringBuilder res = new StringBuilder();

        for (long i = 1; i <= n; i += 2) {
            res.append(i).append(" ");
        }
        for (long i = 2; i <= n; i += 2) {
            res.append(i).append(" ");
        }
        System.out.println(res.toString().trim());
    }
}