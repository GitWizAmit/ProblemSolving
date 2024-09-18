package main.java.leetcode;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        // Convert the int[] to a String[] for custom sorting
        String[] numStrs = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        // Sort the String[] using a custom comparator
        Arrays.sort(numStrs, (a, b) -> (a + b).compareTo(b + a));

        StringBuilder sb = new StringBuilder();
        for (int i = numStrs.length - 1; i >= 0; --i) {
            sb.append(numStrs[i]);
        }

        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
