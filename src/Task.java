
enum taskStatus {
    COMPLETE,
    ONGOING,
    NONE;

    public String getString() {
        return this.toString().toLowerCase();
    }
}

public class Task {

    public static String taskName = "";
    public static String taskStatus = "";
    public Task(String name, String status) {
        taskName = name;
        taskStatus = status;
    }

    public static void changeTask(String name, String status) {
        if(!name.equals(Libs.NOCHANGE)) {
            taskName = name;
        }
        if (!status.equals(Libs.NOCHANGE)) {
            taskStatus = status;
        }
    }
}
