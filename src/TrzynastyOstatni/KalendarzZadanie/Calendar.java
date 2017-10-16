package TrzynastyOstatni.KalendarzZadanie;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import static java.time.LocalDate.now;

public class Calendar {

    /**wydrukowac miesiace i rok
    wydrukowac dni
    wydrukowac puste znaki
    dzien dzisiejszy zaznaczyc gwiazdka "*" */

    public static void main(String[] args) {
        String calendar = getCalendar();
        System.out.println(calendar);
    }

    private static String getCalendar(){
        return getCalendar(YearMonth.now());
    }

    private static String getCalendar(YearMonth yearMonth){
        StringBuilder sb = new StringBuilder(240); //StringBuilder ma metode append ktora dobudowuje kolejne kawalki Stringa

        //drukowanie nazwy miesiaca i roku
        sb.append(yearMonth.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault())); //STAND_ALONE pelna nazwa miesiaca wystepujaca samotnie
        sb.append(" ");//doklejamy spacje
        sb.append(yearMonth.getYear());//i dorzucamy rok
        sb.append("\n");//teraz new line

        //drukowanie nazw dni tygodnia
        for (DayOfWeek day : DayOfWeek.values()){ //klasa DayOfWeek to dni tygodnia a values zwraca nam od Pon do Pt
            sb.append(String.format("%3s ", day.getDisplayName(TextStyle.SHORT_STANDALONE, Locale.getDefault()))); //drukujemy Stringa na trzech znakach i jeszcze spacja
            //gdy skrot ma dwie litery to bedzie spacja LITERA LITERA spacja (np. " Pn "). Jesli jest jedna litera to spacja spacja LITERA spacja (np "  N ").
        }
        sb.append("\n");//new line

        LocalDate date = LocalDate.of(yearMonth.getYear(), //tworzymy nowa date (ustawiamy na pierwszy dzien podanego miesieca)
                yearMonth.getMonth(),
        1);

        //drukowanie spacji do ostatniego poniedzialku poprzedniego miesiaca
        for (int i = date.getDayOfWeek().getValue(); i > DayOfWeek.MONDAY.getValue(); i--) { //pobieramy z tej daty dzien tygodnia i dopoki nie dotrzemy do poniedzialku ->
            sb.append(" X" + i + " "); // -> doklejamy 4 spacje zeby sie przesunac do odpowiedniego dnia tygodnia ktory bedziemy drukowac
        }

        while (date.getMonth().equals(yearMonth.getMonth())){ //jezeli jestes w miesiacu ktory mamy to drukuj to ponizej
            sb.append(String.format("%3d", date.getDayOfMonth()));

            if(date.equals(LocalDate.now())){ //porownojemy cala date. Jezeli jest dzisiejsza data w tej dacie drukujemy *
                sb.append("*");
            } else { //inaczej doklejamy spacje
                sb.append(" "); //w while jest "%3d" a * lub spacja w ifie elsie ma nam zapelnic czwarte pole
            }
            date = date.plusDays(1); //zwiekszamy date o jeden dzien

            if(date.getDayOfWeek().equals(DayOfWeek.MONDAY)) {  //jezeli mamy poniedzialek przeskakujemy do nowej linii
                //i drukujemy kolejne dni od nowej linii
                sb.append("\n"); // "\n" oznacza new line czyli enter
            }
        }
        return sb.toString();
    }
}
