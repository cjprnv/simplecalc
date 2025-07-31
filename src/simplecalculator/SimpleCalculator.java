package simplecalculator;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an expression (like 5+3, 10-2%, 6*2, 8/4): ");
        String input = sc.nextLine();
        input = input.replace(" ", "");  // ✅ You already have this

        // 🔻 Now ADD these 2 lines below 👇
        CalculatorLogic logic = new CalculatorLogic();  // Create object of the logic class
        logic.calculate(input);                         // Call the calculate method
    }
}
