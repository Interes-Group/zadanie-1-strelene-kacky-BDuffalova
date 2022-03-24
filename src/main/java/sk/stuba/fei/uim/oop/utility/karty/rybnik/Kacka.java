package sk.stuba.fei.uim.oop.utility.karty.rybnik;

import sk.stuba.fei.uim.oop.utility.hra.Hrac;
import sk.stuba.fei.uim.oop.utility.karty.Karta;
import sk.stuba.fei.uim.oop.utility.karty.Zameriavac;

import java.util.ArrayList;

public class Kacka extends Karta {
    private final int indexHraca;
    private final String menoHraca;


    public Kacka(int indexHraca,String menoHraca,String nazovKarty){
        super(nazovKarty);
        this.indexHraca=indexHraca;
        this.menoHraca=menoHraca;
    }

    public int ziskajIndexHraca() {
        return indexHraca;
    }

    public String ziskajMenoHraca() {
        return menoHraca;
    }

    @Override
    public void zahrajKartu(ArrayList<Zameriavac> zameriavace, ArrayList<Karta> rybnik, Hrac[] hraci, ArrayList<Karta> balikRybnik) {
        System.out.println("                                           \n" +
                "                                              ██████                                    \n" +
                "                                            ██      ██                                  \n" +
                "                                          ██          ██                                \n" +
                "                                          ██      X  ██                                \n" +
                "                                          ██        ░░░░██                              \n" +
                "                                            ██      ████                                \n" +
                "                              ██              ██  ██                                    \n" +
                "                            ██  ██        ████    ██                                    \n" +
                "                            ██    ████████          ██                                  \n" +
                "                            ██                        ██                                \n" +
                "                              ██              ██      ██                                \n" +
                "                               Zabil si kačku hráča " + ziskajMenoHraca() + "!\n" +
                "                              ██    ██      ██        ██                                \n" +
                "                                ██    ████████      ██                                  \n" +
                "                                ██                  ██                                  \n" +
                "                                  ████          ████                                    \n" +
                "                                      ██████████        ");
    }


}
