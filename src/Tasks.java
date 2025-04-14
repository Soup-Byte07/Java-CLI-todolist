import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Tasks {
    public ArrayList<Task> tasks = new ArrayList<>();
    public String selectTaskMessage = "Please select a task! Should be the index of the task or ID. If you want to go back, please enter -1.";
    public File importedFile;
    Tasks(String fileName) {
        try {
            String taskDir = System.getProperty("user.dir")  + "\\" + fileName;
            System.out.println("Task File: "+ taskDir);
            File taskFile = new File(taskDir);
            importedFile = taskFile;
            if (taskFile.exists()) {
                Libs.reader = new BufferedReader(new FileReader(fileName));
                String line = Libs.reader.readLine();

                while (line != null) {
                    System.out.println(line);
                    if (!line.isEmpty()) {
                        String[] words = line.split(" \\$ ");
                        String taskName = words[0];
                        taskStatus taskStat = taskStatus.valueOf(words[1].toUpperCase());
                        Task importedTask = new Task(taskName, taskStat);
                        tasks.add(importedTask);
                    }
                    line = Libs.reader.readLine();
                }
            }
        } catch(FileNotFoundException error) {
            System.out.println("The File does not exist: " + error);
        } catch (IllegalArgumentException eError) {
            System.out.println("Something went wrong when importing the file: " + eError);
        } catch(IOException ioError) {
            System.out.println("Something went wrong with I/O: " + ioError);
        }
    }

    public void showTasks() {
        int taskIndex = 0;
        System.out.println("The following tasks:  \n");
        for (Task singleTask : tasks) {
            singleTask.printTask(taskIndex);
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
                System.out.print(status.getString() + ", " );
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
                System.out.print(status.getString() + ", " );
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
            selectedTask.finishTask();
        } catch (Exception e) {
            System.out.println("Can't finish something that doesn't exist");
        }
    }

    private void showTask(int index) {
        try {
            Task selectedTask = tasks.get(index);
            selectedTask.printTask(index);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("The task does not exist!");
        }
    }


    public void presentTaskActions() {
        for (taskActions action : taskActions.values()) {
            System.out.print(action.getString() + ", " );
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
                    System.out.println("Exiting and Saving tasks.");
                    Libs.saveToImportFile(importedFile, tasks);
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Command: " + userInputTask + " doesn't exist!");
            presentTaskActions();
        }
    }
}