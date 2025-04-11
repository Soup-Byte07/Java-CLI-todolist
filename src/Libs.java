import java.util.Scanner;

public abstract class Libs {
    public static final String NOCHANGE = "nochange";
    public static final taskStatus CHECK_OFF_TASK = taskStatus.COMPLETE;
    public static Scanner Input = new Scanner(System.in);
    public static String captureSentence() {
        String sent;
        Scanner sentScan = new Scanner(System.in).useDelimiter("\n");
        sent = sentScan.next();
        return sent;
    }

    public static int returnUserInputNumber(String message) {
        System.out.println(message);
        return Input.nextInt();
    }
}
