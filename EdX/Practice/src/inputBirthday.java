import java.util.Scanner;
public class inputBirthday {
    public static void main (String [] args){
        //Birthday()
        math();
    }

    public static void Birthday(){
        Scanner input = new Scanner (System.in);
        System.out.print("On what day of the month were you born? ");
        int Day = input.nextInt();
        System.out.print("What is the name of the month in which you were born? ");
        String Month = input.next();
        System.out.print("During what year were you born? ");
        int Year = input.nextInt();
        System.out.println("You were born on " + Month + " " + Day + ", " + Year + ". You're mighty old!");
    }

    public static void math (){
       double x = 144;
       double y = 2;

        System.out.println("Result: " +  x % y);


    }
}
