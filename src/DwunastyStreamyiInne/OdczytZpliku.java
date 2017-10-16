package DwunastyStreamyiInne;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OdczytZpliku {
    public static void main(String[] args) {
        try{ //odczyt z pliku out_nio.txt
            List<String> strings = Files.readAllLines(Paths.get("resources/out_nio.txt"));
            strings.stream().forEach(System.out::println);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
