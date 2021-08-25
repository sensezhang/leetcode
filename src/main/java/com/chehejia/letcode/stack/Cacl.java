package com.chehejia.letcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Cacl {
    private int cacl(char[] input) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int tag = 1;
        for (int i = 0; i < input.length; i++) {
            if (Character.isDigit(input[i])) {
                stack.push(tag * (input[i] - '0'));
            } else if (input[i] == '-') {
                tag = -1;
            } else if (input[i] == '*') {
                stack.push(stack.pop() * (input[i + 1] - '0'));
                i++;
            } else if (input[i] == '/') {
                stack.push(stack.pop() * (input[i + 1] - '0'));
                i++;
            } else {
                tag = 1;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Cacl cacl = new Cacl();
        int res = cacl.cacl(new char[]{'1','+','2','*','3'});
        System.out.println(res);
    }
}

