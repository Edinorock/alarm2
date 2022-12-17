import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.Scanner;

public class Method {

    public static String inputTaskName(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.useDelimiter("\n").next();
        return taskName;
    }

    public static String inputDescription(Scanner scanner) {
        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.useDelimiter("\n").next();
        return taskDescription;
    }

    public static LocalDateTime inputDateTime(Scanner scanner) {
        System.out.print("Введите дату и время задачи в формате дд, мм, гггг чч:мм: ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd, MM, yyyy HH:mm");
        LocalDateTime taskDate = null;
        try {
            taskDate = LocalDateTime.parse(scanner.useDelimiter("\n").next(), formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Неверный формат даты!");
        }
        return taskDate;
    }

    public static Task.TaskType inputTypeOfTask(Scanner scanner) {
        System.out.print("Введите тип задачи, 'Личная/Рабочая': ");
        String chosenTypeOfTask = scanner.next();
        Task.TaskType taskType = null;
        if (chosenTypeOfTask.equals("Личная задача")) {
            taskType = Task.TaskType.PERSONAL;
        } else if (chosenTypeOfTask.equals("Рабочая задача")) {
            taskType = Task.TaskType.WORK;
        }
        return taskType;
    }

    public static void inputSingleTask(Scanner scanner, Schedule schedule) {
        Task task = new SingleTask(
                inputTaskName(scanner),
                inputDescription(scanner),
                inputDateTime(scanner),
                inputTypeOfTask(scanner));
        schedule.addtask(task.getId(), task);
    }
    public static void inputEverydayTask(Scanner scanner, Schedule schedule) {
        Task task = new DailyTask(
                inputTaskName(scanner),
                inputDescription(scanner),
                inputDateTime(scanner),
                inputTypeOfTask(scanner));
        schedule.addtask(task.getId(), task);
    }

    public static void inputEveryWeekTask(Scanner scanner, Schedule schedule) {
        Task task = new WeeklyTask(
                inputTaskName(scanner),
                inputDescription(scanner),
                inputDateTime(scanner),
                inputTypeOfTask(scanner));
        schedule.addtask(task.getId(), task);
    }

    public static void inputEveryMonthTask(Scanner scanner, Schedule schedule) {
        Task task = new MonthlyTask(
                inputTaskName(scanner),
                inputDescription(scanner),
                inputDateTime(scanner),
                inputTypeOfTask(scanner));
        schedule.addtask(task.getId(), task);
    }

    public static void inputEveryYearTask(Scanner scanner, Schedule schedule) {
        Task task = new DailyTask(
                inputTaskName(scanner),
                inputDescription(scanner),
                inputDateTime(scanner),
                inputTypeOfTask(scanner));
        schedule.addtask(task.getId(), task);
    }

    public static void printMenu() {
        System.out.println("1. Добавить задачу");
        System.out.println("2. Удалить задачу");
        System.out.println("3. Получить все задачи на указанный день");
        System.out.println("0. Выход");
    }

    public static void printMenu2() {
        System.out.println("1. Задача разовая");
        System.out.println("2. Задача ежедневная");
        System.out.println("3. Задача еженедельная");
        System.out.println("4. Задача ежемесячная");
        System.out.println("5. Задача ежегодная");
        System.out.println("0. Выход");
    }

    public static void printTasksForDay(LocalDate date, Collection<Task> tasks) {
        System.out.println("Задачи на число: " + date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        for (Task task : tasks) {
            System.out.printf("%s %s Описание %s%n", task.getTitle(),
                    task.getTaskDateTime().toLocalDate(),
                    task.getDescription());
        }
    }
}