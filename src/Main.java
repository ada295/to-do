import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ArrayList<ToDoTask> tasks = FileOperations.getToDoTasksFromFile("tasksToDo.txt");

        Menu.showMenu(tasks);

        FileOperations.writeToDoTasksToFile("tasksToDo.txt", tasks);
    }


    public static String getFormattedDate(Date date) {
        return new SimpleDateFormat("dd-MM-YYYY").format(date);
    }


}
