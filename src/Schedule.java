import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Schedule {
    public Map<Integer, Task> taskMap = new HashMap<>();

    public void addtask(int id, Task task) {
        taskMap.put(task.getId(), task);
    }

    public void removeTask(int id) throws TaskNotFoundExeption {
        if (!taskMap.containsKey(id)) {
            throw new TaskNotFoundExeption();
        }
        taskMap.remove(id);
    }

    public Collection<Task> getTaskForDay(LocalDate localDate) {
        System.out.println(taskMap.toString());
        Set<Task> taskForDay = new TreeSet<>(new TaskTimeComparator());
        for (Task task : taskMap.values()) {
            if (task.appearsIn(localDate)) {
                taskForDay.add(task);
            }
        }

        return taskForDay;
    }
}