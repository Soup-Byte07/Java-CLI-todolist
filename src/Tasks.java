import java.util.ArrayList;
import java.util.List;

public class Tasks {
    public List<Task> tasks = new ArrayList<Task>();
    public String selectTaskMessage = "Please select a task! Should be the index of the task or ID. If you want to go back, please enter -1.";
    public void showTasks() {
        int taskIndex = 0;
        System.out.println("The following tasks:  \n");
        for (Task singleTask : tasks) {
            printTask(taskIndex, singleTask);
            taskIndex++;
        }
    }

    private void deleteTask(int taskIndex) {
        tasks.remove(taskIndex);
        System.out.println("Deleted task: " + taskIndex);
    }

    private void addTask() {
        Task newTask = new Task();
        System.out.println("Please enter task status!\n");
        for (taskStatus status : taskStatus.values()) {
            System.out.println(status.getString() + "," );
        }
        String userInputTaskStatus = Libs.Input.next();
        System.out.println("Enter task name.");
        String userInputTaskName = Libs.captureSentence();
        newTask.changeTask(userInputTaskName, userInputTaskStatus);
        tasks.add(newTask);

    }

    private void editTask(int index) {
        Task selectedTask = tasks.get(index);
        System.out.println("If you don't want to change the name or status. Just enter noch!");
        System.out.println("Please enter task status!");
        for (taskStatus status : taskStatus.values()) {
            System.out.println(status.getString() + "," );
        }
        String userInputTaskStatus = Libs.Input.next("Enter task name.");
        String userInputTaskName = Libs.captureSentence();
        System.out.println(userInputTaskName + " " + userInputTaskStatus);
        selectedTask.changeTask(userInputTaskName, userInputTaskStatus);
    }

    private void showTask(int index) {
        Task selectedTask = tasks.get(index);
        printTask(index, selectedTask);
    }

    private void printTask(int index, Task singleTask) {
        System.out.printf("%d - %s - %s \n", index, singleTask.taskName, singleTask.taskStatus);
    };

    public void presentTaskActions() {
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
                int showSelectedTask = Libs.returnUserInputNumber(selectTaskMessage);
                if(showSelectedTask != -1) showTask(showSelectedTask);
                presentTaskActions();
                break;
            case ADD:
                System.out.println("Adding Task\n");
                addTask();
                presentTaskActions();
                break;
            case EDIT:
                System.out.println("Editing task");
                int editSelectedTask = Libs.returnUserInputNumber(selectTaskMessage);
                if(editSelectedTask != -1) editTask(editSelectedTask);
                presentTaskActions();
                break;
            case DELETE:
                System.out.println("Deleting Task");
                int deleteSelectedTask = Libs.returnUserInputNumber(selectTaskMessage);
                if(deleteSelectedTask != -1) deleteTask(deleteSelectedTask);
                presentTaskActions();
                break;
            case BACK:
                System.out.println("Going back to main menu");
                break;
        }
    }
}