package simplecalculator;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter an expression (like 5+3, 10-2%, 6*2, 8/4): ");
        String input = sc.nextLine();
        input = input.replace(" ", "");  

        double num1 = 0;
        double num2 = 0;
        double result = 0;
        char op = ' ';
        
        
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                op = ch;
                String first = input.substring(0, i);
                String second = input.substring(i + 1);

             
                if (second.endsWith("%")) {
                    second = second.replace("%", "");
                    num1 = Double.parseDouble(first);
                    num2 = (num1 * Double.parseDouble(second)) / 100;
                } else {
                    num1 = Double.parseDouble(first);
                    num2 = Double.parseDouble(second);
                }

               
                if (op == '+') {
                    result = num1 + num2;
                } else if (op == '-') {
                    result = num1 - num2;
                } else if (op == '*') {
                    result = num1 * num2;
                } else if (op == '/') {
                    if (num2 != 0)
                        result = num1 / num2;
                    else {
                        System.out.println("Cannot divide by zero.");
                        return;
                    }
                }

                System.out.println("Result: " + result);
                return;
            }
        }

        
        System.out.println("Invalid expression.");
    }
}
