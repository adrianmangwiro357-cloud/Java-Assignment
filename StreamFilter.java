import java.util.ArrayList;
import java.util.List;

public class StreamFilter{
    public static void main(String[] args) {
        //creating the arraylist
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(4);
        numbers.add(5);
        numbers.add(20);
        numbers.add(30);
        numbers.add(6);
        System.out.println("Given_List: "+ numbers);
        System.out.print("numbers divisible by 5: ");

        //using stream to filter the numbers divisible by 5
        numbers.stream().filter(n->n% 5==0).forEach(n-> System.out.print(n + " "));
    }
}
