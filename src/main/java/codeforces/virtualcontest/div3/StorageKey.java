package main.java.codeforces.virtualcontest.div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StorageKey {
    public static void main(String[] args) {

        Solution.FastReader fs = new Solution.FastReader();
        int t = fs.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = fs.nextInt();
            int x = fs.nextInt();
            sb.append(solve(n, x)).append("\n");
        }
        System.out.println(sb);
    }

    private static List<Integer> solve(int n, int x) {
        int currentOr = 0;

        // Step 2: Construct the array
        List<Integer> array = new ArrayList<>();

        int num = 0;
        // Include all numbers from 0 to x
        while (array.size() < n && currentOr < x) {
            array.add(num);
            if (num == x) {
                if ((currentOr | num) != x) {
                    array.remove(array.size() - 1);
                    array.set(array.size() - 1, x);
                    currentOr |= x;
                    break;
                }
            } else if (array.size() == n) {
                if ((currentOr | num) != x) {
                    array.remove(array.size() - 1);
                }
            } else {
                currentOr |= num;
            }
            num++;
        }

        // Step 3: Fill the remaining positions
        int remaining = n - array.size();
        while (remaining > 0) {
            if ((currentOr | num) == x) {
                array.add(num);
                remaining--;
            }
            num++;
        }

        int or = 0;
        for (int a : array) {
            or |= a;
        }
        if (or == x) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        return array;
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
