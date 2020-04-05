import java.util.Scanner;
public class ProjectTripPlanner {

    // Constant variables for conversion

    public static final int DaysToHours = 24;
    public static final int DaysToMinutes = 1440;
    public static final double KmToMilesSquare = 0.386102159;
    public static final double EarthRadius = 6367.44;

    public static void main  (String[] args){
        greeting();
        System.out.print("***********" + "\n\n");
        travelTime();
        System.out.print("***********" + "\n\n");
        timeDifference();
        System.out.print("***********" + "\n\n");
        countryArea();
        System.out.print("***********" + "\n\n");
        distanceDifference();
        System.out.print("***********" + "\n\n");
    }
    public static void greeting(){
        // Data input and output

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
        String city = input.nextLine();
        System.out.println("Great! " + city + " sounds like a great trip");

    }
    public static void travelTime(){
        // Data input

        Scanner input =new Scanner(System.in);
        System.out.print("How many days are you going to spend travelling? ");
        int days = input.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        int money = input.nextInt();
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String currency = input.next();
        System.out.print("How many " + currency +  " are there in 1 USD? ");
        double conversion = input.nextDouble();

        //Data conversion and output

        System.out.println("\nIf you are travelling for " + days + " days that is the same as " + days*DaysToHours + " hours or " + days*DaysToMinutes + " minutes");
        double oldMoneyPerDay = (double)money/days;
        oldMoneyPerDay = (int)(oldMoneyPerDay*100);
        oldMoneyPerDay = oldMoneyPerDay/100.0;
        System.out.println("If you are going to spend $" + money + " USD that means per day you can spend up to $" + oldMoneyPerDay + " USD");
        double NewMoney = (double)money*conversion;
        NewMoney = (int)(NewMoney*100);
        NewMoney = NewMoney/100.0;
        double newMoneyPerDay = NewMoney/days;
        newMoneyPerDay = (int)(newMoneyPerDay*100);
        newMoneyPerDay = newMoneyPerDay/100.0;
        System.out.println("Your total budget in " + currency + " is " + NewMoney + " " + currency + ", which per day is " + newMoneyPerDay + " " + currency);

    }
    public static void timeDifference(){
        // Data input, conversion and output

        Scanner input = new Scanner(System.in);
        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        int TimeZone = input.nextInt();
        int MidnightToDestination = (0 + TimeZone) % 24;
        int NoonToDestination = (12 + TimeZone) % 24;
        System.out.println("That means that when it is midnight at home it will be " + MidnightToDestination + ":00 in your travel destination\nand when it is noon at home it will be " + NoonToDestination + ":00");
    }
    public static void countryArea(){
        // Data input, conversion and output

        Scanner input = new Scanner(System.in);
        System.out.print("What is the square area of your destination country in km2? ");
        int sqAreaDestination = input.nextInt();
        System.out.println("In myles that is " + (int)(sqAreaDestination*KmToMilesSquare*10)/10.0);
    }

    public static void distanceDifference(){
        // Data input

        Scanner input= new Scanner(System.in);
        System.out.print("What is the latitude of your home? ");
        double latitudeH = input.nextDouble();
        System.out.print("What is the latitude of your destination? ");
        double latitudeD = input.nextDouble();
        System.out.print("What is the longitude of your home? ");
        double longitudeH = input.nextDouble();
        System.out.print("What is the longitude of your destination? ");
        double longitudeD = input.nextDouble();

        // Haversine function separated by pieces of formula

       double F1 = +Math.pow(+Math.sin(((+Math.toRadians(latitudeH-latitudeD))/2)), 2.0);
       double F2 = +Math.pow(+Math.sin(((+Math.toRadians(longitudeH-longitudeD))/2)), 2.0);
       double F3 = +Math.sqrt(F1 + +Math.cos(+Math.toRadians(latitudeD))*+Math.cos(+Math.toRadians(latitudeH))*F2);
       double distanceFinal = (int)((2 * EarthRadius * +Math.asin(F3))*100)/100.0;

       //Final Output

        System.out.println("The distance from your home to your final destination is: " + distanceFinal + " Km.");
    }
}
