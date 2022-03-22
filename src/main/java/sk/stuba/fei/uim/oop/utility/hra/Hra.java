package sk.stuba.fei.uim.oop.utility.hra;

import sk.stuba.fei.uim.oop.utility.ZKlavesnice;
import sk.stuba.fei.uim.oop.utility.karty.*;
import sk.stuba.fei.uim.oop.utility.karty.rybnik.Kacka;
import sk.stuba.fei.uim.oop.utility.karty.rybnik.Voda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Hra {
    private final Hrac[] hraci;
    private final int pocetHracov;
    private ArrayList<Zameriavac> poleZameriavacov;
    private ArrayList<Karta> rybnik;
    private int aktualnyHrac;
    private ArrayList<Karta> balikHra;
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
        Collections.shuffle(this.balikHra);
        rozdajKarty(this.hraci,this.balikHra);
        this.vytvorBalikRybnik(hraci);
        Collections.shuffle(this.balikRybnik);
        this.vytvorPoleZameriavacov();
        this.aktualnyHrac = 0;
        this.vytvorRybnik();
        this.zacniHru();

    }
    private void vytvorPoleZameriavacov(){
        this.poleZameriavacov = new ArrayList<>();
        for(int i = 0; i < 6;i++){
            this.poleZameriavacov.add(new Zameriavac());
        }
    }
    private void vytvorRybnik(){
        this.rybnik=new ArrayList<>();
        for(int i = 0;i<6;i++){
            this.rybnik.add(this.balikRybnik.get(0));
            this.balikRybnik.remove(0);
        }
    }
    private void vytvorBalikHra(){
        int i;
        this.balikHra = new ArrayList<>();
        for(i = 0; i<10;i++){
            this.balikHra.add(new Zamieriť("Zamieriť"));
        }
        for(i = 0; i<12; i++){
            this.balikHra.add(new Vystrelit("Vystreliť"));
        }
        for(i = 0; i<2; i++){
            this.balikHra.add(new DivokyBill("Divoký Bill"));
        }
        for(i = 0; i<6; i++){
            this.balikHra.add(new KacaciPochod("Kačací pochod"));
        }
        this.balikHra.add(new TurboKacka("Turbokačka"));
        for(i = 0; i<2; i++){
            this.balikHra.add(new Rosambo("Rošambo"));
        }
        this.balikHra.add(new KacaciTanec("Kačací tanec"));

    }
    private void rozdajKarty(Hrac[] hraci, ArrayList<Karta> balikHra){
        for(Hrac hrac : hraci){
            for(int i = 0; i<3;i++) {
                hrac.nastavKartyNaRuke(balikHra.get(0));
                balikHra.remove(0);
            }
        }

    }
    private void vytvorBalikRybnik(Hrac[] hraci){
        this.balikRybnik = new ArrayList<>();
        for (int i = 0;i<pocetHracov;i++){
            for(int j = 0; j<5;j++){
                this.balikRybnik.add(new Kacka(i,hraci[i].ziskajMeno(),"Kačka"));
            }
        }
        for(int k = 0;k<5;k++){
            this.balikRybnik.add(new Voda("Voda"));
        }
    }
    private boolean Vitaz(){
        int pocetAktivnychHracov = 0;
        for(Hrac hrac : this.hraci){
            if(hrac.ziskajZivoty()>0){
                pocetAktivnychHracov++;
            }
        }
        return pocetAktivnychHracov == 1;
    }
    private ArrayList<Karta> vratHratelneKarty(Hrac hrac){
        ArrayList<Karta> hratelneKarty = new ArrayList<>();
        int pocetZamierenych = 0;
        for(Zameriavac zameriavac : this.poleZameriavacov){
            if(zameriavac.ziskajJeZamerany()){
                pocetZamierenych++;
            }
        }
        for(Karta karta : hrac.ziskajKartyNaRuke()){
            if(karta instanceof Zamieriť){
                if(pocetZamierenych<6){
                    hratelneKarty.add(karta);
                }
            }
            if(karta instanceof Vystrelit){
                if(pocetZamierenych>0){
                    hratelneKarty.add(karta);
                }
            }
            if(!(karta instanceof Vystrelit)&&!(karta instanceof Zamieriť)){
                hratelneKarty.add(karta);
            }
        }
        return hratelneKarty;
    }
    private void vypisKarty(ArrayList<Karta> mojeKarty){
        for(int i = 0; i< mojeKarty.size();i++){
            System.out.println(i + " - " + mojeKarty.get(i).ziskajNazovKarty());
        }
    }
    private void vypisHraciePole(){
        for(int i = 0; i < 6 ; i++){
            if (this.poleZameriavacov.get(i).ziskajJeZamerany()) {
                if(this.rybnik.get(i) instanceof Kacka){
                    System.out.println(i + "✅ Zamerané - 🦆 Kačka Hráča " + ((Kacka) this.rybnik.get(i)).ziskajMenoHraca());
                }
                else{
                    System.out.println(i + "✅ Zamerané - 🌊 Voda");
                }
            }
            else{
                if(this.rybnik.get(i) instanceof Kacka){
                    System.out.println(i + "❎ Nezamerané - 🦆 Kačka Hráča " + ((Kacka) this.rybnik.get(i)).ziskajMenoHraca());
                }
                else{
                    System.out.println(i + "❎ Nezamerané - 🌊 Voda");
                }

            }
        }
    }
    private void vypisVitaza(){
        for(Hrac hrac : this.hraci){
            if(hrac.ziskajZivoty()>0){
                System.out.println("Vyhral hráč " + hrac.ziskajMeno() + "!");
            }
        }
    }

    private void zacniHru()
    {
        System.out.println("Hra sa začína! Držte si kačice! 😁");
        ArrayList<Karta> hratelneKarty;
        while(!Vitaz()) {
            System.out.println("Na rade je hráč " + hraci[aktualnyHrac].ziskajMeno());
            hratelneKarty = vratHratelneKarty(hraci[aktualnyHrac]);
            this.vypisHraciePole();
            int indexKarty;
            if(hraci[aktualnyHrac].ziskajZivoty()>0) {
                if (hratelneKarty.size() > 0) {
                    System.out.println("");
                    System.out.println("Tu sú tvoje karty, ktoré môžeš použiť: ");
                    vypisKarty(hratelneKarty);
                    do {
                        indexKarty = ZKlavesnice.readInt("Zvoľ si kartu ktorú chceš použiť (číslo od 0 po " + (hratelneKarty.size() - 1) + ")");
                        if (indexKarty < 0 || indexKarty > hratelneKarty.size()) {
                            System.out.println("Snžíš sa zvoliť neexistujúcu kartu!");
                        }
                    } while (indexKarty < 0 || indexKarty > hratelneKarty.size());
                    hratelneKarty.get(indexKarty).zahrajKartu(this.poleZameriavacov, this.rybnik, this.hraci, this.balikRybnik);
                    this.balikHra.add(hratelneKarty.get(indexKarty));
                    hraci[aktualnyHrac].odstranKartu(hratelneKarty.get(indexKarty));
                    hraci[aktualnyHrac].nastavKartyNaRuke(this.balikHra.get(0));
                    this.balikHra.remove(0);
                } else {
                    System.out.println("Bohužial, nie je možné zahrať žiadnu kartu.");
                    vypisKarty(hraci[aktualnyHrac].ziskajKartyNaRuke());
                    do {
                        indexKarty = ZKlavesnice.readInt("Zvoľ si kartu ktorú chceš vyhodiť (číslo od 0 po 2)");
                        if (indexKarty < 0 || indexKarty > 3) {
                            System.out.println("Snžíš sa zvoliť neexistujúcu kartu!");
                        }
                    } while (indexKarty < 0 || indexKarty > 2);
                    this.balikHra.add(hraci[aktualnyHrac].ziskajKartyNaRuke().get(indexKarty));
                    hraci[aktualnyHrac].odstranKartu(hraci[aktualnyHrac].ziskajKartyNaRuke().get(indexKarty));
                    hraci[aktualnyHrac].nastavKartyNaRuke(this.balikHra.get(0));
                    this.balikHra.remove(0);
                }
            }
            if(aktualnyHrac ==pocetHracov-1){
                aktualnyHrac =0;
            }
            else{
                aktualnyHrac++;
            }
            hratelneKarty.clear();
        }
        vypisVitaza();
    }

}
