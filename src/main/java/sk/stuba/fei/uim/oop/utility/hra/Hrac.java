package sk.stuba.fei.uim.oop.utility.hra;

import sk.stuba.fei.uim.oop.utility.karty.Karta;

import java.util.ArrayList;

public class Hrac {
    private final String  meno;
    private int zivoty;
    private ArrayList<Karta> kartyNaRuke;

    public String ziskajMeno() {
        return meno;
    }

    public Hrac(String meno) {
        this.meno = meno;
        this.zivoty =5;
        this.kartyNaRuke= new ArrayList<Karta>();
    }
    public ArrayList<Karta> ziskajKartyNaRuke(){
        return this.kartyNaRuke;
    }

    public void nastavKartyNaRuke(Karta karta) {
        this.kartyNaRuke.add(karta);
    }

    public void odstranKartu(Karta karta){ this.kartyNaRuke.remove(karta);}

    public int ziskajZivoty(){
        return this.zivoty;
    }

    public void nastavZivoty() {
        this.zivoty -= 1;
    }

}
