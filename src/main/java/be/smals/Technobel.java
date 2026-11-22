package be.smals;

import java.util.*;

public class Technobel {

    public int compute(String operation2) {
        //2+3*8/2 //{[()]} ou {}()[]
        //int total = 0;
        int result = 0;
        String operation = new StringBuilder(operation2).reverse().toString();
        //System.out.println("operation = " + operation2);
        Stack<String> symbols = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        char[] operandsAndOperators2 = operation.toCharArray();
        String[] operandsAndOperators = new String[operandsAndOperators2.length];

        for (int i = 0; i < operandsAndOperators2.length; i++) {
            operandsAndOperators[i] = String.valueOf(operandsAndOperators2[i]);
        }

        for (String c : operandsAndOperators) {
            symbols.push(c);
        }
        while (symbols.size() > 3 || symbols.contains("/") || symbols.contains("*")) {
            //System.out.println("symbols = " + symbols);
            String popped2 = symbols.pop();
            String popped1 = symbols.pop();
            if (popped1.equals("+") || popped1.equals("-")) {
                queue.offer(popped1);
                queue.offer(popped2);
                //System.out.println("coucou");
            } else if (popped1.equals("/") || popped1.equals("*")) {
                String popped3 = symbols.pop();
                //symbols.push(String.valueOf(calculate(popped1, popped2, popped3)));
                symbols.push(String.valueOf(calculate(popped3, popped1, popped2)));
                // System.out.println("size of queue : " + queue.size());
                if (queue.size() == 2) {
                    symbols.push(Objects.requireNonNull(queue.poll()));
                    symbols.push(Objects.requireNonNull(queue.poll()));
                }
            }
        }
        //System.out.println("symbols = " + symbols);
        if (symbols.size() == 3) {
            result = calculate(symbols.pop(), symbols.pop(), symbols.pop());
            symbols.push(String.valueOf(result));
            return result;
        }
        if (symbols.size() == 1) {
            result = Integer.parseInt(symbols.pop());
            return result;
        }
        return result;
    }

    private int calculate(String popped1, String popped2, String popped3) {
        int numericValue1 = Integer.parseInt(popped1);
        int numericValue2 = Integer.parseInt(popped3);
        return switch (popped2) {
            case "/" -> numericValue2 / numericValue1;
            case "*" -> numericValue2 * numericValue1;
            case "+" -> numericValue2 + numericValue1;
            case "-" -> numericValue2 - numericValue1;
            default -> throw new IllegalStateException("Unexpected value: " + popped2);
        };
    }

    public boolean validParentheses(String input) {
        ArrayDeque<Character> symbols = new ArrayDeque<>();
        char[] charArray = input.toCharArray();
        for (char c : charArray) {
            if (c == '{' || c == '(' || c == '[') {
                symbols.push(c);
            } else {
                if (symbols.isEmpty()) return false;
                Character popped = symbols.pop();
                if (!match(popped, c)) return false;
            }
        }
        return symbols.isEmpty();
    }

    private boolean match(char openSymbol, char closeSymbol) {
        return switch (openSymbol) {
            case '(' -> closeSymbol == ')';
            case '{' -> closeSymbol == '}';
            case '[' -> closeSymbol == ']';
            default -> false;
        };
    }

    public static void main(String[] args) {
        String input = "2+3*2/2";//2+12 2+6/2
        String input2 = "8/2/2/2";//2+12
        String input3 = "8+2/2*2";//2+12
        String input4 = "8+2+2";//2+12
        Technobel technobel = new Technobel();
        System.out.println(technobel.compute(input));
        System.out.println(technobel.compute(input2));
        System.out.println(technobel.compute(input3));
        System.out.println(technobel.compute(input4));
    }
}
