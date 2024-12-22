package sdet.collections;

import java.util.*;

public class ComparatorTest {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Jathin", "Arunima", "Akhil", "Matthew", "Benjamin"));
        Comparator<String> comparator = (name1, name2) -> (name1.length() > name2.length()) ? 1 : -1;
        Collections.sort(names, comparator);
        System.out.println(names.toString());
    }
}
