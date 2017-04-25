import java.util.*;

public class StackCalc {

    public static Double eval(String input)
    {
        String[] tokens = input.split(" ");
        Stack<String> values = new Stack<>();
        for (String s : tokens) {
            if (isOperator(s)) {
                String second = values.pop();
                String first = values.pop();
                values.push(apply(s, first, second));
            } else {
                values.push(s);
            }
        }
        return Double.parseDouble(values.pop());
    }

    private static boolean isOperator(String s)
    {
        return s.equals("+") ||
            s.equals("-") ||
            s.equals("*") ||
            s.equals("/") ||
            s.equals("%");
    }

    private static String apply(String op, String a, String b)
    {
        Double x = Double.parseDouble(a);
        Double y = Double.parseDouble(b);
        if (op.equals("+")) {
            return String.valueOf(x + y);
        }
        if (op.equals("-")) {
            return String.valueOf(x - y);
        }
        if (op.equals("*")) {
            return String.valueOf(x * y);
        }
        if (op.equals("/")) {
            return String.valueOf(x / y);
        }
        if (op.equals("%")) {
            return String.valueOf(x % y);
        } else {
            return "No valid operator.";
        }
    }

    public static void main(String[] args)
    {
        System.out.println(StackCalc.eval("10 2 +"));//12.0
        System.out.println(StackCalc.eval("10 2 -"));//8.0
        System.out.println(StackCalc.eval("10 2.0 +"));//12.0
        System.out.println(StackCalc.eval("11 3 - 4 + 2.5 *"));//30.0
        System.out.println(StackCalc.eval("8 2 + 99 9 - * 2 + 9 -"));//839.0
        System.out.println(StackCalc.eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
    }
}
