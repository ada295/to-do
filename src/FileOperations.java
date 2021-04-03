import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileOperations {
    public static ArrayList<ToDoTask> getToDoTasksFromFile(String pathName) {
        ArrayList<ToDoTask> tasks = new ArrayList<>();
        try {
            File file = new File(pathName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                ToDoTask task = new ToDoTask();
                String line = scanner.nextLine();
                String[] information = line.split(",");

                try {
                    task.setTaskId(Integer.parseInt(information[0]));
                } catch (NumberFormatException e) {
                    System.err.println("ID in the file is not an integer!");
                    e.printStackTrace();
                }
                task.setDescription(information[1]);
                task.setStatus(information[2]);
                String date = information[3];
                try {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                    task.setCreateDate(formatter.parse(date));

                } catch (Exception e) {
                    System.err.println("An error related to date has occurred!");
                    e.printStackTrace();
                }
                tasks.add(task);
            }
            scanner.close();


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
        return tasks;
    }

    public static void writeToDoTasksToFile(String pathName, ArrayList<ToDoTask> tasks) {
        try {
            FileWriter writer = new FileWriter(pathName);
            for (ToDoTask task : tasks) {
                writer.write(task.getTaskId() + "," + task.getDescription() + "," + task.getStatus() + ","
                        + Main.getFormattedDate(task.getCreateDate()) + "\n");
            }
            writer.close();
            System.out.println("Successfully wrote to the file " + pathName);
        } catch (Exception e) {
            System.err.println("The tasks can not be written to the file!");
            e.printStackTrace();
        }
    }
}
