package simplecalculator;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an expression (like 5+3, 10-2%, 6*2, 8/4): ");
        String input = sc.nextLine();
        input = input.replace(" ", "");  

        CalculatorLogic logic = new CalculatorLogic();  
        logic.calculate(input);                         
    }
}
