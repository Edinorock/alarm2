import java.time.LocalDate;
import java.time.LocalDateTime;

public class SingleTask extends Task {
    public SingleTask(String title, String description, LocalDateTime taskDateTime, TaskType taskType) {
        super(title, description, taskDateTime, taskType);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return getTaskDateTime().equals(date.atStartOfDay()) || date.isAfter(getTaskDateTime());

    }
}