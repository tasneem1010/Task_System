package factory;

import model.PersonalTask;
import model.Task;
import model.Type;
import model.WorkTask;

public class TaskFactory {
    // Factory design implementation
    // Encapsulates Task subclasses
    public Task createTask(Enum type,String title, String dueDate, int priority, String extraField){
        if (type.equals(Type.PERSONAL)) {
            return new PersonalTask(title, dueDate, priority, extraField);
        } else if (type.equals(Type.WORK)) {
            return new WorkTask(title, dueDate, priority, extraField);
        }
        return null;
    }
}
