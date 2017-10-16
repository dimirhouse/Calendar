package Optionale.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StreamTest {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("ala", "ala", "jola", "balbina", null, "zyta", "ania", "basia", "krysia");

//        names.stream().forEach(imie -> System.out.println(imie));//imie tworzymy tutaj w nawiasie bez uzycia String imie
//        names.stream().forEach(System.out::println);//ta linia jest rownowazna powyzszej
//
//        System.out.println("SORTED alfabetycznie");
//
//        names.stream().sorted().forEach(System.out::println);
//
//        System.out.println();
//        System.out.println("wydrokowanie najdluzszego imienia");
//
//        String string = names.stream().sorted((s1, s2) -> s2.length() - s1.length()).findFirst().orElse("krzysiek");
//        System.out.println(string);

//        names.stream()
//                .filter(imie -> imie != null)
//                .filter(imie -> imie.startsWith("a")) //filtrowanie imion (beda te ktore zaczynaja sie na "a")
//                .forEach(System.out::println);
//
//        names.stream()
//                .distinct()
//                .forEach(System.out::println);
//
//        long count = names.stream()
//                .count();

        names.stream()
                .filter(Objects::nonNull)
                .distinct()
                .sorted()
                .map(s -> String.format("czesc, mam na imie %s", s))
                .forEach(System.out::println);
    }

}
