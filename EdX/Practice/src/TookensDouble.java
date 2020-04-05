import java.sql.SQLOutput;
import java.util.Scanner;
public class TookensDouble {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("How much money you have in your wallet?");
        double money = input.nextDouble();
        System.out.println (money);
    }
}
