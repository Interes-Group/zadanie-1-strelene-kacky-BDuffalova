package sk.stuba.fei.uim.oop.utility.karty;

import sk.stuba.fei.uim.oop.utility.hra.Hrac;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Zamieriť extends Karta {

    public Zamieriť(String nazovKarty) {
        super(nazovKarty);
    }

    @Override
    public void zahrajKartu(ArrayList<Zameriavac> zameriavace, ArrayList<Karta> rybnik, Hrac[] hraci, ArrayList<Karta> balikRybnik) {
        int indexZameriavaca;
        do {
            indexZameriavaca = ZKlavesnice.readInt("Zvoľ nezameraný zameriavač (číslo od 0 - 5): ");
            if(indexZameriavaca< 0 || indexZameriavaca > 6){
                System.out.println("Kto ťa učil čítať? Zadal si zlý index! Máš zadať číslo od 0 po 5 😒!");
            }
            else if( zameriavace.get(indexZameriavaca).ziskajJeZamerany()){
                System.out.println("Zameriavač, ktorý si zvolil už je zameraný, prosím zvoľ nový. 😊");
            }
        } while ((indexZameriavaca < 0 || indexZameriavaca > 6) ||  zameriavace.get(indexZameriavaca).ziskajJeZamerany());

         zameriavace.get(indexZameriavaca).nastavJeZamerany(true);

    }

}
