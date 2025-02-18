import java.util.*;
public class Weird_Algorithm {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextInt();
        while(n>1){
            if(n%2==0){
                System.out.print(n+" ");
                n=n/2;
            }else{
                System.out.print(n+" ");
                n = n*3+1;
            }
        }
        System.out.print(1);
    }
}

