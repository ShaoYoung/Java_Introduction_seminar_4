//3.
// 1) Написать метод, который принимает массив элементов, помещает их в стэк и выводит на консоль содержимое стэка.
// 2) Написать метод, который принимает массив элементов, помещает их в очередь и выводит на консоль содержимое очереди.

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Task_4_3 {
    public static void main(String[] args) {
        byte[] arr = new byte[10];
        for (byte i = 0; i < 10; i++) {
            arr[i] = ((byte) (Math.random() * 100));
        }

        System.out.println(Arrays.toString(arr));

        Stack<Byte> stack = new Stack<>();
        Queue<Byte> qu = new LinkedList<>();

        for (int j = 0; j < arr.length; j++) {
            stack.push(arr[j]);
            qu.add(arr[j]);
        }
        System.out.println(stack);

        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %s", stack.pop());
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %s", qu.poll());
        }
    }
}

