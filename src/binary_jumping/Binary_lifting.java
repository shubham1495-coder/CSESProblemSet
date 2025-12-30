package binary_jumping;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Binary_lifting {
        static class FastScanner {
            private final InputStream in;
            private final byte[] buffer = new byte[1 << 16];
            private int ptr = 0, len = 0;
            FastScanner(InputStream is) { in = is; }
            private int read() throws IOException {
                if (ptr >= len) {
                    len = in.read(buffer);
                    ptr = 0;
                    if (len <= 0) return -1;
                }
                return buffer[ptr++];
            }
            int nextInt() throws IOException {
                int c;
                while ((c = read()) <= 32) if (c == -1) return Integer.MIN_VALUE;
                int sign = 1;
                if (c == '-') { sign = -1; c = read(); }
                int val = 0;
                while (c > 32) {
                    val = val * 10 + (c - '0');
                    c = read();
                }
                return val * sign;
            }
            long nextLong() throws IOException {
                int c;
                while ((c = read()) <= 32) if (c == -1) return Long.MIN_VALUE;
                int sign = 1;
                if (c == '-') { sign = -1; c = read(); }
                long val = 0;
                while (c > 32) {
                    val = val * 10 + (c - '0');
                    c = read();
                }
                return val * sign;
            }
            String next() throws IOException {
                int c;
                while ((c = read()) <= 32) if (c == -1) return null;
                StringBuilder sb = new StringBuilder();
                while (c > 32) {
                    sb.append((char) c);
                    c = read();
                }
                return sb.toString();
            }
    }
    static int[][] precompute_arr;
    static int log;


    public static void main(String[] args) throws Exception {
        Binary_lifting.FastScanner sc = new Binary_lifting.FastScanner(System.in);
        //  int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        //  while (t-- > 0) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            arr[i] = sc.nextInt();
        }
        precompute(arr,n);
        while(k-->0){
            int node = sc.nextInt();
            int level = sc.nextInt();
            int ans = query(node,level);
            sb.append(ans).append("\n");
        }
        //}
        System.out.println(sb.toString());
    }

    public static void precompute(int[] arr, int n){
        log = (int)(Math.log(n)/Math.log(2))+1;
        precompute_arr = new int[n+1][log];
        for(int[] row: precompute_arr){
            Arrays.fill(row,-1);
        }
        for(int i = 2;i<=n;i++){
            precompute_arr[i][0] = arr[i-2];
        }
        for(int i = 1;i<log;i++){
            for(int j = 1;j<=n;j++){
                int parent = precompute_arr[j][i-1];
                if(parent!=-1){
                    precompute_arr[j][i] = precompute_arr[parent][i-1];
                }
            }
        }
    }

    public static int query(int node, int level){
        if(node==-1||level<0){
            return -1;
        }
        for(int i = log-1;i>=0;i--){
            if((level>>i & 1) == 1){
                node = precompute_arr[node][i];
                if(node==-1){
                    return -1;
                }
            }
        }
        return node;
    }
}
