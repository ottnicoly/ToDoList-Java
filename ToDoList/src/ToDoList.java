import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ToDoList {
    private List<String> tasks;
    private List<Boolean> taskStatus;
    private Scanner scanner;


    public ToDoList() {
        tasks = new ArrayList<>();
        taskStatus = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;
        while(running){
            System.out.println("----TO DO LIST----");
            System.out.println("1. add task");
            System.out.println("2. delete task");
            System.out.println("3. view all tasks");
            System.out.println("4. mark as completed");
            System.out.println("5. exit");
            System.out.println("\nEnter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    markascomplete();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void markascomplete() {
        displayTasks();
        System.out.println("\nEnter task number to mark as complete");
        int taskNum = scanner.nextInt();
        scanner.nextLine();
        if(taskNum>0 && taskNum <= tasks.size()){
            taskStatus.set(taskNum - 1, true);
            System.out.println("Task marked as complete");
        }else {
            System.out.println("invalid task number");
        }
    }

    private void addTask() {
        System.out.println("\nEnter task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        taskStatus.add(false);
        System.out.println("Task added successfully");
    }

    private void deleteTask() {
        System.out.println(displayTasks());
        System.out.println("\nEnter task number to delete");
        int taskNum = scanner.nextInt();
        scanner.nextLine();
        if(taskNum>0 && taskNum <= tasks.size()){
            tasks.remove(taskNum-1);
            taskStatus.remove(taskNum - 1);
            System.out.println("Task deleted successfully");
        }else {
            System.out.println("invalid task number");
        }
    }

    private String displayTasks() {
        String tarefa = null;
        String vazia = " ";
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                String status = taskStatus.get(i) ? "[Completed]" : "[Pending]";
                System.out.println((i + 1) + ". " + status + " " + tasks.get(i));
            }
        }
        return vazia;
    }
}