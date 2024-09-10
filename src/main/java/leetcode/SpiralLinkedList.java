package main.java.leetcode;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class SpiralLinkedList {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] spiralMatrix = new int[m][n];

        // fill all cells with -1 initially
        for (int i = 0; i < m; i++) {
            Arrays.fill(spiralMatrix[i], -1);
        }

        int i = 0;
        int j = 0;

        // logic to go in spiral path
        while (i < m && j < n && head != null) {
            for (int k = j; k < n && head != null; ++k) {
                spiralMatrix[i][k] = head.val;
                head = head.next;
            }
            i++;

            for (int k = i; k < m && head != null; ++k) {
                spiralMatrix[k][n - 1] = head.val;
                head = head.next;
            }
            n--;

            int l = n;
            while (--l >= j && head != null) {
                spiralMatrix[m - 1][l] = head.val;
                head = head.next;
            }
            m--;

            l = m;
            while (l-- > i && head != null) {
                spiralMatrix[l][j] = head.val;
                head = head.next;
            }
            j++;
        }

        return spiralMatrix;
    }
}

