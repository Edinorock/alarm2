import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {
    public MonthlyTask(String title, String description, LocalDateTime taskDateTime, TaskType taskType) {
        super(title, description, taskDateTime, taskType);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return getTaskDateTime().getDayOfMonth() == date.getDayOfMonth() || date.isAfter(getTaskDateTime());
    }
}