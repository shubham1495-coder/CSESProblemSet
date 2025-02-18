import java.util.*;
public class Repetitions {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
       // You are given a DNA sequence: a string consisting of
        // characters A, C, G, and T. Your task is to
        // find the longest repetition in the sequence.
        // This is a maximum-length substring containing
        // only one type of character.
        String rep = s.nextLine();
        s.close();
        int max_length = 1;
        int count = 1;
        for(int i =1;i<rep.length();i++){
            if(rep.charAt(i)==rep.charAt(i-1)){
                count++;
                max_length = Math.max(max_length,count);
            }else{
                count = 1;
            }

        }
        System.out.println(max_length);
    }
}
