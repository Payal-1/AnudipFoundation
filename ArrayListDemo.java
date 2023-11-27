import java.util.ArrayList;
import java.util.Iterator;

public class StringArrayListOperations {

    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Apple");
        stringList.add("Orange");
        stringList.add("Banana");
        stringList.add("Grapes");
        stringList.add("Kiwi");
        stringList.add("Mango");

        // Task 1: Iterate through the ArrayList and print each string with its length
        System.out.println("Strings with their lengths:");
        for (String str : stringList) {
            System.out.println(str + " - Length: " + str.length());
        }

        // Task 2: Remove strings with a length less than or equal to 3
        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.length() <= 3) {
                iterator.remove();
            }
        }

        // Task 3: Print the modified ArrayList
        System.out.println("\nModified ArrayList:");
        for (String str : stringList) {
            System.out.println(str);
        }
    }
}
