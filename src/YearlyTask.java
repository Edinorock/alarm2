import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task {

    public YearlyTask(String title, String description, LocalDateTime taskDateTime, TaskType taskType) {
        super(title, description, taskDateTime, taskType);
    }

    @Override
    public boolean appearsIn(LocalDate date) {

        return getTaskDateTime().getYear() <= date.getYear() && getTaskDateTime().getDayOfYear() == date.getDayOfYear() || date.isAfter(getTaskDateTime());
    }

}