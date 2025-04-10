import java.util.Scanner;

public class Libs {

    public static Scanner Input = new Scanner(System.in);
    public static String NOCHANGE = "noch";
    public static String captureSentence() {
        String sent = "";
        Scanner sentScan = new Scanner(System.in).useDelimiter("\n");
        sent = sentScan.next();
        return sent;
    }
    public static int returnUserInputNumber(String message) {
        System.out.println(message);
        int inInt = Input.nextInt();
        return inInt;
    }
}
