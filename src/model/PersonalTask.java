package model;

import java.time.LocalDate;

public class PersonalTask extends Task{

    String tag;

    public PersonalTask(String title, String dueDate, int priority,String tag) {
        super(title, dueDate, priority);
        this.tag=tag;
    }

    @Override
    public Enum getType() {
        return Type.PERSONAL;
    }
}
