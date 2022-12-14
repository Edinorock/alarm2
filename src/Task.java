import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Task {
    private static int counter;
    private final int id;
    private String title;
    private String description;

    public enum TaskType {
        PERSONAL("Личная задача"),
        WORK("Рабочая задача");

        private String taskTypeTitle;

        TaskType(String taskTypeTitle) {
            this.taskTypeTitle = taskTypeTitle;
        }

        public String getTaskTypeTitle() {
            return taskTypeTitle;
        }

        public void setTaskTypeTitle(String taskTypeTitle) {
            this.taskTypeTitle = taskTypeTitle;
        }

        public String getTaskType() {
            return taskTypeTitle;
        }

    }

    public TaskType taskType;

    private LocalDateTime taskDateTime;

    public Task(String title, String description, LocalDateTime taskDateTime, TaskType taskType) {
        this.id = counter++;
        this.title = title;
        this.description = description;
        this.taskDateTime = taskDateTime;
        this.taskType = taskType;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    public int getId() {
        return id;
    }


    public abstract boolean appearsIn(LocalDate date);

    public LocalDateTime getTaskDateTime() {
        return taskDateTime;
    }

    @Override
    public String toString() {
        return "Ваш id " + id +
                ",название: " + title + '\'' +
                ", описание: '" + description + '\'' +
                ", время: " + taskDateTime +
                '}';
    }
}