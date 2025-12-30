import java.util.Scanner;
import java.util.*;
public class Palindrome_Reorder {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(solve(str));
    }

    static String solve(String S) {
        int n = S.length();
        char[] ans = new char[n];
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[S.charAt(i) - 'A']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                count++;
            }
        }
        if(count>1){
            return "NO SOLUTION";
        }
        int left = 0;
        int right = n-1;
        for(int i = 0;i<26;i++){
            while(freq[i]>1){
                ans[left++] = ans[right--] = (char)('A'+i);
                freq[i]-=2;
            }
        }
        for(int i = 0;i<26;i++){
            if(freq[i]==1){
                ans[n/2]=(char)('A'+i);
                break;
            }
        }
        return new String(ans);
    }
}
