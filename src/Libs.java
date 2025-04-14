import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public abstract class Libs {
    public static final String NOCHANGE = "nochange";

    public static BufferedReader reader;
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

    public static void saveToImportFile(File importFile, ArrayList<Task> tasks) {
        try {
            String fileTasks = "";
            for (Task task : tasks) {
                fileTasks += "\n" + task.taskName + " $ " + task.taskStat.getString().toUpperCase();
            }

            FileWriter importedFileWriter = new FileWriter(importFile.getName(), false);
            importedFileWriter.write(fileTasks);
            importedFileWriter.close();
        } catch (Exception e) {
            System.out.println("Error saving file: " + e);
        }
    }
}
