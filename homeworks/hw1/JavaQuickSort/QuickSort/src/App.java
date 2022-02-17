import java.util.Random;
public class App {
    public static void main(String[] args) throws Exception {
        QuickSort qs = new QuickSort();
        int[] randArr = new int[10];
        Random rand = new Random();
        for(int i = 0;i < 10;i++) {
            randArr[i] = rand.nextInt(100);
        }
        qs.quickSort(randArr);
        for (int i : randArr) {
            System.out.println(i);
        }
    }
}
