package Range_Queries;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sparse_Table {
    static int[][] sparse_table;
    static int log;
    static void build(int[] arr){
        int n = arr.length;
        log = 32-Integer.numberOfLeadingZeros(n);
        sparse_table = new int[log][n];
        for(int i = 0;i<n;i++){
            sparse_table[0][i] = arr[i];
        }

        for(int i = 1;i<log;i++){
            for(int j = 0;j+(1<<(i))<=n;j++){
                sparse_table[i][j] = Math.min(sparse_table[i-1][j],sparse_table[i-1][j+(1<<(i-1))]);
            }
        }
    }

    static int query(int l , int r){
        int diff = r-l+1;
        int k = 31-Integer.numberOfLeadingZeros(diff);
        int ans = Math.min(sparse_table[k][l],sparse_table[k][r-(1<<k)+1]);
        return ans;
    }

    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        build(arr);
        while (q-- > 0) {
            int l = s.nextInt()-1;
            int r = s.nextInt()-1;
            System.out.println(query(l,r));
        }
    }
}
