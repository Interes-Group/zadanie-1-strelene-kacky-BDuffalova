package sk.stuba.fei.uim.oop.utility.karty;

import sk.stuba.fei.uim.oop.utility.ZKlavesnice;
import sk.stuba.fei.uim.oop.utility.hra.Hrac;
import sk.stuba.fei.uim.oop.utility.karty.rybnik.Voda;

import java.util.ArrayList;

public class TurboKacka extends Karta {
    @Override
    public void zahrajKartu(ArrayList<Zameriavac> zameriavace, ArrayList<Karta> rybnik, Hrac[] hraci, ArrayList<Karta> balikRybnik) {
        int indexKacice;
        do {
            indexKacice = ZKlavesnice.readInt("Zvoľ Kačku, ktorá sa má predbehnúť (číslo od 0 po 5): ");
            if(indexKacice< 0 || indexKacice > 6){
                System.out.println("Kto ťa učil čítať? Zadal si zlý index! Máš zadať číslo od 0 po 5 😒!");
            }
            else {
                if(rybnik.get(indexKacice) instanceof Voda){
                    System.out.println("Zvolil si vodu! Zvoľ KAČKU!");
                }
            }
        } while ((indexKacice < 0 || indexKacice > 6)||rybnik.get(indexKacice) instanceof Voda);
        Karta tempKacka = rybnik.get(indexKacice);
        rybnik.remove(indexKacice);
        rybnik.add(0,tempKacka);
    }
}
