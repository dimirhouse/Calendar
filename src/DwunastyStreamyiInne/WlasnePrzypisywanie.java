package DwunastyStreamyiInne;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class WlasnePrzypisywanie {
    public static void main(String[] args) {


        Properties prop = new Properties();
        try (FileOutputStream user =  new FileOutputStream("resources/user.properties")){

            prop.put("user nr 1", getWpis());
            prop.put("user nr 2", getWpis());
            prop.put("user nr 3", getWpis());
            prop.put("user nr 4", getWpis());
            prop.put("user nr 5", getWpis());
            prop.store(user, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static String getWpis(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
