package DwunastyStreamyiInne;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    public static void main(String[] args) {
        Properties properties = new Properties();

        try (InputStream in = new FileInputStream("resources/config.properties")){
            properties.load(in);

            properties.entrySet().stream()
                    .forEach(e -> System.out.printf("%s, %s%n", e.getKey(), e.getValue()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
