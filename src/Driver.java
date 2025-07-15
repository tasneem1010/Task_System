import model.PersonalTask;
import model.Task;
import model.WorkTask;

public class Driver {
    public static void main(String[] args) {
        TaskManager  taskManager = TaskManager.getInstance();
        Task personal = new PersonalTask("Exercise","2025-07-16" ,3,"Health");
        taskManager.addTask(personal);
        taskManager.addTask(new WorkTask("Review Latest Request", "2025-07-31",2,"Tasks System"));

        System.out.println("All Tasks:");
        taskManager.printTasks(taskManager.getTasks());
        System.out.println();


        taskManager.completeTask(personal);
        System.out.println("Tasks Sorted By Due Date:");
        taskManager.printTasks(taskManager.sortedByDueDate());
        System.out.println();


        System.out.println("Tasks Filtered by Completed:");
        taskManager.printTasks(taskManager.filterTasks(Task::isCompleted)); // equivalent to lamda task -> task.isCompleted()

    }
}