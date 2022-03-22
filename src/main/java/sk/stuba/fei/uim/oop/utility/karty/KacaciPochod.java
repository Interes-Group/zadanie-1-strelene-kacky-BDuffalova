package sk.stuba.fei.uim.oop.utility.karty;

import sk.stuba.fei.uim.oop.utility.hra.Hrac;
import java.util.ArrayList;

public class KacaciPochod extends Karta {


    public KacaciPochod(String nazovKarty) {
        super(nazovKarty);
    }

    @Override
    public void zahrajKartu(ArrayList<Zameriavac> zameriavace, ArrayList<Karta> rybnik, Hrac[] hraci, ArrayList<Karta> balikRybnik) {
        Karta tempKacka = rybnik.get(0);
        rybnik.remove(0);
        rybnik.add(balikRybnik.get(0));
        balikRybnik.remove(0);
        balikRybnik.add(tempKacka);
    }
}
