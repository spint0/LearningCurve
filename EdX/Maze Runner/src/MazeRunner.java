import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class MazeRunner {

    static Maze myMap = new Maze();

    public static void main(String[] args) {
        intro();
        game();
    }

    public static void intro() {

        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
        myMap.printMap();

    }

    public static String userMove() {
        Scanner input = new Scanner(System.in);
        System.out.print("Where would you like to move? (R, L, U, D): ");
        String direction = input.next();

        while (!direction.equals("R") && !direction.equals("L") && !direction.equals("U") && !direction.equals("D")) {
            System.out.print("Where would you like to direction? (R, L, U, D): ");
            direction = input.next();
        }
        return direction;
    }

    public static void moveCheck(String direction) {

        if (direction.equals("R") && myMap.canIMoveRight()) {
            myMap.moveRight();
            myMap.printMap();
        } else if (direction.equals("L") && myMap.canIMoveLeft()) {
            myMap.moveLeft();
            myMap.printMap();
        } else if (direction.equals("U") && myMap.canIMoveUp()) {
            myMap.moveUp();
            myMap.printMap();
        } else if (direction.equals("D") && myMap.canIMoveDown()) {
            myMap.moveDown();
            myMap.printMap();
        } else {
            System.out.println("Sorry, you've hit a wall.");
        }
    }

    public static void game() {
        int count = 0;
        String dir = "";

        while (!myMap.didIWin() && movesMessage(count) < 100) {
            dir = userMove();

            switch (navigatePit(dir)){
                case 2: count++;
                        break;
                case 1:
                        break;
                case 0: moveCheck(dir);
                        count++;
                        break;
            }
        }
        if (myMap.didIWin()) {
            System.out.println("Congratulations, you made it out alive!");
            System.out.println("You did it in " + count + " moves!");
        } else {
            System.out.println("Sorry, but you didn't escape in time - you Lose!");
        }
    }

    public static int movesMessage(int moves) {

        switch (moves) {
            case 50:
                System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes!");
            break;
            case 75:
                System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
                break;
            case 90:
                System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!");
                break;
            case 100:
                System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
                break;

        }
        return moves;
    }

    public static int navigatePit(String direction){
        Scanner input = new Scanner(System.in);

        if(myMap.isThereAPit(direction)){
            System.out.println("Watch out! There is a pit ahead, would you like to jump it? ");
            String answer = input.next();
            if (answer.equalsIgnoreCase("y")) {
                myMap.jumpOverPit(direction);
                myMap.printMap();
                return 2;
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }
}
