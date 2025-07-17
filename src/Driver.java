import factory.TaskFactory;
import model.Task;
import model.Type;
import strategy.SortByDueDate;
import strategy.SortByPriority;
import strategy.SortByTitle;

public class Driver {
    public static void main(String[] args) {
        // initialize factory
        TaskFactory factory = new TaskFactory();

        Task task1 = factory.createTask(Type.PERSONAL, "Read Book", "2025-07-17", 1, "Finish 'Atomic Habits'");
        Task task2 = factory.createTask(Type.WORK, "Team Meeting", "2025-07-18", 2, "Weekly sprint planning");
        Task task3 = factory.createTask(Type.PERSONAL, "Grocery Shopping", "2025-07-19", 3, "Buy vegetables and fruits");
        Task task4 = factory.createTask(Type.WORK, "Code Review", "2025-07-20", 2, "Review backend PRs");
        Task task5 = factory.createTask(Type.PERSONAL, "Call Mom", "2025-07-21", 1, "Check in and talk about weekend plans");
        Task task6 = factory.createTask(Type.WORK, "Prepare Report", "2025-07-22", 3, "Monthly analytics report");
        Task task7 = factory.createTask(Type.PERSONAL, "Doctor Appointment", "2025-07-23", 2, "Annual checkup at 10 AM");
        Task task8 = factory.createTask(Type.WORK, "Deploy Update", "2025-07-24", 1, "Deploy version 2.1 to production");
        Task task9 = factory.createTask(Type.PERSONAL,"Exercise","2025-07-16" ,3,"Health");
        Task task10 = factory.createTask(Type.WORK,"Review Latest Request", "2025-07-31",2,"Tasks System");

        // get manager instance
        TaskManager  taskManager = TaskManager.getInstance();
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        taskManager.addTask(task4);
        taskManager.addTask(task5);
        taskManager.addTask(task6);
        taskManager.addTask(task7);
        taskManager.addTask(task8);
        taskManager.addTask(task9);
        taskManager.addTask(task10);

        System.out.println("All Tasks:");
        taskManager.printTasks(taskManager.getTasks());
        System.out.println();

        System.out.println("Tasks Sorted By Due Date:");
        // use strategy to sort tasks
        taskManager.printTasks(taskManager.getTasksSorted(new SortByDueDate()));
        System.out.println();

        System.out.println("Tasks Sorted By Priority:");
        taskManager.printTasks(taskManager.getTasksSorted(new SortByPriority()));
        System.out.println();

        System.out.println("Tasks Sorted By Title:");
        taskManager.printTasks(taskManager.getTasksSorted(new SortByTitle()));
        System.out.println();

        taskManager.completeTask(task2);
        taskManager.completeTask(task4);
        taskManager.completeTask(task1);
        taskManager.completeTask(task9);
        System.out.println("Tasks Filtered by Completed:");
        taskManager.printTasks(taskManager.filterTasks(Task::isCompleted)); // equivalent to lamda task -> task.isCompleted()

    }
}