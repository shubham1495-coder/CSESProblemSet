import java.io.*;
import java.util.*;
public class Sliding_Window_DistinctValues {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer,Integer> freq = new HashMap<>(k*2);
        StringBuilder sb = new StringBuilder(n - k + 1);
        for (int i = 0; i < k; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        sb.append(freq.size());
        for (int i = k; i < n; i++) {
            int out = arr[i - k];
            int c = freq.get(out) - 1;
            if (c == 0) freq.remove(out);
            else          freq.put(out, c);
            int in = arr[i];
            freq.put(in, freq.getOrDefault(in, 0) + 1);
            sb.append(' ').append(freq.size());
        }
        System.out.println(sb);
    }
}
