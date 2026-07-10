import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_NAME = "tasks_data.ser";

    public static void saveTasks(List<Task> tasks){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tasks);
            System.out.println("Data saved successfully to " + FILE_NAME);
        }
        catch (IOException e) {
            System.out.println("Error while saving data: " + e.getMessage());
        }

    }

    public static List<Task> loadTasks() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            List<Task> loadedTasks = (List<Task>) ois.readObject();

            System.out.println("Data loaded successfully from " + FILE_NAME);
            return loadedTasks;
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Could not load data, starting with an empty list.");

            return new ArrayList<>();
        }
    }


}