package Optionale.Stream;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static Optionale.Stream.DrivingLicense.*;


public class PersonTest {

    public static void main(String[] args) {
       List<Person> wycieczka = createTour(); //osoby (obiekty) z metody createTour na dole kodu przypisuje do listy wycieczka

//       wycieczka.stream()
//               .map(s -> String.format("elo ziomeczki! jestem %s %s", s.getFirstName(), s.getLastName()))
//               .forEach(System.out::println);

        //********************************************************************************************************

//       Person lecPoFlache = wycieczka.stream()
//               .filter(osoba -> Period.between(osoba.getDateOfBirth(), LocalDate.now()).getYears() >= 18)  //oznacza to okres miedzy//data urodzenia a aktualna data i bierzemy roczniki ktorych okres miedz//data urodzenia a aktualna data wynosi wiecej niz 18 lat.
//               .sorted((p1, p2) -> p2.getDateOfBirth().compareTo(p1.getDateOfBirth())) //przesortuje nam wszystkich powyzej 18 lat
//               .findFirst() // i wybierze pierwszego (najmlodszego)
//               .get();
//        System.out.println(lecPoFlache);
        System.out.println("samobojcy");
        wycieczka.stream()
                .filter(osoba -> Period.between(osoba.getDateOfBirth(), LocalDate.now()).getYears() <= 25)
                .filter(osoba -> osoba.getDrivingLicense().contains(A))
                .forEach(System.out::println);

        //********************************************************************************************************

            wycieczka.stream()
                    .filter(imie -> imie.getFirstName().endsWith("a"))//sprawdza kobiety
                    .collect(Collectors.toList()); //wrzuca je do listy

            long naBilety = wycieczka.stream()
                    .filter(osoba -> !osoba.getFirstName().endsWith("a")) //tylko panowie
                    .filter(osoba -> osoba.calculateAge() >= 18) //odwolanie do metody calculataAge
                    .count() * 19; //cena biletu normalnego to 19zl
            naBilety += wycieczka.stream()
                    .filter(osoba -> osoba.calculateAge() < 18)
                    .count() * 17; //cena biletu ulgowego to 17zl

        System.out.println(naBilety);

        //*********************************************************************************************************

        Person ktoMaD = wycieczka.stream()
                .filter(person -> person.getDrivingLicense().contains(D)) //szuka osoby ktora ma D
                .findAny() //szuka kogokolwiek
                .get(); //wybiera
        System.out.println(ktoMaD);

        //*********************************************************************************************************
        PersonToHotelGueastMapper mapper = new PersonToHotelGueastMapper();
        List<HotelGuest> hotelGuests = wycieczka.stream()
                .map(person -> mapper.mapPerson(person))
                .collect(Collectors.toList());
        System.out.println(hotelGuests);

        //*********************************************************************************************************

//        double sredniaWieku = wycieczka.stream()
//                .mapToInt(p -> Period.between(p.getDateOfBirth(), LocalDate.now()).getYears())
//                .average()
//                .getAsDouble();
//        System.out.println(sredniaWieku);
    }

    private static List<Person> createTour(){
        List<Person> wycieczka = new LinkedList<>();
        wycieczka.add(new Person("Jan", "Kowalski", LocalDate.of(2016, 2, 20), createDrivinLicenseSet()));
        wycieczka.add(new Person("Marian", "Kowalski", LocalDate.of(1970, 3, 21), createDrivinLicenseSet(B)));
        wycieczka.add(new Person("Jolanta", "Kowalska", LocalDate.of(1972, 10, 1), createDrivinLicenseSet(B)));
        wycieczka.add(new Person("Janusz", "Cebula", LocalDate.of(1969, 1, 1), createDrivinLicenseSet(B, C)));
        wycieczka.add(new Person("Grażyna", "Cebula", LocalDate.of(1970, 11, 30), createDrivinLicenseSet()));
        wycieczka.add(new Person("Brajan", "Cebula", LocalDate.of(2001, 11, 14), createDrivinLicenseSet(A)));
        wycieczka.add(new Person("Karyna", "Cebula", LocalDate.of(2002, 11, 14), createDrivinLicenseSet()));
        wycieczka.add(new Person("Grzegorz", "Brzęczyszczykiewicz", LocalDate.of(1933, 6, 7), createDrivinLicenseSet(B)));
        wycieczka.add(new Person("Apolonia", "Brzęczyszczykiewicz", LocalDate.of(1916, 4, 30), createDrivinLicenseSet(B, C)));
        wycieczka.add(new Person("Andżelika", "Nowak", LocalDate.of(1996, 6, 2), createDrivinLicenseSet(B)));
        wycieczka.add(new Person("Wiesław", "Paleta", LocalDate.of(1951, 9, 13), createDrivinLicenseSet(B, C)));
        wycieczka.add(new Person("Bolek", "Bajeczny", LocalDate.of(1989, 1, 31), createDrivinLicenseSet(B)));
        wycieczka.add(new Person("Gabrysia", "Garkowa", LocalDate.of(1987, 5, 1), createDrivinLicenseSet()));
        wycieczka.add(new Person("Alan", "Garkowy", LocalDate.of(2013, 3, 15), createDrivinLicenseSet()));
        wycieczka.add(new Person("Julian", "Tuwim", LocalDate.of(1979, 3, 16), createDrivinLicenseSet(A, B, C, D)));
        return wycieczka;
    }

    private static Set<DrivingLicense> createDrivinLicenseSet(DrivingLicense... categories) {
        Set<DrivingLicense> b = new HashSet<>();
        for (DrivingLicense category : categories) {
            b.add(category);
        }
        return b;
    }


}
