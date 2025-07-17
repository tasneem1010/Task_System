package strategy;

import model.Task;

import java.util.Comparator;
import java.util.List;

public class SortByDueDate implements SortStrategy{

    @Override
    public List<Task> sort(List<Task> tasks) {
        return tasks
                .stream()
                .sorted(Comparator.comparing(Task::getDueDate))
                .toList();
    }
}
