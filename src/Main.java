import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToDoTask task = new ToDoTask();
        try {
            File file = new File("tasksToDo.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
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
                System.out.println(task);
            }
            scanner.close();


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
    }

    public static String getFormattedDate(Date date) {
        return new SimpleDateFormat("dd-MM-YYYY").format(date);
    }
}
