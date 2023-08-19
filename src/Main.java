import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        try {
            LocalDate exam = LocalDate.of(2022, 4, 18);
            System.out.println("Введите дату в формате 'dd.MM.yyyy': ");
            String yourDate = scanner.next();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = LocalDate.parse(yourDate, format);
            if (date.equals(exam)) {
                System.out.println("Экзамен сегодня");
            } else if (date.isAfter(exam)) {
                long diffAfter = ChronoUnit.DAYS.between(exam, date);
                System.out.println("Экзамен был. Кол-во прошедших дней: " + diffAfter);
            } else {
                long diffBefore = ChronoUnit.DAYS.between(date, exam);
                System.out.println("До экзамена осталось дней: " + diffBefore);
            }
        } catch (Exception e) {
            System.out.println("Неверный формат");
        }


    }
}