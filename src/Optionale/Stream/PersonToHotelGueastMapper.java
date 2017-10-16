package Optionale.Stream;

public class PersonToHotelGueastMapper {

    public HotelGuest mapPerson(Person person){
        HotelGuest guest = new HotelGuest();
        guest.setName(String.format("%s, %s", person.getFirstName(), person.getLastName()));
        guest.setAge(person.calculateAge());
        guest.setGender(person.getFirstName().endsWith("a") ? Gender.MALE : Gender.KOBIETA);
        return guest;
    }
}
