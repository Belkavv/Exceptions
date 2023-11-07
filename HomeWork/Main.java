package HomeWork;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] array = new String[0];

        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("""
                        Введите данные, разделенные пробелом.
                        Фамилия Имя Отчество дата рождения номер телефона пол
                        Форматы данных:
                        фамилия, имя, отчество - строки
                        дата рождения - строка формата dd.mm.yyyy
                        номер телефона - целое беззнаковое число без форматирования
                        пол - символ латиницей f или m.""");
                String input = scanner.nextLine();
                CustomParser customParser = new CustomParser(input);

                array = customParser.parse();
                if (array != null) {
                    customParser.WriteToFile(array);
                }
                System.out.println("""
                        Желаете продолжить?
                        1 - Да
                        2 - Нет
                        """);
                String command = scanner.nextLine();
                if ("2".equals(command)) {
                    break;
                }

            } catch (NullPointerException e) {
                System.out.println("Невозможно извлечь информацию.");
            }
        }
    }
}