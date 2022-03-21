package sk.stuba.fei.uim.oop.utility;

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
    public int getZivoty(){
        return this.zivoty;
    }

    public void setZivoty() {
        this.zivoty -= 1;
    }

    public boolean jeMozneHrat(ArrayList<Karta> kartyZameriavac, ArrayList<Karta> kartyNaRuke){
        int pocetZamierenych = 0;
        int pocetZameriavacovNaRuke = 0;
        for(Karta karta : kartyZameriavac){
            if(karta instanceof Zamieriť && ((Zamieriť) karta).ziskajJeZamerany()){
                pocetZamierenych++;
            }
        }
        for(Karta mojeKarty : kartyNaRuke){
            if(mojeKarty instanceof Zamieriť){
                pocetZameriavacovNaRuke++;
            }
        }
        return pocetZamierenych != 6 || pocetZameriavacovNaRuke != 3;
    }
}
