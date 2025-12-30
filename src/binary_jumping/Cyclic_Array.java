package binary_jumping;

import java.io.*;
import java.util.*;

public class Cyclic_Array {
    static final int LOG = 20;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        long k = fs.nextLong();

        long[] a = new long[2 * n];
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextLong();
            a[i + n] = a[i];
        }

        int[] next = new int[2 * n];
        long sum = 0;
        int r = 0;

        // Two-pointer greedy
        for (int l = 0; l < 2 * n; l++) {
            while (r < 2 * n && sum + a[r] <= k) {
                sum += a[r++];
            }
            next[l] = r;
            sum -= a[l];
        }

        int[][] up = new int[LOG][2 * n];
        for (int i = 0; i < 2 * n; i++) up[0][i] = next[i];

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < 2 * n; i++) {
                up[j][i] = up[j - 1][up[j - 1][i]];
            }
        }

        int ans = Integer.MAX_VALUE;
        /// cnt is for to count the number of cuts till that ele.
        for (int i = 0; i < n; i++) {
            int cur = i;
            int cnt = 0;
            for (int j = LOG - 1; j >= 0; j--) {
                if (up[j][cur] < i + n) {
                    cur = up[j][cur];
                    cnt += 1 << j;
                }
            }
            ans = Math.min(ans, cnt + 1);
        }

        System.out.println(ans);
    }

    // Fast input
    static class FastScanner {
        byte[] buf = new byte[1 << 16];
        int idx = 0, size = 0;
        InputStream in;
        FastScanner(InputStream in) { this.in = in; }

        int read() throws IOException {
            if (idx >= size) {
                size = in.read(buf);
                idx = 0;
                if (size <= 0) return -1;
            }
            return buf[idx++];
        }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') ;
            boolean neg = false;
            if (c == '-') { neg = true; c = read(); }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }
            return neg ? -val : val;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}
