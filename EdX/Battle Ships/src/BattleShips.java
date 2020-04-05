import java.util.Scanner;

public class BattleShips {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("**** Welcome to Battle Ships Game ****");
        System.out.println();
        System.out.println("Right now, the sea is empty.");
        System.out.println();

        char[][] ocean = new char[10][10];
        battlefield(ocean);

        System.out.println("Who should deploy the ships first?");

        if (WhoGoesFirst().equalsIgnoreCase("P")) {
            ShipPlacementPlayer(ocean);
            ShipPlacementComputer(ocean);
        } else {
            ShipPlacementComputer(ocean);
            ShipPlacementPlayer(ocean);
        }

        String whoStarts = WhoGuessesFirst();
        Battle(ocean,whoStarts);
    }

    public static void battlefield(char[][] ocean) {

        System.out.println("  0123456789");
        for (int row = 0; row < ocean.length; row++) {
            System.out.print(row + "|");
            for (int col = 0; col < ocean[row].length; col++) {
                if (ocean[row][col] == 0 || ocean[row][col] == '2') {
                    System.out.print(" ");
                } else if (ocean[row][col] == '1') {
                    System.out.print('@');
                } else {
                    System.out.print(ocean[row][col]);
                }

            }
            System.out.println("|" + row);
        }
        System.out.println("  0123456789");
    }

    public static void ShipPlacementPlayer(char[][] ocean) {
        System.out.println("The Player is deploying ships: ");
        System.out.println("You are able to deploy 5 ships.");
        int ship = 0;
        while (ship < 5) {

            System.out.print("Enter X coordinate for your ship: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for your ship: ");
            int y = input.nextInt();

            if (x < 0 || x > 9 || y < 0 || y > 9 || ocean[x][y] == '2' || ocean[x][y] == '1') {
                System.out.println("Invalid coordinates, please repeat!");
            } else {

                ocean[x][y] = '1';
                ship++;
                System.out.println("Ship " + (ship) + " deployed.");
                battlefield(ocean);
            }


        }
    }

    public static void ShipPlacementComputer(char[][] ocean) {
        System.out.println("Computer is deploying ships: ");
        int ship = 0;

        while (ship < 5) {
            int randX = (int) (Math.random() * 9);
            int randY = (int) (Math.random() * 9);

            if (randX < 0 || randX > 9 || randY < 0 || randY > 9 || ocean[randX][randY] == '1' || ocean[randX][randY] == '2') {

                randX = (int) (Math.random() * 9);
                randY = (int) (Math.random() * 9);

            } else {

                ocean[randX][randY] = '2';
                ship++;
                System.out.println("Ship " + (ship) + " deployed.");
            }


        }
    }

    public static String WhoGoesFirst() {

        System.out.print("P - Player, C - Computer, R - Random: ");

        char decision = input.next().charAt(0);
        int automatic = 0;

        while (decision != 'P' && decision != 'R' && decision != 'C') {

            System.out.println("Who should deploy the ships first?");
            System.out.print("P - Player, C - Computer, R - Random: ");
            decision = input.next().charAt(0);
        }

        if (decision == 'R') {
            automatic = (int) (Math.random() * 2) + 1;
        }
        if (decision == 'P' || automatic == 1) {
            return "P";
        } else {
            return "C";
        }

    }

    public static String WhoGuessesFirst() {

        System.out.println("Who should guess first?");
        return WhoGoesFirst();


    }

    public static int PlayerTurn(char[][] ocean) {

        System.out.println("YOUR TURN");
        System.out.print("Enter X coordinate: ");
        int x = input.nextInt();
        System.out.print("Enter Y coordinate: ");
        int y = input.nextInt();

        while (x < 0 || x > 9 || y < 0 || y > 9) {
            System.out.println("Invalid coordinates, please repeat!");

            System.out.print("Enter X coordinate: ");
            x = input.nextInt();
            System.out.print("Enter Y coordinate: ");
            y = input.nextInt();

        }
        while (ocean[x][y] == '~' || ocean[x][y] == 'X' || ocean[x][y] == 'O') {
            System.out.println("That place has already been chosen! Please try other coordinates.");
            System.out.print("Enter X coordinate: ");
            x = input.nextInt();
            System.out.print("Enter Y coordinate: ");
            y = input.nextInt();

        }

        if (ocean[x][y] == 0) {
            System.out.println("You missed!");
            ocean[x][y] = '~';
            return 0;
        } else if (ocean[x][y] == 1) {
            System.out.println("Oh no, you sunk your own ship :(");
            ocean[x][y] = 'O';
            return 1;
        } else {
            System.out.println("BOOM! You sunk the computers ship! Nice!");
            ocean[x][y] = 'X';
            return 2;
        }
    }

    public static int ComputerTurn(char[][] ocean) {

        System.out.println("COMPUTER'S TURN");
        int randX = (int) (Math.random() * 9);
        int randY = (int) (Math.random() * 9);

        while (randX < 0 || randX > 9 || randY < 0 || randY > 9 || ocean[randX][randY] == '~' || ocean[randX][randY] == 'X' || ocean[randX][randY] == 'O') {
            randX = (int) (Math.random() * 9);
            randY = (int) (Math.random() * 9);

        }

        if (ocean[randX][randY] == 0) {
            System.out.println("The computer missed.");
            ocean[randX][randY] = '~';
            return 0;
        } else if (ocean[randX][randY] == 1) {
            System.out.println("BOOM! The computer sank your ship :(");
            ocean[randX][randY] = 'O';
            return 1;
        } else {
            System.out.println("Oh no, the computer sunk its own ship :|");
            ocean[randX][randY] = 'X';
            return 2;
        }
    }

    public static void Battle(char[][] ocean, String whoStarts) {

        int playerShips = 5;
        int computerShips = 5;
        int rounds = 0;
        int result = 0;

        if (whoStarts.equalsIgnoreCase("P")) {

            while (playerShips != 0 && computerShips != 0) {

                result = PlayerTurn(ocean);

                if (result == 1) {
                    playerShips--;
                    rounds++;
                } else if (result == 2) {
                    computerShips--;
                    rounds++;
                } else {
                    rounds++;
                }
                battlefield(ocean);

                result = ComputerTurn(ocean);
                if (result == 1) {
                    playerShips--;
                    rounds++;
                } else if (result == 2) {
                    computerShips--;
                    rounds++;
                } else {
                    rounds++;
                }
                battlefield(ocean);
            }
        } else  {
            while (playerShips != 0 && computerShips != 0) {

                result = ComputerTurn(ocean);

                if (result == 1) {
                    playerShips--;
                    rounds++;
                } else if (result == 2) {
                    computerShips--;
                    rounds++;
                } else {
                    rounds++;
                }
                battlefield(ocean);
                result = PlayerTurn(ocean);
                if (result == 1) {
                    playerShips--;
                    rounds++;
                } else if (result == 2) {
                    computerShips--;
                    rounds++;
                } else {
                    rounds++;
                }
            battlefield(ocean);
            }

        }

        if (computerShips == 0){

            System.out.println("Your ships: " + playerShips + " | " + "Computer Ships: " + computerShips);
            System.out.println("The game took " + rounds + " rounds.");
            System.out.println("Hooray! You win the battle :)");
        } else {
            System.out.println("Your ships: " + playerShips + " | " + "Computer Ships: " + computerShips);
            System.out.println("The game took " + rounds + " rounds.");
            System.out.println("You lose the battle. Try again next time!");
        }
    }
}

