import java.io.*;
import java.util.*;

public class Two_Sets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long sum = (long) n * (n + 1) / 2;

        if (sum % 2 != 0) {
            bw.write("NO\n");
        } else {
            bw.write("YES\n");
            List<Integer> set1 = new ArrayList<>();
            List<Integer> set2 = new ArrayList<>();

            sum /= 2;
            for (int i = n; i > 0; i--) {
                if (sum >= i) {
                    set1.add(i);
                    sum -= i;
                } else {
                    set2.add(i);
                }
            }

            // Use StringBuilder to efficiently store output
            StringBuilder sb = new StringBuilder();
            sb.append(set1.size()).append("\n");
            for (int num : set1) {
                sb.append(num).append(" ");
            }
            sb.append("\n");

            sb.append(set2.size()).append("\n");
            for (int num : set2) {
                sb.append(num).append(" ");
            }
            sb.append("\n");

            // Write all output at once
            bw.write(sb.toString());
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
