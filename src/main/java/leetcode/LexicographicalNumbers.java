package main.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> lexicographicalNumbers = new ArrayList<>();
        for (int i = 1; i <= 9; ++i) {
            generateLexicographicalNumbers(i, n, lexicographicalNumbers);
        }
        return lexicographicalNumbers;
    }
    private void generateLexicographicalNumbers(int currentNum, int num, List<Integer> lexicographicalNumbers) {
        if (currentNum > num) {
            return;
        }

        lexicographicalNumbers.add(currentNum);

        // appending digit and check if that is within range
        for (int digit = 0; digit <= 9; ++digit) {
            int nextNumber = currentNum * 10 + digit;
            if (nextNumber > num) {
                break;
            }
            generateLexicographicalNumbers(nextNumber, num, lexicographicalNumbers);
        }
    }
}
