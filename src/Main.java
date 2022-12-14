import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                Method.printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            Method.printMenu2();
                            System.out.print("Выберите тип задачи: ");
                            if (scanner.hasNextInt()) {
                                int menu2 = scanner.nextInt();
                                switch (menu2) {
                                    case 1:
                                        Method.inputSingleTask(scanner, schedule);
                                        break;
                                    case 2:
                                        Method.inputEverydayTask(scanner, schedule);
                                        break;
                                    case 3:
                                        Method.inputEveryWeekTask(scanner, schedule);
                                        break;
                                    case 4:
                                        Method.inputEveryMonthTask(scanner, schedule);
                                        break;
                                    case 5:
                                        Method.inputEveryYearTask(scanner, schedule);
                                        break;
                                    case 0:
                                        break label;
                                }
                            } else {
                                scanner.next();
                                System.out.println("Выберите пункт меню из списка!");
                            }
                            break;
                        case 2:
                            System.out.print("Введите номер задачи для удаления: ");
                            int id = Integer.parseInt(scanner.next());
                            try {
                                schedule.removeTask(id);
                            } catch (TaskNotFoundExeption e) {
                                System.out.println("Задачи не найдено!");
                            }
                            break;
                        case 3:
                            System.out.print("Введите дату задачи в формате дд, мм, гггг: ");
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd, MM, yyyy");
                            LocalDate dayForTask = LocalDate.parse(scanner.useDelimiter("\n").next(), formatter);
                            Method.printTasksForDay(dayForTask, schedule.getTaskForDay(dayForTask));
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }
}