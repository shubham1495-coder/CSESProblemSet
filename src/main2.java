import java.util.*;

public class main2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        StringBuilder res = new StringBuilder();
        while (t-- > 0) {
            int n = s.nextInt();
            int m  = s.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for(int i = 0; i < n; i++){
                a[i] = s.nextInt();
            }
            for(int i = 0; i < m; i++){
                b[i] = s.nextInt();
            }
            int[] prefix = new int[n+1];
            prefix[0] = 0;
            int[] suffix = new int[n+2];
            suffix[n+1] = 0;
            suffix[n] = 0;
            for(int i = 1;i<=n;i++){
                int prev = prefix[i-1];
                if(prev<m && a[i-1]>=b[prev]) {
                    prefix[i] = prefix[i-1] + 1;
                }else prefix[i] = prefix[i-1];
            }
            for(int i = n;i>=1;i--){
                int suff =  suffix[i+1];
                if(suff<m && a[i-1]>=b[m-suff-1]){
                    suffix[i] = suff + 1;
                }else suffix[i] = suff;
            }
            int result = Integer.MAX_VALUE;
            for(int i = 0;i<=n;i++) {
                int k = prefix[i];
                if (k < m) {
                    int j = suffix[i + 1];
                    int l = m-k-1;
                    if (j>=l) result = Math.min(result, b[k]);
                }
            }
            if(prefix[n]>=m||suffix[n]>=m){
                res.append(0).append("\n");
            }else if(result==Integer.MAX_VALUE){
                res.append(-1).append("\n");
            }else{
                res.append(result).append("\n");
            }
        }

        System.out.print(res);
    }

}