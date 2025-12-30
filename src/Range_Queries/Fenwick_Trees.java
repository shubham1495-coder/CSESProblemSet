package Range_Queries;
import java.util.*;
import java.io.*;

//Fenwick Tree is used in:
//Inversion count
//Range frequency queries
//Coordinate compression problems
//Order statistics
//Offline queries
//Counting smaller elements on left/right
//K-th order statistics
//Dynamic prefix problems

public class Fenwick_Trees {

    static class fenwickTree{
        int n;
        int[] tree;
        fenwickTree(int n){
            this.n = n;
            tree = new int[n+1];
        }


        void add(int i, int val){
            while(i<=n){
                tree[i] += val;
                i += i&-i;
            }
        }

        int sum(int i){
            int sum = 0;
            while(i>0){
                sum += tree[i];
                i -= i&-i;
            }
            return sum;
        }

        int rangeSum(int l,int r){
            return sum(r)-sum(l-1);
        }


    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        int[] arr = new int[n+1];
        fenwickTree ft  = new fenwickTree(n);
        for(int i = 1;i<=n;i++){
            arr[i] = s.nextInt();
            ft.add(i,arr[i]);
        }
        while(q-->0){
            int type = s.nextInt();
            if(type == 1){
                int idx = s.nextInt();
                int val = s.nextInt();
                int diff = val - arr[idx];
                arr[idx] = val;
                ft.add(idx,diff);
            }else{
                int l = s.nextInt();
                int r = s.nextInt();
                System.out.println(ft.rangeSum(l,r));
            }
        }
    }
}
