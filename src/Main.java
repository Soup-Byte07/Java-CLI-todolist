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
    public static Tasks mainTaskList = new Tasks();
    public static void main(String[] args) {
        System.out.println("Hello, World! \n");
        System.out.println("Don't save code is: " +Libs.NOCHANGE);
        mainTaskList.showTasks();
        mainTaskList.presentTaskActions();
    }
}