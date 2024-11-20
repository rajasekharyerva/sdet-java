package sdet.java.java8.streams;

import java.util.List;

public class MyStream {
    public static void main(String[] args) {
        //Arrays
        //List
        List<String> list = List.of("abc", "sndknf", "sfsfnf", "fssfkn", "kndkdnkd");
        //Print list using stream
        list.stream().filter(item->item.length()==6).forEach(System.out::println);
        list.stream().limit(2).forEach(System.out::println);
    }
}
