package main.java.OA.meesho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CompressString {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int k = Integer.parseInt(br.readLine());
        // using recursion
        System.out.println(compress(new StringBuilder(s), k, 1));
        // using stack
        System.out.println(compress(s, k));
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
    public static String compress(String sb, int k) {
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (stack.isEmpty() || stack.peek().c != c) {
                stack.push(new Pair(c, 1));
            } else {
                Pair pair = stack.pop();
                pair.count++;
                if (pair.count != k) {
                    stack.push(pair);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            result.append(String.valueOf(pair.c).repeat(Math.max(0, pair.count)));
        }

        return result.reverse().toString();

    }
    static class Pair {
        char c;
        int count;
        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}
