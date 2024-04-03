import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        try {
            Time time = new Time(12, 30, 45);
            System.out.println("Текущее время: " + time.hour + ":" + time.minute + ":" + time.second);
            time.addedHours(2);
            System.out.println("Время после добавления 2 часов: " + time.hour + ":" + time.minute + ":" + time.second);
            time.addedMinutes(15);
            System.out.println("Время после добавления 15 минут: " + time.hour + ":" + time.minute + ":" + time.second);
            time.addedSeconds(30);
            System.out.println("Время после  добавления 30 секунд: " + time.hour + ":" + time.minute + ":" + time.second);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка!!!: " + e.getMessage());
        }
    }
}
