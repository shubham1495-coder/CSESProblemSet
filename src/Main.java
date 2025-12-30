import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner s = new FastScanner();
        StringBuilder sb = new StringBuilder();

        int t = s.nextInt();
        while (t-- > 0) {

            long a = s.nextLong();
            long b = s.nextLong();
            long c = a;
            long d = b;
            int ans = 0;
            int in = 1;
            boolean flag = false;
            while (true) {
                if (!flag) {
                    if (a < in) break;
                    a -= in;
                } else {
                    if (b < in) break;
                    b -= in;
                }
                in *= 2;
                flag = !flag;
                ans++;
            }

            int ans1 = 0;
            int in2 = 1;
            flag = false;
            while (true) {
                if (!flag) {
                    if (d < in2) break;
                    d -= in2;
                } else {
                    if (c < in2) break;
                    c -= in2;
                }
                in2 *= 2;
                flag = !flag;
                ans1++;
            }

            sb.append(Math.max(ans1,ans)).append("\n");
        }

        System.out.print(sb.toString());
    }
}
