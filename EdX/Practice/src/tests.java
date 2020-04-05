import java.util.Scanner;
import java.util.logging.XMLFormatter;

public class tests {

    public static void main(String[] args) {
        int a = 6;

        System.out.println(writeNums(a));

    }

    public static int writeNums(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("value less than 1");
        } else if (n == 1) {
            return 1;
        } else {
            return n - writeNums(n-1);
        }
    }
}