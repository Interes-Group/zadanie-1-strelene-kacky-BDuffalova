package sk.stuba.fei.uim.oop.utility;

import java.util.ArrayList;

public class Zamieriť extends Karta{
    private boolean jeZamerany;

    public Zamieriť() {
        this.jeZamerany = false;
    }

    public boolean getJeZamerany() {
        return jeZamerany;
    }

    public void setJeZamerany(boolean jeZamerany) {
        this.jeZamerany = jeZamerany;
    }

    @Override
    public void zahrajKartu(ArrayList<Karta> kartyZameriavac) {

        int indexZameriavaca = ZKlavesnice.readInt("Zvoľ zameriavač: ");
        ((Zamieriť)kartyZameriavac.get(indexZameriavaca)).setJeZamerany(true);

    }
    public boolean jeMozneHrat(ArrayList<Karta> kartyZameriavac, ArrayList<Karta> kartyNaRuke){
        int pocetZamierenych = 0;
        int pocetZameriavacovNaRuke = 0;
        for(Karta karta : kartyZameriavac){
            if(karta instanceof Zamieriť && ((Zamieriť) karta).getJeZamerany()){
                pocetZamierenych++;
            }
        }
        for(Karta mojeKarty : kartyNaRuke){
            if(mojeKarty instanceof Zamieriť){
                pocetZameriavacovNaRuke++;
            }
        }
        return pocetZamierenych != 6 || pocetZameriavacovNaRuke != 3;
    }


}
