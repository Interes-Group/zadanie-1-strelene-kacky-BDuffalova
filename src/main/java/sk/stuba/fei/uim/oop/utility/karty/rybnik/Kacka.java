package sk.stuba.fei.uim.oop.utility.karty.rybnik;

import sk.stuba.fei.uim.oop.utility.hra.Hrac;
import sk.stuba.fei.uim.oop.utility.karty.Karta;
import sk.stuba.fei.uim.oop.utility.karty.Zameriavac;

import java.util.ArrayList;

public class Kacka extends Karta {
    private int indexHraca;
    private String menoHraca;

    public Kacka(int indexHraca,String menoHraca){
        this.indexHraca=indexHraca;
        this.menoHraca=menoHraca;
    }

    public int getIndexHraca() {
        return indexHraca;
    }

    public String getMenoHraca() {
        return menoHraca;
    }

    public void setIndexHraca(int indexHraca) {
        this.indexHraca = indexHraca;
    }

    @Override
    public void zahrajKartu(ArrayList<Zameriavac> zameriavace, ArrayList<Karta> rybnik, Hrac[] hraci, ArrayList<Karta> balikRybnik) {
        System.out.println("Zabil si kačku hráča " + getMenoHraca() + "!");
    }


}
