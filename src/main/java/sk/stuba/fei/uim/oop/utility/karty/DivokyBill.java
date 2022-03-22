package sk.stuba.fei.uim.oop.utility.karty;

import sk.stuba.fei.uim.oop.utility.ZKlavesnice;
import sk.stuba.fei.uim.oop.utility.hra.Hrac;
import sk.stuba.fei.uim.oop.utility.karty.rybnik.Kacka;
import sk.stuba.fei.uim.oop.utility.karty.rybnik.Voda;

import java.util.ArrayList;

public class DivokyBill extends Karta {


    public DivokyBill(String nazovKarty) {
        super(nazovKarty);
    }

    @Override
    public void zahrajKartu(ArrayList<Zameriavac> zameriavace, ArrayList<Karta> rybnik, Hrac[] hraci, ArrayList<Karta> balikRybnik) {
        int indexZameriavaca;
        do {
            indexZameriavaca = ZKlavesnice.readInt("Zvoľ ľubovolný zameriavač (číslo od 0 po 5): ");
            if(indexZameriavaca< 0 || indexZameriavaca >= 6){
                System.out.println("Kto ťa učil čítať? Zadal si zlý index! Máš zadať číslo od 0 po 5 😒!");
            }
        } while (indexZameriavaca < 0 || indexZameriavaca >= 6);
        if(rybnik.get(indexZameriavaca) instanceof Voda){
            rybnik.get(indexZameriavaca).zahrajKartu(zameriavace,rybnik,hraci, balikRybnik);
        }
        else{
            int indexHraca = ((Kacka)rybnik.get(indexZameriavaca)).ziskajIndexHraca();
            rybnik.get(indexZameriavaca).zahrajKartu(zameriavace,rybnik,hraci, balikRybnik);
            hraci[indexHraca].nastavZivoty();
            rybnik.remove(indexZameriavaca);
            rybnik.add(balikRybnik.get(0));
            balikRybnik.remove(0);
            if(hraci[indexHraca].ziskajZivoty()==0){
                System.out.println("Zabil si hráča " + hraci[indexHraca].ziskajMeno());
            }
        }
        zameriavace.get(indexZameriavaca).nastavJeZamerany(false);

    }
}
