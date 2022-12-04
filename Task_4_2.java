//2. Реализовать консольное приложение, которое:
//Принимает от пользователя и “запоминает” строки.
//Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
//Если введено revert, удаляет предыдущую введенную строку из памяти.

import java.util.Scanner;
import java.util.Stack;

public class Task_4_2 {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Введите строку (Enter - завершение программы, print - вывод строк, revert - удаление предыдущей строки): ");
            String str = iScanner.nextLine();
            if (str.equals("")) {
                break;
            } else if (str.equals("print")) {
                for (int i = stack.size() - 1; i >= 0; i--) {
//                    проходим по стеку с конца (чтобы не удалять элементы)
                    System.out.printf(" %s", stack.get(i));
                }
                System.out.println();
            } else if (str.equals("revert")) {
                stack.pop();
            } else stack.push(str);
        }
        iScanner.close();
    }
}
