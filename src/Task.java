
enum taskStatus {
    COMPLETE,
    ONGOING,
    NONE;

    public String getString() {
        return this.toString().toLowerCase();
    }
}

public class Task {

    public String taskName;
    public taskStatus taskStat;

    Task(String Name, taskStatus Status) {
        this.taskName = Name;
        this.taskStat = Status;
    }

    public void changeTask(String name, taskStatus status) {
        if(!name.equals(Libs.NOCHANGE)) {
            this.taskName = name;
        }
        if (!status.toString().equals(Libs.NOCHANGE)) {
            this.taskStat = status;
        }
    }
}
