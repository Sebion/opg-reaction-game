package sample.ReactBase;/*
    Doplňte funkcionalitu pre aplikáciu Reakčná doba

    Princíp hry

    Hráč po zadaní svojho mena spustí hru.
    Na otázku "Pripraveny ?" odpovedá stlačením ENTER
    Objaví sa hlásenie "Pozooor ..."
    a po náhodne dlhej dobe v intervale 0.5 - 3 sekundy sa objaví povel "START !!!"
    Cieľom hráča je v najrýchlejšom možnom čase opäť stlačiť ENTER.
    Program vypíše čas v milisekundách, ktorý uplynul od zobrazenia povelu START po stlačenie ENTER
    a zaradí ho do usporiadanej tabuľky výkonov (Meno hráča + výkon)
    Na obrazovku vypíše, kde sa daný výkon v tabuľke nachádza a to tak, že vypíše
    5 bezprostredne predchádzajúcich výkonov
    aktuálny výkon
    5 bezprostredne nasledujúcich výkonov
    To všetko v tvare Poradové číslo v tabuľke výkonov Tab6 Meno hráča Tab25 výkon
    Celú tabuľku s novým záznamom zapíše do textového súboru na disk, každý riadok v tvare MenoHraca:vykon

    Hra po spustení načíta zo súboru aktuálnu tabuľku výkonov a požiada hráča o prihlásenie (zadanie mena)
    Potom zobrazí MENU s položkami
    1 - Spusť hru
    2 - Zmena hráča
    3 - TOP 10
    4 - Koniec
    A reaguje podľa výberu

    Hru naprogramujte ako konzolovú aplikáciu aj ako aplikáciu s GUI. Využite pritom MVC.
    Pre meranie času využite funkciu System.currentTimeMillis();
    Hra musí ošetriť aj predčasné stlačenie pred zobrazením START ako chybu a potrestať ju (spôsob trestu je na vás)
*/

import java.io.*;
import java.lang.management.BufferPoolMXBean;
import java.util.ArrayList;
import java.util.Scanner;

public class ReactBase {
    final int CM_PLAY = 1;
    final int CM_CHANGE_PLAYER = 2;
    final int CM_TOP10 = 3;
    final int CM_QUIT = 4;
    String player= "Default";
    Scanner sc;
    private ArrayList<String> records;



    public ReactBase() {
        records = new ArrayList<>();
        sc = new Scanner(System.in);
        ImportRecords();
        NewPlayer();

    }

    public boolean Run() throws InterruptedException {
        switch (Menu()) {
            case CM_PLAY:
                long LastTime = Play(player);
                Sort(player, LastTime);
                ShowRecords(player, LastTime);
                SaveRecords(player,LastTime);
                return true;
            case CM_CHANGE_PLAYER:
                NewPlayer();
                return true;

            case CM_TOP10:
                ShowRecords("", 0);
                return true;
            case CM_QUIT:
                sc.close();
                return false;

        }
        return true;
    }

    public void ImportRecords()  {

        System.out.println("nacitavam z tabulky");
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Sebastian\\IdeaProjects\\ReakcnaDoba\\src\\vysledky.txt"));
            String record = br.readLine();
            while(record!=null){
                records.add(record);
                record=br.readLine();

            }
            br.close();
            System.out.println(records.toString());
        }catch (IOException e){ System.out.println("Problem s citanim zo  subora");}



    }

    public void NewPlayer() {

        System.out.println("Zadajte svoje meno : ");
        player = sc.nextLine();
         while(player.equals("")){
             System.out.println("Meno nemoze byt prazdne!");
             player= sc.nextLine();

         }


    }

    public int Menu() {
        System.out.println("1 - Spusť hru\n" +
                "    2 - Zmena hráča\n" +
                "    3 - TOP 10\n" +
                "    4 - Koniec");

        while (true) {
            int input = sc.nextInt();
            if (input < 5 && input > 0) {

                return input;
            } else System.out.println("Vyberte si z menu moznost 1-4.");
        }

    }

    public long Play(String who) throws InterruptedException {
        long finalTime=0;
        System.out.println("Pripraveny ? Stlac ENTER!!!");
        if (enterPressed()) {
            System.out.println("POZOOOOR! ");
            long time = (int) (Math.random() * 2500 + 500);
            long curTime = System.currentTimeMillis();
            while (System.currentTimeMillis() <= curTime + time) {


            }
            System.out.println("START!");
            long start = System.currentTimeMillis();
            if (enterPressed()) {
                if (System.currentTimeMillis() - start < 2) {
                    System.out.println("podvzdzal si");
                } else {
                    finalTime = (System.currentTimeMillis() - start);
                    System.out.println(finalTime);
                }
            }
        }
        return finalTime;
    }

    public void Sort(String who, long record) {
    }

    public void ShowRecords(String who, long record) {
    }

    public void SaveRecords(String player,long time) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Sebastian\\IdeaProjects\\ReakcnaDoba\\src\\vysledky.txt"));
            bw.newLine();
            bw.write(player +"-"+ time);
            System.out.println("zapisujem do tabulky "+player+" "+time);
            bw.close();
        }catch (IOException e){
            System.out.println("Problem so zapisovanim do subora");
        }
    }


    private boolean enterPressed() {


        String enter = sc.nextLine();
        while (!enter.equals("")) {
            enter = sc.nextLine();

        }
        return true;
    }
}
