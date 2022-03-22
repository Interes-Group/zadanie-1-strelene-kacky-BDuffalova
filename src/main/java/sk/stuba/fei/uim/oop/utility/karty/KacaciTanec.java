package sk.stuba.fei.uim.oop.utility.karty;

import sk.stuba.fei.uim.oop.utility.hra.Hrac;

import java.util.ArrayList;
import java.util.Collections;

public class KacaciTanec extends Karta {

    public KacaciTanec(String nazovKarty) {
        super(nazovKarty);
    }

    @Override
    public void zahrajKartu(ArrayList<Zameriavac> zameriavace, ArrayList<Karta> rybnik, Hrac[] hraci, ArrayList<Karta> balikRybnik) {
        balikRybnik.addAll(rybnik);
        ArrayList<Karta> tempRybnik;
        tempRybnik=rybnik;
        rybnik.removeAll(tempRybnik);
        Collections.shuffle(balikRybnik);
        for(int i = 0;i<6;i++){
            rybnik.add(balikRybnik.get(0));
            balikRybnik.remove(0);
        }
    }
}
