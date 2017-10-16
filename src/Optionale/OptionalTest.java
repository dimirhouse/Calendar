package Optionale;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        String str = "ala ma kota";
      //  String str = null;

        System.out.println(Optional.ofNullable(str).orElse("ala nie ma kota"));
    }
}
