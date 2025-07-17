package strategy;

import model.Task;

import java.util.List;

public interface SortStrategy {
    public List<Task> sort(List<Task> tasks);
}
