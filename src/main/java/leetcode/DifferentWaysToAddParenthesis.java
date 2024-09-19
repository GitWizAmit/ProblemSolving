package main.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParenthesis {
    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); ++i) {
            char ch = expression.charAt(i);
            if (ch == '-' || ch == '+' || ch == '*') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);
                List<Integer> l1 = map.getOrDefault(left, diffWaysToCompute(left));
                List<Integer> l2 = map.getOrDefault(right, diffWaysToCompute(right));

                valAfterEvaluatingExpression(ch, l1, l2, result);
            }
        }

        if (result.size() == 0) {
            result.add(Integer.parseInt(expression));
        }
        map.put(expression, result);
        return result;
    }

    private void valAfterEvaluatingExpression(char ch, List<Integer> l1, List<Integer> l2, List<Integer> result) {
        for (int i1 : l1) {
            for (int i2 : l2) {
                int val = 0;
                switch (ch) {
                    case '-':
                        val = i1 - i2;
                        break;
                    case '+':
                        val = i1 + i2;
                        break;
                    case '*':
                        val = i1 * i2;
                        break;
                }
                result.add(val);
            }
        }
    }
}
