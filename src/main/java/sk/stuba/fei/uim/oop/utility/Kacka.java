package sk.stuba.fei.uim.oop.utility;

import java.util.ArrayList;

public class Kacka extends Karta{
    private int indexHraca;

    public Kacka(int indexHraca){
        this.indexHraca=indexHraca;
    }

    public int getIndexHraca() {
        return indexHraca;
    }

    public void setIndexHraca(int indexHraca) {
        this.indexHraca = indexHraca;
    }

    @Override
    public void zahrajKartu(ArrayList<Karta> karty) {

    }


}
