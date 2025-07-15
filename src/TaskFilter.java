import model.Task;

public interface TaskFilter {

    // returns true if the task fits the implemented filter
    boolean filter(Task task);
}
