package ca.umanitoba.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC22GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, n, n, "");
        return result;
    }

    private void generate(List<String> result, int left, int right, String path) {
        if (left == 0 && right == 0) result.add(path);
        else {
            // 选择加左括号还是加右括号的DFS剪枝条件
            // 1. 只要还有左括号，就加左括号，因为左括号永远合法
            // 2. 只要右括号比左括号多，就加右括号，因为有多余的左括号未匹配

            // n = 2 | path = (
            // DFS 到 path = (()) 后返回到 path = (
            if (left > 0) generate(result, left - 1, right, path + "(");
            // path = ()
            if (right > left) generate(result, left, right - 1, path + ")");
        }
    }
}
