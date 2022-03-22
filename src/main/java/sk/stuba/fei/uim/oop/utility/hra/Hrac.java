package sk.stuba.fei.uim.oop.utility.hra;

import sk.stuba.fei.uim.oop.utility.karty.Karta;
import sk.stuba.fei.uim.oop.utility.karty.Zameriavac;
import sk.stuba.fei.uim.oop.utility.karty.Zamieriť;

import java.util.ArrayList;

public class Hrac {
    private final String  meno;
    private int zivoty;
    private ArrayList<Karta> kartyNaRuke;

    public String getMeno() {
        return meno;
    }

    public Hrac(String meno) {
        this.meno = meno;
        this.zivoty =5;
        this.kartyNaRuke= new ArrayList<Karta>();
    }
    public ArrayList<Karta> getKartyNaRuke(){
        return this.kartyNaRuke;
    }

    public void setKartyNaRuke(Karta karta) {
        this.kartyNaRuke.add(karta);
    }

    public void odstranKartu(Karta karta){ this.kartyNaRuke.remove(karta);}

    public int getZivoty(){
        return this.zivoty;
    }

    public void setZivoty() {
        this.zivoty -= 1;
    }

}
