package be.smals;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Training {


    //"48+68-9*9/2"
    public int compute(String input) {

        Deque<String> operatorsAndOperands = createDeque(input);
        String[] numbers = input.split("[+\\-*/]");
        System.out.println("nombres = " + Arrays.toString(numbers));
        //Stack<Integer> operands = new Stack<>();
        Deque<Integer> operands = new ArrayDeque<>();
        //Stack<Character> operators = new Stack<>();
        Deque<Character> operators = new ArrayDeque<>();
        for (int i = numbers.length - 1; i >= 0; i--) {
            operands.push(Integer.parseInt(numbers[i]));
        }
        for (int j = input.length() - 1; j >= 0; j--) {
            char charAtCurrentIndex = input.charAt(j);
            if (charAtCurrentIndex == '+' || charAtCurrentIndex == '/' || charAtCurrentIndex == '-' || charAtCurrentIndex == '*') {
                operators.push(charAtCurrentIndex);
            }
        }
        return calculate(operands, operators);
/*        int index = 0;
        while (!operators.isEmpty()) {
            System.out.println("operator at index = " + index + " is :" + operators.pop());
            index++;
        }*/
/*        int index = 0;
        while (!operands.isEmpty()) {
            System.out.println("operands at index = " + index + " is :" + operands.pop());
            index++;
        }*/
    }

    private int calculate(Deque<Integer> numbers, Deque<Character> operators) {
        int total = 0;
        int temp = 0;
        while (numbers.size() > 1 && !operators.isEmpty()) {
            int number1 = numbers.pop();
            int number2 = numbers.pop();
            char operator = operators.pop();
            temp = calculatePartialResult(number1, number2, operator);
            numbers.push(temp);
        }
        return numbers.pop();
    }

    private int calculatePartialResult(int number1, int number2, char operator) {
        return switch (operator) {
            case '/' -> number1 / number2;
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }

    private Deque<String> createDeque(String text) {
        ArrayDeque<String> operandsAndoperators = new ArrayDeque<>();
        String expression = "\\d+|[+\\-*/]";
        Matcher matcher = Pattern.compile(expression).matcher(text);
        ArrayList<String> strings = new ArrayList<>();
        while (matcher.find()) {
            strings.add(matcher.group());
            //System.out.println("matcher = " + matcher.group() + " " + matcher.start() + " " + matcher.end());
        }
        for (int index = strings.size() - 1; index >= 0; index--) {
            operandsAndoperators.push(strings.get(index));
        }
        return operandsAndoperators;
    }


    public static void main(String[] args) {
        String test = "48+68-9*9/2";
        ArrayDeque<String> numbers = new ArrayDeque<>();
        numbers.push("3");
        numbers.push("2");
        System.out.println("numbers contains 3?  = " + numbers.contains("3"));
        System.out.println("numbers contains 5?  = " + numbers.contains("5"));


        System.out.println("test.length() = " + test.charAt(10));
        String expression2 = "4+6+9+9+2";
        //createDeque(test);
        //String expression2 = "2-5-8";
        Training training = new Training();
        System.out.println("training = " + training.compute(expression2));

        String text = "A horse is a horse, of course of course...";
        String pattern = "horse|course"; // Compilation du motif et création du Matcher
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        // Parcours des occurrences trouvées
        while (matcher.find()) {
            System.out.println("Matched: '" + matcher.group() + "' at position " + matcher.start());
        }
        String expression = "4+6-9*9/2";

        // La regex : n'importe lequel de ces 4 caractères
        Pattern pattern1 = Pattern.compile("[+\\-*/]");
        Matcher matcher2 = pattern1.matcher(expression);

        List<String> operateurs = new ArrayList<>();
        while (matcher2.find()) {
            operateurs.add(matcher2.group());
        }
        System.out.println(operateurs);
        // Résultat : [+, -, *, /]
    }
}
