package Optionale.Stream;

public enum DrivingLicense {

    A("kategoria A"),
    B("kat. B"),
    C("kat. C"),
    D("kat. D");

    private String kategoria;

    DrivingLicense (String kategoria){
        this.kategoria = kategoria;
    }

    public String getKategoria() {
        return kategoria;
    }
}
