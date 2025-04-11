import java.util.ArrayList;
import java.util.List;

public class Tasks {
    public List<Task> tasks = new ArrayList<>();
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
        try {
            tasks.remove(taskIndex);
            System.out.println("Deleted task: " + taskIndex);
        } catch (Exception e) {
            System.out.println("Can't delete something that doesn't exist/");
        }
    }

    private void addTask() {
        try {
            System.out.println("Please enter task status!\n");
            for (taskStatus status : taskStatus.values()) {
                System.out.println(status.getString() + "," );
            }
            taskStatus userInputTaskStatus = taskStatus.valueOf(Libs.Input.next().toUpperCase());
            System.out.println("Enter task name.");
            String userInputTaskName = Libs.captureSentence();
            Task newTask = new Task(userInputTaskName, userInputTaskStatus);
            tasks.add(newTask);
        } catch (RuntimeException e) {
            System.out.println("Failed to add new task. Did you enter the task status correctly?");
        }
    }

    private void editTask(int index) {
        try {

            Task selectedTask = tasks.get(index);
            System.out.println("If you don't want to change the name or status. Just enter " + Libs.NOCHANGE);
            System.out.println("Please enter task status!");
            for (taskStatus status : taskStatus.values()) {
                System.out.println(status.getString() + "," );
            }

            taskStatus userInputTaskStatus = taskStatus.valueOf(Libs.Input.next().toUpperCase());

            System.out.println("Please enter task name!");
            String userInputTaskName = Libs.captureSentence();
            if (selectedTask != null) {
                selectedTask.changeTask(userInputTaskName, userInputTaskStatus);
            }
        } catch (Exception e) {
            System.out.println("Failed to edit task");
        }
    }

    private void finishTask(int index) {
        try {
            Task selectedTask = tasks.get(index);
            selectedTask.taskStat = Libs.CHECK_OFF_TASK;
        } catch (Exception e) {
            System.out.println("Can't finish something that doesn't exist");
        }
    }

    private void showTask(int index) {
        try {
            Task selectedTask = tasks.get(index);
            printTask(index, selectedTask);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("The task does not exist!");
        }
    }

    private void printTask(int index, Task singleTask) {
        System.out.printf("%d - %s - %s \n", index, singleTask.taskName, singleTask.taskStat);
    }

    public void presentTaskActions() {
        for (taskActions action : taskActions.values()) {
            System.out.println(action.getString() + "," );
        }
        String userInputTask = Libs.Input.next();
        try {
            taskActions taskAct = taskActions.valueOf(userInputTask.toUpperCase());
            switch (taskAct) {
                case SHOW_ALL:
                    showTasks();
                    presentTaskActions();
                    break;
                case SHOW:
                    int showSelectedTask = Libs.returnUserInputNumber(selectTaskMessage);
                    if (showSelectedTask >= 0) showTask(showSelectedTask);
                    presentTaskActions();
                    break;
                case ADD:
                    System.out.println("Adding Task\n");
                    addTask();
                    presentTaskActions();
                    break;
                case FINISH:
                    System.out.println("Finishing Task\n");
                    int finishSelectedTask = Libs.returnUserInputNumber(selectTaskMessage);
                    if (finishSelectedTask >= 0) finishTask(finishSelectedTask);
                    presentTaskActions();
                    break;
                case EDIT:
                    System.out.println("Editing task");
                    int editSelectedTask = Libs.returnUserInputNumber(selectTaskMessage);
                    if (editSelectedTask >= 0) editTask(editSelectedTask);
                    presentTaskActions();
                    break;
                case DELETE:
                    System.out.println("Deleting Task");
                    int deleteSelectedTask = Libs.returnUserInputNumber(selectTaskMessage);
                    if (deleteSelectedTask >= 0) deleteTask(deleteSelectedTask);
                    presentTaskActions();
                    break;
                case EXIT:
                    System.out.println("Exiting tasks.");
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Command: " + userInputTask + " doesn't exist!");
            presentTaskActions();
        }
    }
}