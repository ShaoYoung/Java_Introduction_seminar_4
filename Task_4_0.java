import java.util.ArrayList;
import java.util.LinkedList;

// 1) Замерьте время, за которое в ArrayList добавятся 10000 элементов.
//2) Замерьте время, за которое в LinkedList добавятся 10000 элементов. Сравните с предыдущим.
public class Task_4_0 {
    public static void main(String[] args) {

        String str = "1";
        var s = System.currentTimeMillis();
        ArrayList<String> al = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            al.add(str);
        }
        System.out.println(System.currentTimeMillis() - s);

        s = System.currentTimeMillis();
        LinkedList<String> ll = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            ll.add(str);
        }
        System.out.println(System.currentTimeMillis() - s);
    }
}
