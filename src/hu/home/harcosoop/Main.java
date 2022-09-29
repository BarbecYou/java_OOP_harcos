package hu.home.harcosoop;

public class Main {
    public static void main(String[] args) {

        Harcos jani = new Harcos("jani", 2);
        Harcos telepiJozsi = new Harcos("a telepi józsi", 1);

        System.out.println(jani);
        System.out.println(telepiJozsi);

        jani.megkuzd(telepiJozsi);

        System.out.println(jani);
        System.out.println(telepiJozsi);
    }
}
