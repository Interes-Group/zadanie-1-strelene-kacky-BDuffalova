package sk.stuba.fei.uim.oop.utility.karty;

import sk.stuba.fei.uim.oop.utility.hra.Hrac;

import java.util.ArrayList;

public abstract class Karta {
    private final String nazovKarty;

    protected Karta(String nazovKarty) {
        this.nazovKarty = nazovKarty;
    }

    public String getNazovKarty() {
        return nazovKarty;
    }

    public abstract void zahrajKartu(ArrayList<Zameriavac> zameriavace, ArrayList<Karta> rybnik, Hrac[] hraci, ArrayList<Karta> balikRybnik);
}
