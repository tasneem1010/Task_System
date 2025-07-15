package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Task {
    private String title;
    private LocalDate dueDate;
    private int priority;
    private boolean completed;

    private static final String dateFormat = "yyyy-MM-dd";

    public abstract Enum getType();

    public Task() {
    }

    public Task(String title, String dueDate, int priority) {
        this.title = title;
        this.dueDate = parseDate(dueDate);
        this.priority = priority;
        this.completed = false;
    }
    public LocalDate parseDate(String input) {
        return LocalDate.parse(input, DateTimeFormatter.ofPattern(dateFormat));
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - Due: %s - Priority: %d",
                this.getType(), this.getTitle(), this.getDueDate(), this.getPriority());
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return this.dueDate.format(formatter);
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
