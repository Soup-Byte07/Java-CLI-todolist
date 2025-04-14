
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

    public void printTask(int index) {
        System.out.printf("%d - %s - %s \n", index, this.taskName, this.taskStat);
    }

    public void finishTask() {
        this.taskStat = Libs.CHECK_OFF_TASK;
    }
}
