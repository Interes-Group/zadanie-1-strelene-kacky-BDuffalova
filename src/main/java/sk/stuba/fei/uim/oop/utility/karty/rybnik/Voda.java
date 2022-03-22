package sk.stuba.fei.uim.oop.utility.karty.rybnik;

import sk.stuba.fei.uim.oop.utility.hra.Hrac;
import sk.stuba.fei.uim.oop.utility.karty.Karta;
import sk.stuba.fei.uim.oop.utility.karty.Zameriavac;

import java.util.ArrayList;

public class Voda extends Karta {
    @Override
    public void zahrajKartu(ArrayList<Zameriavac> zameriavace, ArrayList<Karta> rybnik, Hrac[] hraci, ArrayList<Karta> balikRybnik) {
        System.out.println("Trafil si vodu!");
    }

}
