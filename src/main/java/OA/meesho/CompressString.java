package main.java.OA.meesho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompressString {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int k = Integer.parseInt(br.readLine());
        System.out.println(compress(new StringBuilder(s), k, 1));
    }
    public static String compress(StringBuilder sb, int k, int count) {
        for (int i = 0; i < sb.length(); i++) {
            if (i + 1 < sb.length() && sb.charAt(i) == sb.charAt(i + 1)) {
                count++;
            } else {
                if (count >= k) {
                    sb.delete(i - count + 1, i + 1);
                    return compress(sb, k, 1);
                }
                count = 1;
            }
        }
        return sb.toString();
    }
}
