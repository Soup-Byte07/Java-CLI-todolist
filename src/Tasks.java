import java.util.ArrayList;
import java.util.List;

public class Tasks {
    public static List<Task> tasks = new ArrayList<Task>();
    public static void showTasks() {
        int taskIndex = 0;
        System.out.println("The following tasks:  \n");
        for (Task singleTask : tasks) {
            printTask(taskIndex, singleTask);
            taskIndex++;
        }
    }

    private static void addTask(String name, String status) {
        Task newTask = new Task(name, status);
        tasks.add(newTask);
    }

    private static void editTask(int index) {
        Task selectedTask = tasks.get(index);
        System.out.println("If you don't want to change the name or status. Just enter noch!");
        System.out.println("Please enter task status!");
        for (taskStatus status : taskStatus.values()) {
            System.out.println(status.getString() + "," );
        }
        String userInputTaskStatus = Libs.Input.next();
        System.out.println("Enter task name.");
        String userInputTaskName = Libs.captureSentence();
        System.out.println(userInputTaskName + " " + userInputTaskStatus);
        selectedTask.changeTask(userInputTaskName, userInputTaskStatus);
    }

    private static void showTask(int index) {
        Task selectedTask = tasks.get(index);
        printTask(index, selectedTask);
    }

    private static void printTask(int index, Task singleTask) {
        System.out.printf("%d - %s - %s \n", index, singleTask.taskName, singleTask.taskStatus);
    };

    public static void presentTaskActions() {
        System.out.println("Please enter one of the following task actions!");
        for (taskActions action : taskActions.values()) {
            System.out.println(action.getString() + "," );
        }
        String userInputTask = Libs.Input.next();
        taskActions taskAct = taskActions.valueOf(userInputTask.toUpperCase());

        switch (taskAct) {
            case SHOWALL:
                showTasks();
                presentTaskActions();
                break;
            case SHOW:
                int selectedTask = Libs.returnUserInputNumber("Please select a task! Should be the index of the task or ID. If you want to go back, please enter -1.");
                if(selectedTask != -1) showTask(selectedTask);
                presentTaskActions();
                break;
            case ADD:
                System.out.println("Adding Task\n");
                System.out.println("Please enter task status!\n");
                for (taskStatus status : taskStatus.values()) {
                    System.out.println(status.getString() + "," );
                }
                String userInputTaskStatus = Libs.Input.next();
                System.out.println("Enter task name.");
                String userInputTaskName = Libs.captureSentence();
                addTask(userInputTaskName, userInputTaskStatus.toUpperCase());
                presentTaskActions();
                break;
            case EDIT:
                System.out.println("Editing task");
                int selectedTaskEdit = Libs.returnUserInputNumber("Please select a task! Should be the index of the task or ID. If you want to go back, please enter -1.");
                if(selectedTaskEdit != -1) editTask(selectedTaskEdit);
                presentTaskActions();
                break;
            case DELETE:
                System.out.println("Deleting Task");
                break;
            case BACK:
                System.out.println("Going back to main menu");
                break;
        }
    }
}