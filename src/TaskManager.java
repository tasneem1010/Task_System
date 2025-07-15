import model.Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private static TaskManager instance;

    public static TaskManager getInstance() {
        if (instance==null){
            instance = new TaskManager();
        }
        return instance;
    }

    private TaskManager() {
        this.tasks = new ArrayList<>();
    }
    public void addTask(Task task){
        tasks.add(task);
    }
    public void completeTask(Task task){
        task.setCompleted(true);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Task> filterTasks(TaskFilter taskFilter){
        return tasks.stream()  // stream of tasks
                .filter(taskFilter::filter) // add task if it matches implemented filter;
                .toList(); // convert from stream to list
    }
    public List<Task> sortedByDueDate(){
        return tasks.stream()
                .sorted(Comparator.comparing(  // sort stream of tasks ascending based on comparator
                        Task::getDueDate // equivalent to task -> task.getDueDate()
                        ))
                .toList();
    }
    public void printTasks(List<Task> tasks){
        tasks.forEach(System.out::println);
    }
}
