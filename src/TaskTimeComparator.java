import java.util.Comparator;

public class TaskTimeComparator implements Comparator<Task> {


    @Override
    public int compare(Task task, Task task2) {
        return task.getTaskDateTime().toLocalDate().
                compareTo(task2.getTaskDateTime().toLocalDate());
    }
}