import Interfaces.Ints;
import Logger.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    protected static final Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Logger logger = new Logger(new ListStorageAdapter(list));
        Ints intsCalc = new IntsCalculator();
        logger.log("Запуск программы \"Калькулятор\"...");
        logger.log("Программы \"Калькулятор\" запущена\n");
//        String inputStr = "";
        while (true) {
//            logger.log("Выберите желаемую операцию:");
            System.out.println("Выберите желаемую операцию:");
            System.out.println(Menu());
            System.out.print(">>");
            int arg0, arg1;
            String[] input;
            String inputStr = SCAN.nextLine().trim();
            switch (inputStr) {
                case "1":
                    logger.log("Операция сумма\n" +
                            "Введите первый и второй операнд через пробел:");
                    input = SCAN.nextLine().trim().split(" ");
                    arg0 = Integer.parseInt(input[0]);
                    arg1 = Integer.parseInt(input[1]);
                    logger.log("Вы ввели " + arg0 + " и " + arg1);
                    logger.log("Результат вычисления суммы: " + intsCalc.sum(arg0, arg1) + "\n");
                    break;
                case "2":
                    logger.log("Операция произведение\n" +
                            "Введите первый и второй операнд через пробел:");
                    input = SCAN.nextLine().trim().split(" ");
                    arg0 = Integer.parseInt(input[0]);
                    arg1 = Integer.parseInt(input[1]);
                    logger.log("Вы ввели " + arg0 + " и " + arg1);
                    logger.log("Результат вычисления произведения: " + intsCalc.mult(arg0, arg1) + "\n");
                    break;
                case "3":
                    logger.log("Операция возведения в степень\n" +
                            "Введите первый и второй операнд через пробел:");
                    input = SCAN.nextLine().trim().split(" ");
                    arg0 = Integer.parseInt(input[0]);
                    arg1 = Integer.parseInt(input[1]);
                    logger.log("Вы ввели " + arg0 + " и " + arg1);
                    logger.log("Результат вычисления возведения в степень: " + intsCalc.pow(arg0, arg1) + "\n");
                    break;
                case "4":
                    System.out.println("История операций:\n");
                    for (String value : list) {
                        System.out.println(value);
                    }
                case "5":
                    break;
                default:
                    logger.log("Вы ввели: " + inputStr + "\nОперации под таким номером не существует или была допущена ошибка ввода операции\n" +
                            "попробуйте еще раз!\n");
            }
            if (inputStr.equals("5")) break;
        }
        logger.log("Программа завершена!");
    }

    private static String Menu() {
        String menu = "1. Сумма\n" +
                "2. Произведение\n" +
                "3. Возведение в степень\n" +
                "4. Показать историю операций\n" +
                "5. Выход";
        return menu;
    }
}
