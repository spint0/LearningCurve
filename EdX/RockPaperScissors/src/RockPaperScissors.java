import java.nio.charset.CharsetDecoder;
import java.util.Random;
import java.util.Scanner;
public class RockPaperScissors {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Let's play the game: Rock, Paper, Scissors!");
        System.out.print("Choose a difficulty: Easy, Normal or Hard.");
        String difficulty = input.next();

        if (difficulty.equals("easy")){
            Easy();
        } else if (difficulty.equals("hard")) {
            Hard();
        } else if (difficulty.equals("normal")) {
            Normal();
        } else {
            error();
        }

    }

    public static void Easy() {
        Scanner input = new Scanner(System.in);
        System.out.print("Choose rock, paper or scissors: ");
        String player = input.next();

        if (player.equals("rock")) {
            System.out.println("I choose scissors!");
            System.out.println(" You Win! Congratulations!");

        } else if (player.equals("scissors")) {
            System.out.println("I choose paper!");
            System.out.println(" You Win! Congratulations!");

        } else if (player.equals("paper")) {
            System.out.println("I choose rock!");
            System.out.println(" You Win! Congratulations!");
        } else {
            error();
        }


    }
    public static void Hard() {
        Scanner input = new Scanner(System.in);
        System.out.print("Choose rock, paper or scissors: ");
        String player = input.next();

        if (player.equals("rock")) {
            System.out.println("I choose paper!");
            System.out.println("You Lose! Try Again!");

        } else if (player.equals("scissors")) {
            System.out.println("I choose rock!");
            System.out.println("You Lose! Try Again!");

        } else if (player.equals("paper")) {
            System.out.println("I choose scissors!");
            System.out.println("You Lose! Try Again!");
        } else {
            error();
        }


    }
    public static void Normal(){
        String[] list ={"rock", "paper", "scissors"};
        Random choice = new Random();
        int randomNumber=choice.nextInt(list.length);

        Scanner input = new Scanner(System.in);
        System.out.print("Choose rock, paper or scissors: ");
        String player = input.next();

        // Player chooses Rock vs other options

        if (player.equals("rock") && list[randomNumber].equals("scissors")){
            System.out.println("I choose scissors!");
            System.out.println(" You Win! Congratulations!");
        } else if (player.equals("rock") && list[randomNumber].equals("paper")){
            System.out.println("I choose paper!");
            System.out.println("You Lose! Try Again!");
        } else if (player.equals("rock") && list[randomNumber].equals("rock")){
            System.out.println("I choose rock!");
            System.out.println("It is a tie! Let's play again!");
        }

        // Player chooses Paper vs other options
        if (player.equals("paper") && list[randomNumber].equals("rock")){
            System.out.println("I choose rock!");
            System.out.println(" You Win! Congratulations!");
        } else if (player.equals("paper") && list[randomNumber].equals("scissors")){
            System.out.println("I choose scissors!");
            System.out.println("You Lose! Try Again!");
        } else if (player.equals("paper") && list[randomNumber].equals("paper")){
            System.out.println("I choose paper!");
            System.out.println("It is a tie! Let's play again!");
        }

        // Player chooses Scissors vs other options
        if (player.equals("scissors") && list[randomNumber].equals("paper")){
            System.out.println("I choose paper!");
            System.out.println(" You Win! Congratulations!");
        } else if (player.equals("scissors") && list[randomNumber].equals("rock")){
            System.out.println("I choose rock!");
            System.out.println("You Lose! Try Again!");
        } else if (player.equals("scissors") && list[randomNumber].equals("scissors")){
            System.out.println("I choose scissors!");
            System.out.println("It is a tie! Let's play again!");
        }



    }
    public static void error(){
        System.out.println("Something went wrong, please try again!");
    }
        }
