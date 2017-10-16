package DwunastyStreamyiInne;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class ZadanieDziennik {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        //Napisz program ktory pobierze od uzytkownika wpis i zapisze go w pliku tekstowym "dziennik"
        //plik tekstowy ma pokazac date , godzine i tresc wpisu
        // jesli uzytkownik wpisze "-" program przerywa dzialanie

        try {
            Files.write(Paths.get("resources/dziennik.txt"), getWpis(), StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static List<String> getWpis(){
        List<String> wpis = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        do{
            wpis.add(LocalDateTime.now().format(formatter) + " " + in.nextLine());
        } while (!in.nextLine().equals("-"));
        return wpis;
    }
}
