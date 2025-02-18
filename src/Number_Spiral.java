import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number_Spiral {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long y = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long result;

            if (y >= x) {
                if (y % 2 == 0) {
                    result = y * y - (x - 1);
                } else {
                    result = (y - 1) * (y - 1) + x;
                }
            } else {
                if (x % 2 == 0) {
                    result = (x - 1) * (x - 1) + y;
                } else {
                    result = x * x - (y - 1);
                }
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
