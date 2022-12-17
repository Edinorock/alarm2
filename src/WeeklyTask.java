import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {

    public WeeklyTask(String title, String description, LocalDateTime taskDateTime, TaskType taskType) {
        super(title, description, taskDateTime, taskType);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return getTaskDateTime().getDayOfWeek().equals(date.getDayOfWeek()) || date.isAfter(getTaskDateTime());
    }
}