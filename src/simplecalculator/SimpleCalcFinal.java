package simplecalculator;
import java.util.Scanner;

public class SimpleCalcFinal {

   
    public static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    System.err.println("Error: Division by zero is not allowed.");
                    return Double.NaN; 
                }
                return num1 / num2;
            default:
                System.err.println("Error: Invalid operator.");
                return Double.NaN; 
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            
            System.out.print("Enter first number: ");
            double number1 = scanner.nextDouble();

            System.out.print("Enter an operator (+, -, *, /): ");
            
            char operator = scanner.next().charAt(0);

            System.out.print("Enter second number: ");
            double number2 = scanner.nextDouble();

            
            double result = calculate(number1, number2, operator);

         
            if (!Double.isNaN(result)) {
                System.out.printf("Result: %.2f %c %.2f = %.2f\n", number1, operator, number2, result);
            }

        } catch (java.util.InputMismatchException e) {
            System.err.println("Invalid input. Please enter numbers and a valid operator.");
        } finally {
            scanner.close();
        }
    }
}