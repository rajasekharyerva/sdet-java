package sdet.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesList {
    public static void main(String[] args) {
        // Create a list with duplicate elements
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(1);

        // Remove duplicates using HashSet
        Set<Integer> set = new HashSet<>(list);
        List<Integer> uniqueList = new ArrayList<>(set);

        // Display the list without duplicates
        System.out.println("List without duplicates: " + uniqueList);
    }
}

