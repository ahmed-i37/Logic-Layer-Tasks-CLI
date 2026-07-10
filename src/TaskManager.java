import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {

    private ArrayList<Task> tasks;
    private int nextId;

    public TaskManager() {
        this.tasks = new ArrayList<>();
        nextId = 1;
    }

    public void addTask(String title, int urgency, String dueDate) {
        Task newTask = new Task(nextId, title, urgency, dueDate);
        tasks.add(newTask);
        System.out.println("\n=================================");
        System.out.println("New task added with ID : " + nextId);
        System.out.println("=================================");
        nextId++;
    }

    public void listAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Your to-do list is empty!");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i));
        }
    }

    //elba7s bel ID
    public Task searchById(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            Task VariableMo2qt = tasks.get(i);
            if (VariableMo2qt.getId() == id) {
                return VariableMo2qt;
            }
        }
        return null;
    }

    //elba7s bel title
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < tasks.size(); i++) {
            Task VariableMo2qt = tasks.get(i);
            if (VariableMo2qt.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(VariableMo2qt);
                found = true;
            }
        }
        if (!found) {
            System.out.println("msh mawgoud \'not found\' ");
        }

    }

    public void updateTaskDetails(int id, int newUrgency, String newDueDate) {
        Task task = searchById(id);
        if (task != null) {
            task.setUrgency(newUrgency);
            task.setDueDate(newDueDate);
            System.out.println("Task #" + id + " updated successfully!");
        } else {
            System.out.println("Task not found with ID: " + id);
        }
    }

    public void markAsCompleted(int id) {
        Task task = searchById(id);
        if (task != null) {
            task.setCompleted(true);
            System.out.println("Task #" + id + " marked as Completed!");
        } else {
            System.out.println("Task not found with ID: " + id);
        }
    }

    public void sortByUrgency() {
        int n = tasks.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i -1; j++) {
                if (tasks.get(j).getUrgency() > tasks.get(j + 1).getUrgency()) {
                    Task temp = tasks.get(j);
                    tasks.set(j, tasks.get(j + 1));
                    tasks.set(j + 1, temp);
                }
            }
        }
        System.out.println("Tasks sorted by urgency successfully!");
        listAllTasks();

    }

    public void sortByDueDate() {
        int n = tasks.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (tasks.get(j).getDueDate().compareTo(tasks.get(j + 1).getDueDate()) > 0) {

                    Task temp = tasks.get(j);
                    tasks.set(j, tasks.get(j + 1));
                    tasks.set(j + 1, temp);

                }
            }
        }
        System.out.println("Tasks sorted by upcoming due date successfully!");
        listAllTasks();
    }

    public void deleteTaskById(int id) {
        Task task = searchById(id);
        if (task != null) {
            tasks.remove(task);
            System.out.println("Task removed ");
        }
        else {
            System.out.println("Task not found");
        }
    }

    public List<Task> getTasksList() {
        return this.tasks;
    }
}
