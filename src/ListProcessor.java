import java.util.ArrayList;

public final class ListProcessor<T> {

    public static <T> ArrayList<T> destructiveFilter(ArrayList<T> a, Predicate p) {

        ArrayList<T> temp = new ArrayList<>();
        for (T i : a) {
            if (p.test(i)) {
                temp.add(i);
            }
        }

        // destructive part
        a.clear();
        a.addAll(temp);

        return a;

    }

    public static <T> ArrayList<T> nondestructiveFilter(ArrayList<T> a, Predicate p) {

        ArrayList<T> temp = new ArrayList<>();
        for (T i : a) {
            if (p.test(i)) {
                temp.add(i);
            }
        }

        return temp;

    }

    public static <T> ArrayList<T> nondestructiveFunctionApplyer(ArrayList<T> a, Function p) {

        ArrayList<T> temp = new ArrayList<>();
        for (T i : a) {
            temp.add((T) p.apply(i));
        }

        return temp;

    }

    public static <T> ArrayList<T> destructiveFunctionApplyer(ArrayList<T> a, Function p) {

        ArrayList<T> temp = new ArrayList<>();
        for (T i : a) {
            temp.add((T) p.apply((T)i));
        }

        // destructive part
        a.clear();
        a.addAll(temp);

        return a;

    }

}
