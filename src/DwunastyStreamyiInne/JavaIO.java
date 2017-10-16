package DwunastyStreamyiInne;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

public class JavaIO {


    //READ FROM TXT FILE
    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("resources/somefile.txt"))) { //sciezka bezwzgledna jest od samego poczatku
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (Stream<String> lines = Files.lines(Paths.get("resources/somefile.txt"))) { //sciezka wzgledna - sciezka od miejsca gdzie jestesmy do pliku ktory nas interesuje
            lines.forEach(line -> System.out.println(line));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        //WRITE TO FILE
        FileWriter writer = null;
        try {
            Files.write(Paths.get("resources/out_nio.txt"), getColors(), StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        } //w pliku out_nio.txt zamieni nam pierwotna wartosc na to co jest w metodzie getColors
    }
        private static List<String> getColors(){ //statyczna powoduje ze nie musze tworzyc nowego obiektu tylko wywoluje ta metode
            List<String> colors = new ArrayList<>();
            colors.add("black");
            colors.add("red");
            colors.add("green");
            colors.add("pink");
            colors.add("white");
            colors.add("brown");
            colors.add("dfdsgfdfdskfjsdfksjf");
        return colors;
    }


}
