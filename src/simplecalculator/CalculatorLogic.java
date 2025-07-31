
	package simplecalculator;

	public class CalculatorLogic {
	    public void calculate(String input) {
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



