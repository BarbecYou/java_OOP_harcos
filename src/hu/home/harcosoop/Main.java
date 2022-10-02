package hu.home.harcosoop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Harcos> harcosok = new ArrayList<>();
    public static void main(String[] args) {

        //feladat1();
        feladat2();
        feladat3();

    }

    private static void feladat3() {


    }

    private static void feladat2() {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("harcosok.csv"));
        } catch (FileNotFoundException e){
            System.out.println("nem található a file");
        }

        while (sc.hasNext()){
            String[] sor = sc.nextLine().split(";");
            harcosok.add(new Harcos(sor[0], Integer.parseInt(sor[1])));
        }
        sc.close();
        System.out.println(harcosok);


    }
    private static void feladat1() {
        Harcos jani = new Harcos("jani", 2);
        Harcos telepiJozsi = new Harcos("a telepi józsi", 1);

        System.out.println(jani);
        System.out.println(telepiJozsi);

        jani.megkuzd(telepiJozsi);

        System.out.println(jani);
        System.out.println(telepiJozsi);
    }
}
