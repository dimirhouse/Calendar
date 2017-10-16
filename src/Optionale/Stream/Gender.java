package Optionale.Stream;

public enum Gender {

    MALE("M"),
    KOBIETA("K");

    private String sex;

    Gender(String sex){
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
}
