import jdk.swing.interop.SwingInterOpUtils;
import java.util.Scanner;

public class ProjectCrypto {

    public static void main(String[] args) {
        String crypto ="";
        Scanner input = new Scanner(System.in);
        System.out.print("Please input your text: ");
        String text = input.nextLine();
        System.out.print("Please input your shift: ");
        int key = input.nextInt();
        System.out.println("Please input your code group: ");
        int code = input.nextInt();

        crypto = encryptString(text,key,code);
        System.out.println("The encrypted result is: ");
        System.out.println(crypto);
        System.out.println("The uncrypted result is: ");
        crypto = decryptString(crypto,key);
        System.out.println(crypto);

    }

    public static String normalizeText(String text) {
        // I also assume that numeric values are to be removed.
        String normalized = text.replaceAll("[\\W\\d]", "").toUpperCase();
        return normalized;
    }

    public static String obify(String text){
        String obified = "";
        for (int i=0; i< text.length();i++) {
            if (text.charAt(i) == 'A' || text.charAt(i) == 'E' || text.charAt(i) == 'I' || text.charAt(i) == 'O' || text.charAt(i) == 'U') {
                obified = obified + text.charAt(i) + "OB";
            } else {
                obified = obified + text.charAt(i);
            }
        }
        return obified;
    }

    public static String caesarify(String text, int key) {

        Character ch = null;
        String encrypted = "";

        for (int i = 0; i < text.length(); i++) {
            ch = shiftAlphabet(key).charAt(shiftAlphabet(0).indexOf(text.charAt(i)));
            encrypted = encrypted + ch;
        }
        return encrypted;
    }

    public static String groupify(String text, int groups) {
        String separated = "";
        int end = 0; // This variable is used to understand where is the end of the substring based on the grouping value.

        // This first part of the code will split evenly divided strings.
        if (text.length() % groups == 0) {
            for (int i = 0; i < text.length(); i += groups) {
                end = i + groups;
                separated = separated + text.substring(i, end);
                if (end == text.length()){
                    break;
                } else {
                    separated += " ";
                }

            }
        } else { // This second part of the code is for oddly divided strings where you need to complete the rest with "x".
            for (int i = 0; i < text.length(); i += groups) {
                end = i + groups;

                /* I needed to add this next if statement specially on oddly grouped strings, because there will always be leftovers on the last substring,
                and the variable end can't be greater than the total length of the string (it would generate an error). So when this happens, I force it to
                be equal the length of the string and force the completion of the group with the code ahead.
                */

                if (end > text.length()){
                    end = text.length();
                }
                separated = separated + text.substring(i, end);

                if (end == text.length()) {

                    /* We need to set up a recursion to complete the final substring, the variable n will tell us
                     how many characters are left to be completed. */

                    int n = groups - text.substring(i, end).length();
                    separated = separated + completeGroup(n); // Here we have the recursion
                    break;

                } else {
                    separated += " ";
                }
            }
    }
        return separated;
    }

    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for (; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if (result.length() < 26) {
            for (currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    public static String completeGroup(int n){
        if (n==1){
            return "x";
        } else {
            return "x" + completeGroup(n-1);
        }
    }

    public static String encryptString(String text, int shift, int code){

        String result = normalizeText(text);
        result = obify(result);
        result = caesarify(result,shift);
        result = groupify(result,code);

        return result;

    }

    public static String ungroupify(String text){
        String joined ="";
        if (text.endsWith("x")) {
        joined = text.replaceAll("[ x]","");
        } else  {
            joined = text.replaceAll(" ","");
        }
        return joined;
    }

    public static String decryptString (String text, int shift){

        String result = ungroupify(text);
        String decrypted ="";
        Character ch = null;

        for (int i = 0; i < (result.length()); i++) {
            ch = shiftAlphabet(0).charAt(shiftAlphabet(shift).indexOf(result.charAt(i)));
            decrypted = decrypted + ch;
        }
        decrypted = decrypted.replaceAll("OB","");
        return decrypted;
    }

}
