//ДЗ 1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

import java.util.Collections;
import java.util.LinkedList;

public class SolutionHW_4_1 {

    public static LinkedList<Integer> RevList_1(LinkedList<Integer> ll) {
        Collections.reverse(ll);
        return ll;
    }

    public static LinkedList<Integer> RevList_2(LinkedList<Integer> ll) {
        for (int i = 1; i < ll.size(); i++) {
//первый элемент оставляем на месте, элементы, находящиеся справа от него, получаем (с удалением) и записываем слева от него
            ll.addFirst(ll.remove(i));
        }
        return ll;
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            ll.add((int) (Math.random() * 10));
        }
        System.out.printf("Первоначальный LinkedList: %s\n", ll);
        ll = RevList_1(ll);
        System.out.printf("Перевёрнутый LinkedList: %s\n", ll);
        ll = RevList_2(ll);

        System.out.printf("Ещё раз перевёрнутый LinkedList: %s", ll);
    }
}
