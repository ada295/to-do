import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void showMenu(ArrayList<ToDoTask> tasks) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("MENU:");
            System.out.println("1. Show all tasks");
            System.out.println("2. Show tasks to do");
            System.out.println("3. Show tasks started");
            System.out.println("4. Show tasks completed");
            System.out.println("5. Create new task");
            System.out.println("6. Edit task");
            System.out.println("7. Exit");

            System.out.println("Chose an option: ");


            String option = scanner.nextLine();
            int chosenOption;
            try {
                chosenOption = Integer.parseInt(option);
            } catch (Exception e) {
                System.err.println("Given option must be an integer!");
                e.printStackTrace();
                continue;
            }

            ToDoTaskManager toDoTaskManager = new ToDoTaskManager();
            toDoTaskManager.tasks = tasks;
            toDoTaskManager.scanner = scanner;

            if (chosenOption == 1) {
                toDoTaskManager.showAllTasks();
            } else if (chosenOption == 2) {
                toDoTaskManager.showATasksToDo();
            } else if (chosenOption == 3) {
                toDoTaskManager.showTasksStarted();
            } else if (chosenOption == 4) {
                toDoTaskManager.showATasksCompleted();
            } else if (chosenOption == 5) {
                toDoTaskManager.createNewTask();
            } else if (chosenOption == 6) {
                toDoTaskManager.editTask();
            } else if (chosenOption == 7) {
                break;
            } else {
                System.err.println("Given option is not correct!");
            }

        }
    }
}
