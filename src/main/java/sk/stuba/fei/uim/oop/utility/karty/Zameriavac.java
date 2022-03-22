package sk.stuba.fei.uim.oop.utility.karty;

import sk.stuba.fei.uim.oop.utility.hra.Hrac;

import java.util.ArrayList;

public class Zameriavac{
    private boolean jeZamerany;

    public Zameriavac() {
        this.jeZamerany = false;
    }

    public boolean ziskajJeZamerany() {
        return jeZamerany;
    }

    public void nastavJeZamerany(boolean jeZamerany) {
        this.jeZamerany = jeZamerany;
    }

}
