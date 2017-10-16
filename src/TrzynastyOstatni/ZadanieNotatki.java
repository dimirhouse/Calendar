package TrzynastyOstatni;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

    public class ZadanieNotatki {
        public static final Path NOTES = Paths.get("resources/notatki.txt");
        static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        public static void main(String[] args) throws IOException {
            readFromFileAndPrint();
            System.out.println("Twoje notatki: ");
            List<String> notes = getNotes();
            Files.write(NOTES, notes, StandardOpenOption.APPEND);

        }

        private static List<String> getNotes() {
            Scanner in = new Scanner(System.in);
            List<String> notes = new LinkedList<>();
            String note = null;
            do {
                note = in.nextLine();
            } while (isNotMinus(note, notes));
            return notes;
        }

        private static boolean isNotMinus(String s, List<String> notes) {
            if (isNotMinus(s)) {
                notes.add(String.format("%s %s", LocalDateTime.now().format(formatter), s));
            }

            return isNotMinus(s);
        }

        private static boolean isNotMinus(String s) {
            return !"-".equals(s);
        }

        private static void readFromFileAndPrint() {
            try {
                List<String> strings = Files.readAllLines(NOTES);
                strings.stream().forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
