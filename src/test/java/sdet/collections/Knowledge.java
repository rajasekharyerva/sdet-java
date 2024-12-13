package sdet.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Knowledge {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Zinguru Zingania");
        set.add("Yellow Stone");
        set.add("Combodia");
        System.out.println(set); // [A, B, C]

        set.stream().filter(s -> s.startsWith("Z")).forEach(System.out::println);
        ArrayList<String> list = new ArrayList();
        list.add("Aa");
        list.add("Ba");
        list.add("Ca");

        list.stream().filter(s -> s.startsWith("C")).map(String::toUpperCase).forEach(System.out::println);

        int length = set.stream().map(String::length).reduce(0,Integer::sum);
        System.out.println(length);

        set.parallelStream().forEach(System.out::println);
        set.stream().sorted().forEach(System.out::println);

        List<String> list2 = list.stream().filter(s -> s.startsWith("C")).collect(Collectors.toList());
        System.out.println(list2);

        // Count how many names start with "J"
        long count = set.stream().filter(s -> s.startsWith("Z")).count();
        System.out.println(count);
    }



}
