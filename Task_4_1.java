//Реализовать консольное приложение, которое:
//Принимает от пользователя строку вида
//text~num
//Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
//Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.

import java.util.LinkedList;
import java.util.Scanner;

public class Task_4_1 {
    public static void main(String[] args) {

        LinkedList<String> ll = new LinkedList<>();
        String str;
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Введите строку вида text~num: ");
            String nString = iScanner.nextLine();
            if (nString.equals("")) {
                break;
            }
            String[] sArr = nString.split("~");
            if (!sArr[0].equals("print")) {
                System.out.println(sArr.length);
                ll.add(Integer.parseInt(sArr[1]), sArr[0]);
                System.out.println(ll);
            } else {
                str = ll.remove(Integer.parseInt(sArr[1]));
                System.out.printf("Элемент %s\n", str);
                System.out.printf("Оставшийся список %s\n", ll);
            }
        }
        iScanner.close();
    }
}
