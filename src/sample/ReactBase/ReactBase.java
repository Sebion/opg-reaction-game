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

import sample.Player;

import java.io.*;
import java.lang.management.BufferPoolMXBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReactBase {
    final int CM_PLAY = 1;
    final int CM_CHANGE_PLAYER = 2;
    final int CM_TOP10 = 3;
    final int CM_QUIT = 4;

    private Scanner sc;
    private ArrayList<Player> records;
    private Player player;


    public static void main(String[] args) throws InterruptedException {
        boolean gameOn;
        ReactBase reactBase = new ReactBase();
        do {
            gameOn = reactBase.Run();
        } while (gameOn);
    }

    public ReactBase() {
        records = new ArrayList<>();
        sc = new Scanner(System.in);
        player = new Player();
        player.setName("Default");
        ImportRecords();
        Sort();
        NewPlayer();

    }

    public boolean Run() throws InterruptedException {
        switch (Menu()) {
            case CM_PLAY:
                Play();
                ShowRecords();
                SaveRecords();
                return true;
            case CM_CHANGE_PLAYER:
                NewPlayer();
                return true;

            case CM_TOP10:
                ShowTop10();
                return true;
            case CM_QUIT:
                sc.close();
                return false;

        }
        return true;
    }

    public int findIndex(){
        int index=0;

        for (int i = 0; i < records.size(); i++) {
            if(records.get(i).getHighScore()>player.getHighScore()){
                index=i;

                break;
            }else if(player.getHighScore()>records.get(records.size()-1).getHighScore()){

                index=records.size();

            }
        }


        return index;
    }

    private void ShowRecords() {
        ImportRecords();
        Sort();
        System.out.println("index je "+ findIndex());
        if (player.getHighScore()!=0) {
            int index = findIndex();
            int detract = 5;
            int plus = 5;

            if (index < 5) {
                detract =  index;
            }

            for (int i = index - detract; i < index; i++) {

                System.out.println(i+1+". " + records.get(i).getName() + " " + records.get(i).getHighScore());

            }
            if (index > records.size() - 5) {
                plus=records.size()-index;
            }
            System.out.println("***************");
            System.out.println(index+1+ ". " + player.getName() + " " + player.getHighScore());
            System.out.println("***************");
            for (int i = index; i < index + plus; i++) {

                System.out.println(i +2 + ". " + records.get(i).getName() + " " + records.get(i).getHighScore());
            }
        }


    }

    public void ImportRecords() {

        records.clear();
        System.out.println("nacitavam z tabulky");
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Sebastián\\IdeaProjects\\ReactBase\\opg-reaction-game\\src\\sample\\ReactBase\\vysledky.txt"));
            String record = br.readLine();
            while (record != null) {
                String []split = record.split(" ");
                records.add(new Player(split[0],Float.parseFloat(split[1])));
                record = br.readLine();

            }
            br.close();
            System.out.println(records.toString());
        } catch (IOException e) {
            System.out.println("Problem s citanim zo  subora");
        }


    }

    public void NewPlayer() {

        System.out.println("Zadajte svoje meno : ");
        player.setName(sc.nextLine());
        while (player.getName().equals("")) {
            System.out.println("Meno nemoze byt prazdne!");
            player.setName(sc.nextLine());

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

    public void Play() throws InterruptedException {
        long finalTime = 0;
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
                    player.setHighScore(0);
                } else {
                    finalTime = (System.currentTimeMillis() - start);
                    player.setHighScore(finalTime);
                    System.out.println(finalTime);
                }
            }
        }

    }

    public void Sort() {

        Collections.sort(records);
    }

    public void ShowTop10() {
        ImportRecords();
        Sort();
        for (int i = 0; i < 10; i++) {
            System.out.println(i+1+"."+" "+records.get(i).getName()+" "+records.get(i).getHighScore());
        }

    }

    public void SaveRecords() {
        try {
           if (player.getHighScore()!=0){
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Sebastián\\IdeaProjects\\ReactBase\\opg-reaction-game\\src\\sample\\ReactBase\\vysledky.txt", true));
            bw.newLine();
            bw.write(player.getName() + " " + player.getHighScore());
            System.out.println("zapisujem do tabulky " + player.getName() + " " + player.getHighScore());
            bw.close();
           }
        } catch (IOException e) {
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
