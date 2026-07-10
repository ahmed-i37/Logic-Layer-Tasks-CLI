import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        List<Task> savedTasks = FileHandler.loadTasks();
        for (int i = 0; i < savedTasks.size(); i++) {
            Task loadedTask = savedTasks.get(i);
            manager.addTask(loadedTask.getTitle(), loadedTask.getUrgency(), loadedTask.getDueDate());
        }
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("====== Welcome to LogicLayer Tasks CLI ======");

        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Add New Task (CREATE)");
            System.out.println("2. List All Tasks (READ)");
            System.out.println("3. Search Task by ID");
            System.out.println("4. Search Tasks by Keyword");
            System.out.println("5. Sort Tasks by Highest Priority");
            System.out.println("6. Sort Tasks by Upcoming Due Date");
            System.out.println("7. Update Task Details (Urgency/Due Date)");
            System.out.println("8. Mark Task as Completed");
            System.out.println("9. Delete Task (DELETE & COMPACTION)");
            System.out.println("10. Exit & Save (PERSISTENCE)");
            System.out.print("Choose an option (1-10): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Urgency Rating (1-5): ");
                    int urgency = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Due Date (e.g., 2026-07-10): ");
                    String dueDate = scanner.nextLine();

                    manager.addTask(title, urgency, dueDate);
                    break;

                case 2:
                    manager.listAllTasks();
                    break;

                case 3:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = scanner.nextInt();
                    Task foundTask = manager.searchById(searchId);
                    if (foundTask != null) {
                        System.out.println("Found: " + foundTask);
                    } else {
                        System.out.println("No task found with ID: " + searchId);
                    }
                    break;

                case 4:
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.nextLine();
                    manager.searchByTitle(keyword);
                    break;

                case 5:
                    manager.sortByUrgency();
                    break;

                case 6:
                    manager.sortByDueDate();
                    break;

                case 7:
                    System.out.print("Enter Task ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter New Urgency (1-5): ");
                    int newUrgency = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Due Date: ");
                    String newDueDate = scanner.nextLine();

                    manager.updateTaskDetails(updateId, newUrgency, newDueDate);
                    break;

                case 8:
                    System.out.print("Enter Task ID to mark as completed: ");
                    int completeId = scanner.nextInt();
                    manager.markAsCompleted(completeId);
                    break;

                case 9:
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteTaskById(deleteId);
                    break;

                case 10:
                    System.out.println("Saving your data...");
                    FileHandler.saveTasks(manager.getTasksList());
                    System.out.println("Goodbye, Have a productive day!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please select a number between 1 and 10.");
            }
        }
        scanner.close();
    }
}