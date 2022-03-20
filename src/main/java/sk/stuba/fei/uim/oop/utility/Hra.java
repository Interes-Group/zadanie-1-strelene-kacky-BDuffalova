package sk.stuba.fei.uim.oop.utility;

import java.util.ArrayList;

public class Hra {
    private final Hrac[] hraci;
    private final int pocetHracov;
    private ArrayList<Zamieriť> poleZameriavacov;
    private ArrayList<Karta> rybník;
    //private int aktuálnyHráč;
    private ArrayList<Karta> balíkHra;
    private ArrayList<Karta> balikRybník;

    public Hra(){
        System.out.println("Vitajte pri hre Strelené kačky");
        int pocetHracov = ZKlavesnice.readInt("Zvoľte 2-6 hráčov: ");
        this.pocetHracov = pocetHracov;
        this.vytvorBalikHra();
        this.vytvorBalikRybnik();
        this.hraci = new Hrac[pocetHracov];
        for (int i = 0; i<pocetHracov;i++){
            this.hraci[i]=new Hrac(ZKlavesnice.readString("Zadaj meno hráča " + (i+1)));
        }
        this.vytvorPoleZameriavacov();
        //this.vytvorRybník();

    }
    private void vytvorPoleZameriavacov(){
        this.poleZameriavacov = new ArrayList<Zamieriť>();
    }
    private void vytvorRybnik(){

    }
    private void vytvorBalikHra(){
        int i;
        this.balíkHra = new ArrayList<Karta>();
        for(i = 0; i<10;i++){
            this.balíkHra.add(new Zamieriť());
        }
        for(i = 0; i<12; i++){
            this.balíkHra.add(new Vystreliť());
        }
        for(i = 0; i<2; i++){
            this.balíkHra.add(new DivokyBill());
        }
        for(i = 0; i<6; i++){
            this.balíkHra.add(new KacaciPochod());
        }
        this.balíkHra.add(new TurboKačka());
        for(i = 0; i<2; i++){
            this.balíkHra.add(new Rosambo());
        }
        this.balíkHra.add(new KacaciTanec());

    }
    private void rozdajKarty(Hrac[] hraci){

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
