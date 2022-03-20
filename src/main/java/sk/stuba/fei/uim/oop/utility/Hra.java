package sk.stuba.fei.uim.oop.utility;

import java.util.ArrayList;

public class Hra {
    private final Hráč[] hraci;
    private final int pocetHracov;
    private Zameriavač[] poleZameriavacov;
    private ArrayList<Karta> rybník;
    //private int aktuálnyHráč;
    private ArrayList<Karta> balíkHra;
    private ArrayList<Karta> balikRybník;

    public Hra(){
        System.out.println("Vitajte pri hre Strelené kačky");
        int pocetHracov = ZKlavesnice.readInt("Zvoľte 2-6 hráčov: ");
        this.pocetHracov = pocetHracov;
        //this.vytvorBalíkHra();
        this.vytvorBalikRybnik();
        this.hraci = new Hráč[pocetHracov];
        for (int i = 0; i<pocetHracov;i++){
            this.hraci[i]=new Hráč(ZKlavesnice.readString("Zadaj meno hráča" + (i+1)));
        }
        this.vytvorPoleZameriavacov();
        //this.vytvorRybník();

    }
    private void vytvorPoleZameriavacov(){
        this.poleZameriavacov = new Zameriavač[6];
    }
    private void vytvorRybnik(){

    }
    private void vytvorBalikHra(){
        this.balíkHra = new ArrayList<Karta>();

    }
    private void rozdajKarty(Hráč[] hraci){

    }
    private void vytvorBalikRybnik(){
        this.balikRybník = new ArrayList<Karta>();
        for (int i = 0;i<pocetHracov;i++){
            for(int j = 0; j<5;j++){
                this.balikRybník.add(new Kacka(i));
            }
        }
        for(int k = 0;k<5;k++){
            this.balikRybník.add(new Voda());
        }
    }
    private void zacniHru()
    {

    }
}
