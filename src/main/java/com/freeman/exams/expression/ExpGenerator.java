package com.freeman.exams.expression;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ExpGenerator {
    public String letterToNumeral(String incomingString){
        char [] stringToCharArray = incomingString.toCharArray();
        for (int i = 0; i < stringToCharArray.length; i++){
            if (Character.isLetter(stringToCharArray[i])) {
                int numeral = rnd(1,9);
                stringToCharArray[i] = Character.forDigit(numeral, 10);
            }
        }
        String charArrayToString = String.valueOf(stringToCharArray);
        return charArrayToString;
    }

    public int rnd(int min, int max){
        max -= min;
        return (int) (Math.random() * ++ max) + min;
    }

    public boolean isDelim(char c) {
        return c == ' ';
    }
    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }
    public int priority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            default:
                return -1;
        }
    }
    public void processOperator(LinkedList<Integer> st, char op) {
        int r = st.removeLast();
        int l = st.removeLast();
        switch (op) {
            case '+':
                st.add(l + r);
                break;
            case '-':
                st.add(l - r);
                break;
            case '*':
                st.add(l * r);
                break;
            case '/':
                st.add(l / r);
                break;
            case '%':
                st.add(l % r);
                break;
        }
    }
    public int eval(String s) {
        LinkedList<Integer> st = new LinkedList<Integer>();
        LinkedList<Character> op = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDelim(c))
                continue;
            if (c == '(')
                op.add('(');
            else if (c == ')') {
                while (op.getLast() != '(')
                    processOperator(st, op.removeLast());
                op.removeLast();
            } else if (isOperator(c)) {
                while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                    processOperator(st, op.removeLast());
                op.add(c);
            } else {
                String operand = "";
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    operand += s.charAt(i++);
                }
                --i;
                st.add(Integer.parseInt(operand));
            }
        }
        while (!op.isEmpty())
            processOperator(st, op.removeLast());
        return st.get(0);
    }

    public Map<String, Integer> generate(String expression, Integer quantity){
        Map<String, Integer> expressions = new HashMap<>();
        for (int i = 0; i < quantity; i++) {
            String exp = letterToNumeral(expression);
            expressions.put(exp, eval(exp));
        }
        return expressions;
    }
}
