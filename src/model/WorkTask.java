package model;

import java.time.LocalDate;

public class WorkTask extends Task {

    private String projectName;


    public WorkTask(String title, String dueDate, int priority, String projectName) {
        super(title, dueDate, priority);
        this.projectName = projectName;
    }

    @Override
    public Enum getType() {
        return Type.WORK;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
