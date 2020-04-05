import java.sql.SQLOutput;
import java.util.*;
public class ProjectOddsEvens {

    public static void main (String[] args){
        //////////////// Part 1
        // Intro
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome! Let's play a game called \"Odds or Evens\".");
        System.out.print("What is your name? ");
        String name = console.next();
        System.out.print(("Hi " + name + ", which do you choose? (O)dds or (E)vens? "));
        String choice =console.next();

        // Limit choice for error control
        while (!choice.equalsIgnoreCase("O") && !choice.equalsIgnoreCase("E")){
            System.out.print("Please choose either \"O\" for Odds or \"E\" for Evens: ");
                    choice = console.next();
        }
        // Clarify who chose what
        if (choice.equalsIgnoreCase("O")){
            System.out.println(name + " has picked Odds! The computer will be Evens.");
        } else  {
            System.out.println(name + " has picked Evens! The computer will be Odds.");
                }
        System.out.println("---------------------------------------------------------");

        //////////////// Part 2
        //Player choosing
        System.out.print("How many fingers do you put out? ");
        int player = console.nextInt();

        //Error handling to limit choices from 0 to 5 only
        while (player<0 || player>5){
            System.out.print("Please choose a number between 0 and 5: ");
            player = console.nextInt();
        }

        //Computer choosing
        Random rand = new Random();
        int computer = rand.nextInt(6);

        System.out.println("The computer plays " + computer + " \"fingers\".");
        System.out.println("---------------------------------------------------------");

        //Determine the results
        int sum=0;
        sum = player + computer;
        boolean oddOrEven = sum % 2 == 0;

        //Show Results
        System.out.println(player +" + "+ computer + " = " + sum);
        if(oddOrEven) {
            System.out.println(sum + " is ....Even!");
            if(choice.equalsIgnoreCase("E")){
                System.out.println("That means " + name + " wins! :)");}
            else {System.out.println("That means the computer wins! Try again!");}
        }else {
            System.out.println(sum + " is ....Odd!");
            if (choice.equalsIgnoreCase("O")) {
                System.out.println("That means " + name + " wins! :)");
            } else {
                System.out.println("That means the computer wins! Try again!");
            }
        }
        System.out.println("---------------------------------------------------------");

    }
}
