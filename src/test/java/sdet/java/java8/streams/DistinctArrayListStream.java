package sdet.java.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DistinctArrayListStream {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 5, 4, 1));
        ArrayList<Integer> resultList = arrayList.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        for (Integer item : resultList)
            System.out.print(item);
    }
}
