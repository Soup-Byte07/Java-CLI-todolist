
enum taskStatus {
    COMPLETE,
    ONGOING,
    NONE;

    public String getString() {
        return this.toString().toLowerCase();
    }
}

public class Task {

    public String taskName = "";
    public String taskStatus = "";

    public void changeTask(String name, String status) {
        if(!name.equals(Libs.NOCHANGE)) {
            this.taskName = name;
        }
        if (!status.equals(Libs.NOCHANGE)) {
            this.taskStatus = status;
        }
    }
}
