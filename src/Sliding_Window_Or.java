import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sliding_Window_Or {

        public static void main(String[] args) throws IOException {
            FastReader in = new FastReader();
            int n = in.nextInt(), k = in.nextInt();
            long x = in.nextLong(), a = in.nextLong(), b = in.nextLong(), c = in.nextLong();

            int[] lastPos = new int[31];
            long[] zeroWindows = new long[31];
            Arrays.fill(lastPos, -1);

            long current = x;
            for (int i = 0; i < n; i++) {
                // process set bits of current
                long v = current;
                while (v != 0) {
                    long lsb = v & -v;
                    int bit = Long.numberOfTrailingZeros(lsb);  // which bit is set
                    // gap since last one
                    int gap = i - lastPos[bit] - 1;
                    if (gap >= k) {
                        zeroWindows[bit] += (gap - k + 1);
                    }
                    lastPos[bit] = i;
                    v &= v - 1;  // clear lowest set bit
                }
                if (i + 1 < n) {
                    current = (a * current + b) % c;
                }
            }

            // trailing gap after last occurrence of each bit
            for (int bit = 0; bit < 31; bit++) {
                int gap = n - lastPos[bit] - 1;
                if (gap >= k) {
                    zeroWindows[bit] += (gap - k + 1);
                }
            }

            long totalWindows = Math.max(0, n - k + 1);
            long answer = 0;
            for (int bit = 0; bit < 31; bit++) {
                long onesCount = totalWindows - zeroWindows[bit];
                if ((onesCount & 1) == 1) {
                    answer ^= (1L << bit);
                }
            }

            System.out.println(answer);
        }

        // FastReader for fast I/O
        static class FastReader {
            BufferedReader br;
            StringTokenizer st;
            FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
            String next() throws IOException {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                return st.nextToken();
            }
            int nextInt() throws IOException { return Integer.parseInt(next()); }
            long nextLong() throws IOException { return Long.parseLong(next()); }
            String nextLine() throws IOException { return nextLine(); }
        }
    }

