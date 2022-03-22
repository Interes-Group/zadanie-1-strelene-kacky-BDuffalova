package sk.stuba.fei.uim.oop.utility.hra;

import sk.stuba.fei.uim.oop.utility.ZKlavesnice;
import sk.stuba.fei.uim.oop.utility.karty.*;
import sk.stuba.fei.uim.oop.utility.karty.rybnik.Kacka;
import sk.stuba.fei.uim.oop.utility.karty.rybnik.Voda;

import java.util.ArrayList;
import java.util.Collections;

public class Hra {
    private final Hrac[] hraci;
    private final int pocetHracov;
    private ArrayList<Zameriavac> poleZameriavacov;
    private ArrayList<Karta> rybnik;
    private int aktuálnyHráč;
    private ArrayList<Karta> balíkHra;
    private ArrayList<Karta> balikRybnik;

    public Hra(){
        System.out.println("Vitajte pri hre Strelené kačky");
        int pocetHracov;
        do{
            pocetHracov = ZKlavesnice.readInt("Zvoľte 2-6 hráčov: ");
            if(pocetHracov<2||pocetHracov>6){
                System.out.println("Zadal si nepovolený počet hráčov!");
            }
        }while(pocetHracov<2||pocetHracov>6);
        this.pocetHracov = pocetHracov;
        this.hraci = new Hrac[pocetHracov];
        for (int i = 0; i<pocetHracov;i++){
            this.hraci[i]=new Hrac(ZKlavesnice.readString("Zadaj meno hráča " + (i+1)));
        }
        this.vytvorBalikHra();
        Collections.shuffle(this.balíkHra);
        this.vytvorBalikRybnik(hraci);
        Collections.shuffle(this.balikRybnik);
        this.vytvorPoleZameriavacov();
        this.aktuálnyHráč = 0;
        this.vytvorRybnik();

    }
    private void vytvorPoleZameriavacov(){
        this.poleZameriavacov = new ArrayList<Zameriavac>();
        for(int i = 0; i < 6;i++){
            this.poleZameriavacov.add(new Zameriavac());
        }
    }
    private void vytvorRybnik(){
        this.rybnik=new ArrayList<Karta>();
        for(int i = 0;i<6;i++){
            this.rybnik.add(this.balikRybnik.get(0));
            this.balikRybnik.remove(0);
        }
    }
    private void vytvorBalikHra(){
        int i;
        this.balíkHra = new ArrayList<Karta>();
        for(i = 0; i<10;i++){
            this.balíkHra.add(new Zamieriť());
        }
        for(i = 0; i<12; i++){
            this.balíkHra.add(new Vystrelit());
        }
        for(i = 0; i<2; i++){
            this.balíkHra.add(new DivokyBill());
        }
        for(i = 0; i<6; i++){
            this.balíkHra.add(new KacaciPochod());
        }
        this.balíkHra.add(new TurboKacka());
        for(i = 0; i<2; i++){
            this.balíkHra.add(new Rosambo());
        }
        this.balíkHra.add(new KacaciTanec());

    }
    private void rozdajKarty(Hrac[] hraci){

    }
    private void vytvorBalikRybnik(Hrac[] hraci){
        this.balikRybnik = new ArrayList<Karta>();
        for (int i = 0;i<pocetHracov;i++){
            for(int j = 0; j<5;j++){
                this.balikRybnik.add(new Kacka(i,hraci[i].getMeno()));
            }
        }
        for(int k = 0;k<5;k++){
            this.balikRybnik.add(new Voda());
        }
    }
    private void zacniHru()
    {

    }
}
