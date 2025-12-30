import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Gray_Code {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<String> res = solve(n);
        for(String code : res){
            System.out.println(code);
        }
    }

    static ArrayList<String> solve(int n){
        if (n == 1) {
            ArrayList<String> base = new ArrayList<>();
            base.add("0");
            base.add("1");
            return base;
        }
        ArrayList<String> Code = solve(n - 1);
        ArrayList<String> revCode = new ArrayList<>(Code);
        Collections.reverse(revCode);
        int prevSize = Code.size();
        int index = 0;
        while (index < prevSize) {
            String Zero = "0" + Code.get(index);
            Code.set(index, "1" + revCode.get(index));
            Code.add(Zero);
            index++;
        }
        return Code;
    }

}
