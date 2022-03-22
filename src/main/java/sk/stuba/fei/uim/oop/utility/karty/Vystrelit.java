package sk.stuba.fei.uim.oop.utility.karty;

import sk.stuba.fei.uim.oop.utility.hra.Hrac;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;
import sk.stuba.fei.uim.oop.utility.karty.rybnik.Kacka;
import sk.stuba.fei.uim.oop.utility.karty.rybnik.Voda;

import java.util.ArrayList;

public class Vystrelit extends Karta {
    @Override
    public void zahrajKartu(ArrayList<Zameriavac> zameriavace, ArrayList<Karta> rybnik, Hrac[] hraci, ArrayList<Karta> balikRybnik) {
        int indexZameriavaca;
        do {
            indexZameriavaca = ZKlavesnice.readInt("Zvoľ zamierený zameriavač (číslo od 0 po 5): ");
            if(indexZameriavaca< 0 || indexZameriavaca > 6){
                System.out.println("Kto ťa učil čítať? Zadal si zlý index! Máš zadať číslo od 0 po 5 😒!");
            }
            if( zameriavace.get(indexZameriavaca).ziskajJeZamerany()){
                System.out.println("Zameriavač, ktorý si zvolil ešte nie je zameraný, prosím zvoľ nový. 😊");
            }
        } while ((indexZameriavaca < 0 || indexZameriavaca > 6) ||  !zameriavace.get(indexZameriavaca).ziskajJeZamerany());

        if(rybnik.get(indexZameriavaca) instanceof Voda){
            rybnik.get(indexZameriavaca).zahrajKartu(zameriavace,rybnik,hraci, balikRybnik);
        }
        else{
            int indexHraca = ((Kacka)rybnik.get(indexZameriavaca)).getIndexHraca();
            rybnik.get(indexZameriavaca).zahrajKartu(zameriavace,rybnik,hraci, balikRybnik);
            hraci[indexHraca].setZivoty();
            rybnik.remove(indexZameriavaca);
            rybnik.add(balikRybnik.get(0));
            balikRybnik.remove(0);
        }
        zameriavace.get(indexZameriavaca).nastavJeZamerany(false);

    }
}
