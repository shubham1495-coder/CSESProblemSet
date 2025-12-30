package Range_Queries;

//Given an array of n integers, your task is to process q queries of the form: what is the sum of values in range [a,b]?
//Input
//The first input line has two integers n and q: the number of values and queries.
//The second line has n integers x_1,x_2,\dots,x_n: the array values.
//Finally, there are q lines describing the queries. Each line has two integers a and b: what is the sum of values in range [a,b]?
//Output
//Print the result of each query.
//Constraints
//
//1 \le n,q \le 2 \cdot 10^5
//1 \le x_i \le 10^9
//1 \le a \le b \le n
//
//Example
//Input:
//8 4
//3 2 4 5 1 1 5 3
//2 4
//5 6
//1 8
//3 3
//
//Output:
//11
//2
//24
//4
import java.util.*;
import java.math.*;
import java.io.*;
public class StaticRangeSumQueries {

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
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
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int n = fs.nextInt();
        int q = fs.nextInt();

        long[] pref = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            pref[i] = pref[i - 1] + fs.nextLong();
        }

        while (q-- > 0) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            long ans = pref[b] - pref[a - 1];
            out.append(ans).append('\n');
        }

        System.out.print(out.toString());
    }
}
