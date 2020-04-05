import java.util.Scanner;

public class YesNoLoop {

public static void main(String[] args){

    String answer = "";
    Scanner input = new Scanner(System.in);

    System.out.print("Enter yes or no: ");
    answer = input.next();
    while (!answer.equals("yes") && !answer.equals("no")) {
        System.out.println("Enter ONLY yes or no, please: ");
        answer = input.next();
    }
    System.out.println("Thank you!");

    
}

}
