package main.java.leetcode;

public class XorSubArray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];

        // precompute of xor for all elements in an array
        int[] xorPrecompute = xorForAllElements(arr, arr.length);

        int idx = 0;
        for (int[] query : queries) {
            int xorToDo = query[0] == 0 ? 0 : xorPrecompute[query[0] - 1];
            result[idx++] = xorPrecompute[query[1]] ^ xorToDo;
        }

        return result;
    }

    private int[] xorForAllElements(int[] arr, int arrLen) {
        int[] xorArr = new int[arrLen];
        xorArr[0] = arr[0];
        for (int i = 1; i < arrLen; ++i) {
            xorArr[i] = arr[i] ^ xorArr[i - 1];
        }

        return xorArr;
    }
}
