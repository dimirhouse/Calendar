package Optionale.Stream;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;

public class Person {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Set<DrivingLicense> drivingLicense;

    public Person() {
    }

    public Person(String firstName, String lastName, LocalDate dateOfBirth, Set<DrivingLicense> drivingLicense) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.drivingLicense = drivingLicense;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<DrivingLicense> getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(Set<DrivingLicense> drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String toString() {
        return String.format("Person [imię: %s, nazwisko %s, data urodzenia %s, prawo jazdy %s]",
                getFirstName(),
                getLastName(),
                getDateOfBirth(),
                getDrivingLicense());
    }

    public int calculateAge() {
        return Period.between(this.getDateOfBirth(), LocalDate.now()).getYears();
    }
}
