package main.java.codeforces.virtualcontest.div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoblinTreasure {
    public static void main(String[] args) {

        Solution.FastReader fs = new Solution.FastReader();
        int t = fs.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.nextLine();
            sb.append(solve(n, s)).append("\n");
        }
        System.out.println(sb);
    }

    private static long solve(int n, String s) {
        long hyphenCount = 0;
        long underscoreCount = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '-') {
                hyphenCount++;
            } else {
                underscoreCount++;
            }
        }

        if (n < 3 || hyphenCount == 0 || underscoreCount == 0) {
            return 0;
        }

        long rem = hyphenCount % 2;
        long res = hyphenCount / 2;

        long mul = rem == 0 ? res * res : res * (res + 1);

        return mul * underscoreCount;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        long[] readArrayLong(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = Long.parseLong(next());
            return arr;
        }

        int[] readArrayInt(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(next());
            return arr;
        }
    }
}
