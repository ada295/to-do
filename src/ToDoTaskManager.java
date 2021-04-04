import java.util.*;
import java.util.stream.Collectors;

public class ToDoTaskManager {
    ArrayList<ToDoTask> tasks;
    Scanner scanner;

    public static int randomizeID(List<ToDoTask> tasks) {
        Random random = new Random();
        while (true) {
            int randomizedID = random.nextInt();

            if (randomizedID < 0) {
                randomizedID *= -1;
            }

            int finalRandomizedID = randomizedID;
            Optional<ToDoTask> optionalRandomizedInt = tasks.stream()
                    .filter(task -> task.getTaskId() == finalRandomizedID)
                    .findAny();

            if (optionalRandomizedInt.isEmpty()) {
                return randomizedID;
            }
        }

    }


    public void showAllTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + 1 + ". Description: " + tasks.get(i).getDescription() + "\nStatus: " + tasks.get(i).getStatus() +
                    "\nDate of creation: " + tasks.get(i).getCreateDate() + "\n");
        }
    }

    public void showATasksToDo() {
        showTasksByStatus("to do");

    }

    public void showTasksStarted() {
        showTasksByStatus("started");
    }

    public void showATasksCompleted() {
        showTasksByStatus("completed");
    }

    public void createNewTask() {
        ToDoTask newTask = new ToDoTask();
        newTask.setTaskId(randomizeID(tasks));
        System.out.println("Give description of new task: ");
        newTask.setDescription(scanner.nextLine());
        newTask.setStatus("to do");
        newTask.setCreateDate(new Date());
        tasks.add(newTask);
    }


    private ToDoTask getTaskForEdit() {
        while (true) {
            System.out.println("Choose task which you want to edit: ");
            int numberInRange = getNumberInRange(1, tasks.size());
            return tasks.get(numberInRange - 1);
        }
    }

    private int getOperationOnTaskToEdit() {
        System.out.println("1. Change description");
        System.out.println("2. Change status");

        return getNumberInRange(1, 2);
    }

    public void editTask() {
        showAllTasks();
        ToDoTask taskToEdit = getTaskForEdit();
        while (true) {
            int optionEdit = getOperationOnTaskToEdit();
            if (optionEdit == 1) {
                setNewDescription(taskToEdit);
                break;
            } else if (optionEdit == 2) {
                setNewStatus(taskToEdit);
                break;
            }
        }
    }

    private int getNumberInRange(int min, int max) {
        while (true) {
            System.out.println("Type option number: ");
            String optionForEdit = scanner.nextLine();
            int optionEdit;
            try {
                optionEdit = Integer.parseInt(optionForEdit);
            } catch (NumberFormatException e) {
                System.err.println("Given option is not an integer!");
                continue;
            }

            if (optionEdit < min || optionEdit > max) {
                System.err.printf("Given option is not in range %d-%d!", min, max);
                continue;
            }

            return optionEdit;
        }
    }

    private void setNewStatus(ToDoTask taskToEdit) {
        while (true) {
            System.out.println("Choose status for task: ");
            System.out.println("1. To do\n2. Started\n3. Completed\n");
            int optionStatus = getNumberInRange(1, 3);
            if (optionStatus == 1) {
                taskToEdit.setStatus("to do");
                break;
            } else if (optionStatus == 2) {
                taskToEdit.setStatus("started");
                break;
            } else if (optionStatus == 3) {
                taskToEdit.setStatus("completed");
                break;
            }
        }
    }

    private void setNewDescription(ToDoTask taskToEdit) {
        System.out.println("Write new description: ");
        taskToEdit.setDescription(scanner.nextLine());
    }

    private void showTasksByStatus(String status) {
        List<ToDoTask> toDoTasks = tasks.stream()
                .filter(task -> task.getStatus().equals(status))
                .collect(Collectors.toList());

        if (toDoTasks.isEmpty()) {
            System.out.println("List of tasks " + status + " is empty");
        } else {
            for (int i = 0; i < toDoTasks.size(); i++) {
                System.out.println(i + 1 + ". Description: " + toDoTasks.get(i).getDescription() + "\nDate of creation: " +
                        toDoTasks.get(i).getCreateDate() + "\n");
            }
        }
    }
}

