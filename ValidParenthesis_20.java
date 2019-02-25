package com.leetcode;

import java.io.IOException;
import java.util.Stack;

public class ValidParenthesis_20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                switch (c) {
                    case ')':
                        if (stack.pop() != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        if (stack.pop() != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (stack.pop() != '{') {
                            return false;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) throws IOException {
        String s = "{}[]()";
        System.out.print(new ValidParenthesis_20().isValid(s));
    }
}