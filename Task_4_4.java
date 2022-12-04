//4. Реализовать стек с помощью массива.
// Нужно реализовать методы:
// size(), empty(), push(), peek(), pop().

import java.util.ArrayList;
import java.util.Arrays;

public class Task_4_4 {

    // Stack.size() - Returns the number of components in this vector (return integer).
    public static int size(int[] array) {
        return array.length;
    }

    // Stack.empty() - Tests if this stack is empty (return boolean).
    // true if and only if this stack contains no items; false otherwise
    public static boolean empty(int[] array) {
        if (array.length == 0) return true;
        else return false;

    }

    // Stack.push() - Pushes an item onto the top of this stack.
    public static int[] push(int[] array, int item) {
        int[] temp = new int[array.length + 1];
        System.arraycopy(array, 0, temp, 0, array.length);
        temp[temp.length - 1] = item;
        return temp;
    }

    // Stack.peek() - Looks at the object at the top of this stack without removing it from the stack.
//        (Returns: the object at the top of this stack (the last item of the Vector object).)
    public static Integer peek(int[] array) {
        return array[array.length - 1];
    }


    // Stack.pop() - Removes the object at the top of this stack and returns that object as the value of this function.
//        (Returns: The object at the top of this stack (the last item of the Vector object).
//    Возвращает список объектов: 0 объект - массив, 1 объект - элемент в результате выполнения метода pop
    public static ArrayList<Object> pop(int[] array) {
        int[] temp = new int[array.length - 1];
        System.arraycopy(array, 0, temp, 0, array.length - 1);
        int top = array[array.length - 1];
        ArrayList<Object> result = new ArrayList<>();
        result.add(temp);
        result.add(top);
        return result;
    }


    public static void main(String[] args) {

        // длина стека-массива
        byte stLength = 10;
        int[] array = new int[stLength];
        for (byte i = 0; i < stLength; i++) {
            array[i] = i;
        }

        System.out.printf("Исходный массив-стек %s\n", Arrays.toString(array));
        System.out.printf("Stack.size = %s\n", size(array));
        if (empty(array)) System.out.println("Массив-стек пустой");
        else System.out.println("Массив-стек содержит хотя бы один элемент");

        int item = 100;
        array = push(array, item);
        System.out.printf("Число %d push в исходный массив-стек %s\n", item, Arrays.toString(array));
        System.out.printf("Peek из массива-стека %s\n", peek(array));
        System.out.printf("Массив-стек без изменений %s\n", Arrays.toString(array));

//        получаем список объектов из метода pop. 0 объект - массив, 1 объект - элемент в результате выполнения метода pop
        ArrayList<Object> result = pop(array);
        System.out.printf("Pop из массива-стека %s\n", result.get(1));
//        преобразуем объект-массив в int-массив
        array = (int[]) result.get(0);
        System.out.printf("Теперь массив-стек выглядит так: %s\n", Arrays.toString(array));

    }
}
