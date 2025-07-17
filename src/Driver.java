import factory.TaskFactory;
import model.PersonalTask;
import model.Task;
import model.Type;
import model.WorkTask;

public class Driver {
    public static void main(String[] args) {
        // initialize factory
        TaskFactory factory = new TaskFactory();

        Task personal = factory.createTask(Type.PERSONAL,"Exercise","2025-07-16" ,3,"Health");
        Task work = factory.createTask(Type.WORK,"Review Latest Request", "2025-07-31",2,"Tasks System");

        // get manager instance
        TaskManager  taskManager = TaskManager.getInstance();
        taskManager.addTask(personal);
        taskManager.addTask(work);

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