package com.company;


public class Main {

    public static void main(String[] args) {
        System.out.println(isBalance("{(2+3)<7-3>}"));
    }

    public static boolean isBalance(String exp) {
        var stack = new Stack();
        for (var ch : exp.toCharArray()) {
            if (ch == '(')
                stack.push(ch);
            if (ch == '[')
                stack.push(ch);
            if (ch == '{')
                stack.push(ch);
            if (ch == '<')
                stack.push(ch);

            char c;
            if (ch == ')') {
                if (stack.isEmpty()) return false;
                c = stack.pop();
                if (c != '(') return false;
            }
            if (ch == ']') {
                if (stack.isEmpty()) return false;
                c = stack.pop();
                if (c != '[') return false;

            }
            if (ch == '}') {
                if (stack.isEmpty()) return false;
                c = stack.pop();
                if (c != '{') return false;
            }
            if (ch == '>') {
                if (stack.isEmpty()) return false;
                c = stack.pop();
                if (c != '<') return false;
            }
        }
        return stack.isEmpty();
    }
}
