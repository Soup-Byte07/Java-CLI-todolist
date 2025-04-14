enum taskActions {
    SHOW_ALL,
    SHOW,
    EDIT,
    ADD,
    FINISH,
    DELETE,
    EXIT;
    public String getString() {
        return this.toString().toLowerCase();
    }
}

public class Main {
    public static Tasks mainTaskList;
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println("Don't save code is: " +Libs.NOCHANGE);

        mainTaskList = new Tasks("tasks_0.txt");

        mainTaskList.showTasks();
        mainTaskList.presentTaskActions();
    }
}