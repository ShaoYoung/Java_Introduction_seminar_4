// ДЗ 2. Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.

// проверка возможности выполнения метода

import java.util.LinkedList;

public class SolutionHW_4_2 {

    //    помещает элемент в конец очереди
    public static LinkedList<Integer> enqueue(LinkedList<Integer> ll, int elem) {
        ll.add(elem);
        return ll;
    }

    //    возвращает первый элемент из очереди и удаляет его. проверка реализована через исключения try / catch.
//    возвращает LinkedList<Object>. 0 элемент - новый LinkedList, 1 - результат выполнения LinkedList.remove
    public static LinkedList<Object> dequeue(LinkedList<Integer> ll) {
        LinkedList<Object> result = new LinkedList<>();
        try {
            int firstElem = ll.remove();
            result.add(ll);
            result.add(firstElem);
            return result;
        } catch (Exception e) {
            result.add(ll);
            result.add(null);
            return result;
        }
    }

    //    возвращает первый элемент из очереди, не удаляя его. проверка реализована через условие if.
    public static Object first(LinkedList<Integer> ll) {
        if (ll.size() == 0) {
            return null;
        } else {
            return ll.peek();
        }
    }

    public static void main(String[] args) {

//        "очередь"
        LinkedList ll = new LinkedList<>();
//        // очередь
        int llLength = 10;

        for (int i = 0; i < llLength; i++) {
            ll.add(i);
        }
        System.out.printf("Очередь: %s\n", ll);

        int elem = 100;
        ll = enqueue(ll, elem);
        System.out.printf("Элемент %d добавлен в конец очереди: %s\n", elem, ll);

//        получаем список объектов из метода dequeu. 0 объект - LinkedList, 1 объект - элемент в результате выполнения метода dequeu
        LinkedList<Object> result = dequeue(ll);
        System.out.printf("Первый элемент из 'очереди' %s\n", result.get(1));
//        преобразуем объект-массив в int-массив
        ll = (LinkedList) result.get(0);
        System.out.printf("Теперь 'очередь' выглядит так: %s\n", ll);

        Object firstElemQu = first(ll);
        System.out.printf("Первый элемент очереди: %s (не удалён)\n", firstElemQu);
        System.out.printf("Очередь: %s\n", ll);
    }
}
