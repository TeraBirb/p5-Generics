import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Tester {

    public static <T> void main(String[] args) {

        // initializing stuff
        Random rng = new Random();
        ArrayList<Integer> intList1 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            intList1.add(rng.nextInt(1, 1001));
        }

        // FILTER TESTS
        // filter implementation
        Predicate<Integer> filter1 = (Integer li) -> (li > 500);     // remove all elements < 500
        System.out.println("Filter to remove all elements less than 500");

        // nondestructiveFilter test1
        System.out.println("intList1 before nondestructiveFilter: " + intList1);
        System.out.println("temp list after nondestructiveFilter: " + ListProcessor.nondestructiveFilter(intList1, filter1));
        System.out.println("intList1 after nondestructiveFilter: " + intList1);

        // destructiveFilter test1
        System.out.println("intList1 before destructiveFilter: " + intList1);
        ListProcessor.destructiveFilter(intList1, filter1);
        System.out.println("intList1 after destructiveFilter: " + intList1);
        System.out.println("----------");

        // initialize another arraylist of 10 Strings
        ArrayList<String> stringList1 = new ArrayList<String>() {
            {
                addAll(Arrays.asList("theater", "passive", "inappropriate", "privilege", "transparent",
                        "ambiguity", "looting", "benefit", "snack", "complete"));
            }
        };

        // filter implementation
        Predicate<String> filter2 = (String li) -> {
            for (int i = 0; i < li.toString().length() - 1; i++) {
                if (li.toString().charAt(i) == li.toString().charAt(i + 1)) {
                    return true;    // remove elements with repeating letters
                }
            }
            return false;

        };
        System.out.println("Filter to remove elements without repeating letters");

        // nondestructiveFilter test2
        System.out.println("stringList1 before nondestructiveFilter: " + stringList1);
        System.out.println("temp list after nondestructiveFilter: " + ListProcessor.nondestructiveFilter(stringList1, filter2));
        System.out.println("stringList1 after nondestructiveFilter: " + stringList1);

        // destructiveFilter test2
        System.out.println("stringList1 before destructiveFilter: " + stringList1);
        ListProcessor.destructiveFilter(stringList1, filter2);
        System.out.println("stringList1 after destructiveFilter: " + stringList1);
        System.out.println("----------");

        // FUNCTIONAPPLYER TESTS
        // initialize another random 10 integer arraylist (1-1000)

        ArrayList<Integer> intList2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            intList2.add(rng.nextInt(1, 1001));
        }

        // function implementation
        Function<Integer> func1 = (Integer i) -> (i * 2); // multiply each element by 2
        System.out.println("Function to multiply each element by 2");

        // nondestructiveFunctionApplyer test1
        System.out.println("intList2 before nondestructiveFunctionApplyer: " + intList2);
        System.out.println("temp list after nondestructiveFunctionApplyer: " + ListProcessor.nondestructiveFunctionApplyer(intList2, func1));
        System.out.println("intList2 after nondestructiveFunctionApplyer: " + intList2);

        // destructiveFunctionApplyer test1
        System.out.println("intList2 before destructiveFunctionApplyer: " + intList2);
        ListProcessor.destructiveFunctionApplyer(intList2, func1);
        System.out.println("intList2 after destructiveFunctionApplyer: " + intList2);
        System.out.println("----------");

        // initialize arraylist of 10 strings
        ArrayList<String> stringList2 = new ArrayList<>(Arrays.asList("bank", "perfect", "fuss", "pitch", "faint",
                "reliance", "conceive", "bubble", "award", "sector"));

        // function implementation
        Function<String>func2 = (String li) -> {
            StringBuilder string = new StringBuilder(li);

            for (int i = 0; i < string.length() / 2; i++) {     // reverse letters in each element
                char temp = li.charAt(i);
                string.setCharAt(i, string.charAt(string.length() - 1 - i));
                string.setCharAt(string.length() - 1 - i, temp);
            }

            return String.valueOf(string);
        };
        System.out.println("Function to reverse letters in each element");

        // nondestructiveFunctionApplyer test2
        System.out.println("stringList2 before nondestructiveFunctionApplyer: " + stringList2);
        System.out.println("temp list after nondestructiveFunctionApplyer: " + ListProcessor.nondestructiveFunctionApplyer(stringList2, func2));
        System.out.println("stringList2 after nondestructiveFunctionApplyer: " + stringList2);

        // destructiveFunctionApplyer test2
        System.out.println("stringList2 before destructiveFunctionApplyer: " + stringList2);
        ListProcessor.destructiveFunctionApplyer(stringList2, func2);
        System.out.println("stringList2 after destructiveFunctionApplyer: " + stringList2);
        System.out.println("----------");


    }

}
