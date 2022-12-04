// ДЗ 3*. В калькулятор добавьте возможность отменить последнюю операцию.

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SolutionHW_4_3 {
    public static void main(String[] args) throws IOException {

        //      создаётся переменная типа Logger
        Logger logger = Logger.getLogger(SolutionHW_4_3.class.getName());
//      Обработчик FileHandler: записать сообщение журнала в файл.
//      если второй аргумент true, то файл дозаписывается, если false, то каждый раз записывается новый
        FileHandler fh = new FileHandler("log_calc.txt", false);
//      добавление обработчика для переменной logger
        logger.addHandler(fh);
//      определение формата вывода
        SimpleFormatter sFormat = new SimpleFormatter();
//      установление формата вывода для обработчика
        fh.setFormatter(sFormat);
//      Сообщение для логера
        String logMessage;
//        стек операций
        Stack<String> operationStack = new Stack<>();

        Scanner iScanner = new Scanner(System.in);

        while (true) {
            System.out.printf("Что вы хотите (Enter - завершение программы, 1 - калькулятор, 2 - показать последние вычисления, 3 - отменить последнюю операцию): ");
            String str = iScanner.nextLine();
            if (str.equals("")) {
                //        сканер надо закрывать
                iScanner.close();
                logMessage = "Работа программы завершена";
                logger.info(logMessage);
                break;
            } else if (str.equals("2")) {
                if (operationStack.empty()) {
                    logMessage = "Показать последние вычисления невозможно, т.к. не было ни одной операции!";
                    System.out.println(logMessage);
                    logger.info(logMessage);
                } else {
                    for (int i = 0; i < operationStack.size(); i++) {
                        System.out.printf("Операция %d: %s\n", i + 1, operationStack.get(i));
                    }
                    logMessage = "Последние вычисления показаны";
                    logger.info(logMessage);
                }
            } else if (str.equals("3")) {
                if (operationStack.empty()) {
                    logMessage = "Отменить последнюю операцию невозможно, т.к. не было ни одной операции!";
                    System.out.println(logMessage);
                    logger.info(logMessage);
                } else {
                    logMessage = String.format("Последняя операция %s отменена.\n", operationStack.pop());
                    System.out.println(logMessage);
                    logger.info(logMessage);
                }
            } else if (str.equals("1")) {
//        повторяем пока оба числа не будут корректно введены :
                int n1;
                int n2;
                while (true) {
                    try {
                        System.out.printf("Введите первое число: ");
//        считываем строку из консоли
                        String nString1 = iScanner.nextLine();
                        n1 = Integer.parseInt(nString1);
                        System.out.printf("Введите второе число: ");
//        считываем строку из консоли
                        String nString2 = iScanner.nextLine();
                        n2 = Integer.parseInt(nString2);
//                если ввод прошёл без исключений, то выходим из цикла
                        break;
                    } catch (NumberFormatException ex) {
                        // логирование исключения с уровнем WARNING.
                        logMessage = "Не корректный ввод: " + ex.getMessage();
                        System.out.println(logMessage);
                        logger.log(Level.WARNING, logMessage);
                    }
                }
                System.out.printf("Введите действие (+, -, /, *, ^: ): ");
//        считываем строку из консоли
                String operation = iScanner.nextLine();

                double result = 0;
                boolean correctInput = true;

                switch (operation) {
                    case "+" -> result = n1 + n2;
                    case "-" -> result = n1 - n2;
                    case "/" ->
//                преобразуем в double для того, чтобы результат представлял число с плавающей точкой
//                иначе если в операции деления участвуют два целых числа, то результат деления будет округляться до целого числа,
//                даже если результат присваивается переменной float или double
                            result = (double) n1 / (double) n2;
                    case "*" -> result = n1 * n2;
                    case "^" -> result = Math.pow(n1, n2);
                    default -> {
                        logMessage = "Ошибочный ввод действия над числами";
                        System.out.println(logMessage);
                        correctInput = false;
                        logger.log(Level.WARNING, logMessage);
                    }
                }
//        вывод результата с округлением до 2 знаков после запятой
                if (correctInput) {
                    logMessage = String.format("%d %s %d = %.2f", n1, operation, n2, result);
                    System.out.printf("%s\n", logMessage);
                    operationStack.push(logMessage);
                    logger.info(logMessage);
                }
            } else {
                logMessage = "Не корректный ввод выбора действия!";
                System.out.println(logMessage);
                logger.log(Level.WARNING, logMessage);
            }
        }
    }
}
