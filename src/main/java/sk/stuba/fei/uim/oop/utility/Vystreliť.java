package sk.stuba.fei.uim.oop.utility;

import java.util.ArrayList;

public class Vystreliť extends Karta{
    @Override
    public void zahrajKartu(ArrayList<Karta> zameriavace, ArrayList<Karta> rybnik, Hrac[] hraci) {
        int indexZameriavaca = ZKlavesnice.readInt("Zvoľ zameraný zameriavač (číslo od 0 - 5): ");
        if(rybnik.get(indexZameriavaca) instanceof Voda){
            System.out.println("Trafil si vodu!");
        }
        else{
            int indexHraca = ((Kacka)rybnik.get(indexZameriavaca)).getIndexHraca();
            System.out.println("Zabil si kačku hráča " + indexHraca + "!");
            hraci[indexHraca].setZivoty();
            rybnik.remove(indexZameriavaca);
        }
        ((Zamieriť) zameriavace.get(indexZameriavaca)).nastavJeZamerany(false);

    }
}
