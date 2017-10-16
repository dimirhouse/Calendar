package DwunastyStreamyiInne;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class ManageProperies {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Properties properties = new Properties();
        try (FileOutputStream out = new FileOutputStream("resources/config.properties")) { //ta metoda stworzyla nam plik w katalogu recources
            //o nazwie config.properties
            properties.put("host", "google.com");
            properties.put("port", "21");
            properties.put("user", "root");
            properties.put("password", "dupa.8");
            properties.store(out, null);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}

