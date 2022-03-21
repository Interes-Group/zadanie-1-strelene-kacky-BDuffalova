package sk.stuba.fei.uim.oop.utility;

import java.util.ArrayList;

public class Zamieriť extends Karta{
    private boolean jeZamerany;

    public Zamieriť() {
        this.jeZamerany = false;
    }

    public boolean ziskajJeZamerany() {
        return jeZamerany;
    }

    public void nastavJeZamerany(boolean jeZamerany) {
        this.jeZamerany = jeZamerany;
    }

    @Override
    public void zahrajKartu(ArrayList<Karta> zameriavace, ArrayList<Karta> rybnik, Hrac[] hraci) {

        int indexZameriavaca = ZKlavesnice.readInt("Zvoľ nezameraný zameriavač (číslo od 0 - 5): ");
        ((Zamieriť) zameriavace.get(indexZameriavaca)).nastavJeZamerany(true);

    }

}
