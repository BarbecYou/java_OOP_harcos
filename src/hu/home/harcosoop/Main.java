package hu.home.harcosoop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static List<Harcos> harcosok = new ArrayList<>();
    public static Harcos sajatHarcos;
    public static int korSzam = 0;
    public static void main(String[] args) {

        Scanner inScanner = new Scanner(System.in);
        //feladat1();
        feladat2();
        System.out.println();
        feladat3();

    }

    private static void feladat3() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Add meg a karaktered nevét: ");
        String karakterNev = sc.nextLine();
        boolean elfogadva = false;
        int karakterStatusz = 0;
        while (!elfogadva){
            System.out.print("Add meg a karaktered státusz sablonját (1, 2 ,3): ");
            karakterStatusz = sc.nextInt();
            if (karakterStatusz > 0 && karakterStatusz < 4) {
                elfogadva = true;
            } else {
                System.out.println("Nem megfelelő sablon!");
            }
        }
        sajatHarcos = new Harcos(karakterNev, karakterStatusz);
        boolean kilepett = false;
        while (!kilepett){
            korSzam++;
            if (turn() == 0){
                break;
            }

        }



    }

    private static int turn() {

        int intToReturn = 0;
        System.out.println();
        System.out.println(korSzam + ". kör!!!");

        System.out.println();
        System.out.println("A te harcosod: ");
        System.out.println(sajatHarcos);
        System.out.println("A többi harcos: ");
        int i = 1;
        for (Harcos h : harcosok){
            System.out.println(i + ". " + h);
            i++;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println();
        boolean elfogadva = false;
        int valasztas = 0;
        while (!elfogadva){
            System.out.println("Mit szeretnél tenni?\n" +
                    "1 - megküzdés egy harcossal\n" +
                    "2 - gyógyulás\n" +
                    "3 - kilépés");
            valasztas = Integer.parseInt(sc.next());
            if (valasztas > 0 && valasztas < 4){
                elfogadva = true;
            } else {
                System.out.println("Hibás opció");
            }
        }
        switch (valasztas){
            case 1:
                System.out.println("Harcosok: ");
                int f = 1;
                for (Harcos h : harcosok){
                    System.out.println(f + ". " + h);
                    f++;
                }
                boolean elfogadva2 = false;
                int sorSzam = 0;
                while (!elfogadva2){
                    System.out.print("Hanyadik sorszámú harcossal szeretnél megküzdeni? ");
                    sorSzam = sc.nextInt();
                    if (sorSzam < 1 || sorSzam > harcosok.size()){
                        System.out.println("Hibás sorszámot adtál meg!");
                    }else {
                        elfogadva2 = true;
                    }
                }
                System.out.println();
                System.out.println("Küzdelem " + harcosok.get(sorSzam - 1).getNev() + " ellen!");
                sajatHarcos.megkuzd(harcosok.get(sorSzam - 1));
                System.out.println("Küzdelem kimenete: " + (sajatHarcos.getEletero() > harcosok.get(sorSzam - 1).getEletero() ?
                        "A te karaktered" : harcosok.get(sorSzam - 1).getNev()) + " győzött!");
                System.out.println(sajatHarcos);
                System.out.println(harcosok.get(sorSzam - 1));

                try {
                    System.in.read();
                } catch (IOException e){

                }

                intToReturn = 1;
                break;
            case 2:
                sajatHarcos.gyogyul();
                System.out.println();
                System.out.println("Sikeresen meggyógyultál");
                intToReturn = 1;
                break;
            case 3:
                intToReturn = 0;
                System.out.println();
                System.out.println("Kilépés...");
                break;
        }
        Random rnd = new Random();
        Harcos randomHarcos = null;
        boolean isValidated = false;
        while (!isValidated){
            int random = rnd.nextInt(harcosok.size() - 1);
            randomHarcos = harcosok.get(random);
            if (randomHarcos.getEletero() > 0){
                isValidated = true;
            }
        }

        if (korSzam % 3 == 0){
            System.out.println();
            System.out.println("Váratlan esemény! " + randomHarcos.getNev() + " megtámadott!");
            randomHarcos.megkuzd(sajatHarcos);
            System.out.println("Küzdelem kimenete: " + (sajatHarcos.getEletero() > randomHarcos.getEletero() ?
                    "A te karaktered" : randomHarcos.getNev()) + " győzött!");
            System.out.println(sajatHarcos);
            System.out.println(randomHarcos);
            System.out.println();
            System.out.println("Minden harcos gyógyul!");
            sajatHarcos.gyogyul();
            int f = 1;
            for (Harcos h : harcosok){
                h.gyogyul();
                f++;
            }
        }
        return intToReturn;
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
