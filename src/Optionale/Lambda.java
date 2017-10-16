package Optionale;

public class Lambda {

    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        SampleInterface si = (x, y) -> x + y; //tworze implementacje
        System.out.println(si.method(a, b)); // a tu wywoluje
    }

    interface SampleInterface {
        int method(int a, int b);
    }
}
