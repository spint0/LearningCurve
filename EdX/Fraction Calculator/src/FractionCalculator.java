import java.util.Scanner;

public class FractionCalculator {

    public static void main(String[] args) {

        System.out.println("This program is a fraction calculator.");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in form a/b, where a and b are integers.");
        System.out.println("-------------------------------------------------------------------------------");
        Scanner input = new Scanner(System.in);
        getOperation(input);
        System.out.print("Please enter a fraction (a/b) or integer (a): ");




    }

    public static String getOperation(Scanner input){
        System.out.println("Please enter an operation (+, -, /, *, = or Q to quit):");
        String operation = input.next();

        while (!operation.equals("+") && !operation.equals("*") && !operation.equals("-") && !operation.equals("/")
                && !operation.equalsIgnoreCase("Q")){

            System.out.print("Invalid input (+, -, /, *, = or Q to quit): ");
            operation = input.next();
        }

        return operation;
    }

    public static boolean validFraction(String input){

        if (input.charAt(0) == '-'){
            if (input.indexOf('-',1) == -1){
                input = input.substring(1,input.lastIndexOf(input));
            } else
            {
                return false;
            }

        }


    }

}
