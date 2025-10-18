package simplecalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calcoct18 {

    private final static String OPERATOR_PATTERN = "[-+*/]";

    
    private List<String> tokenizeAndPreprocess(String expression) {
       
        String cleanedExpression = expression.replaceAll("\\s+", "");

        
        Pattern p = Pattern.compile("(\\d+(\\.\\d+)?%?)|([+\\-*/])");
        Matcher m = p.matcher(cleanedExpression);
        List<String> tokens = new ArrayList<>();

       
        while (m.find()) {
            String token = m.group();
            if (token.endsWith("%")) {
               
                String numberPart = token.substring(0, token.length() - 1);
                try {
                    double value = Double.parseDouble(numberPart) / 100.0;
                    tokens.add(String.valueOf(value));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid number format near %: " + token);
                }
            } else {
                tokens.add(token);
            }
        }

        
        List<String> processedTokens = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            
            if (token.equals("-") && (i == 0 || tokens.get(i - 1).matches(OPERATOR_PATTERN))) {
                if (i + 1 < tokens.size()) {
                    
                    processedTokens.add("-" + tokens.get(i + 1));
                    i++; 
                    throw new IllegalArgumentException("Invalid expression: minus sign at end.");
                }
            } else {
                processedTokens.add(token);
            }
        }
        return processedTokens;
    }

    
    public double evaluateExpression(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            return 0.0;
        }

        
        List<String> tokens = tokenizeAndPreprocess(expression);

        if (tokens.isEmpty()) return 0.0;

       
        double result = Double.parseDouble(tokens.get(0));

        
        for (int i = 1; i < tokens.size(); i += 2) {
            String op = tokens.get(i);
            double nextVal;

            try {
                
                nextVal = Double.parseDouble(tokens.get(i + 1));
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                throw new IllegalArgumentException("Invalid expression structure: expected a number after operator.");
            }

            
            switch (op) {
                case "+":
                    result += nextVal;
                    break;
                case "-":
                    result -= nextVal;
                    break;
                case "*":
                    result *= nextVal;
                    break;
                case "/":
                    if (nextVal == 0) {
                        throw new ArithmeticException("Cannot divide by zero.");
                    }
                    result /= nextVal;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + op);
            }
        }

        return result;
    }

   
    public static void main(String[] args) {
        Calcoct18 calc = new Calcoct18();

        
        String[] tests = {
            "10 + 3 * 5 - 20 / 4",    
            "50 / 10 + 2 * 3",        
            "100 - 10 * 5%",          
            "75 + 25 * 2%",           
            "2 + -5 * 3",             
            "100 / 20 * 5 + 2",       
            "10 / 0"                  
        };

        System.out.println("--- Simplified Left-to-Right Calculator ---");
        System.out.println("NOTE: This calculator ignores Order of Operations (MDAS) for simplicity.");

        for (String expr : tests) {
            System.out.printf("Expression: %-30s | Result: ", expr);
            try {
                double result = calc.evaluateExpression(expr);
                String output = String.format("%.4f", result).replaceAll("\\.0+$|(\\.\\d+?)0+$", "$1");
                System.out.println(output);
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}