package main.java.leetcode;

public class MinimumBitFlips {
    public int minBitFlips(int start, int goal) {
        int ans = 0;
        for (int i = 31; i >= 0; --i) {
            int startBit = (start >> i) & 1;
            int goalBit = (goal >> i) & 1;
            ans += startBit != goalBit ? 1 : 0;
        }
        return ans;
    }
}
