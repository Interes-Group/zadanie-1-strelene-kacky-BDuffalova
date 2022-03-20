package sk.stuba.fei.uim.oop.utility;

import java.util.ArrayList;

public class Hráč {
    private String  meno;
    private int životy;
    private ArrayList<Karta> kartyNaRuke;

    public String getMeno() {
        return meno;
    }

    public Hráč(String meno) {
        this.meno = meno;
        this.životy=5;
        //this.kartyNaRuke=;
    }
    public ArrayList<Karta> getKartyNaRuke(){
        return this.kartyNaRuke;
    }
    public int getŽivoty(){
        return this.životy;
    }

    public void setŽivoty(int životy) {
        this.životy -= 1;
    }
}
