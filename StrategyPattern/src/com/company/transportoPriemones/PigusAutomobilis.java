package com.company.transportoPriemones;

import com.company.kainosSkaiciavimas.Ikainiai;
import com.company.kainosSkaiciavimas.IkainiaiBuilder;
import com.company.strategijos.TransportoPasirinkimoStrategija;

public class PigusAutomobilis implements TransportoPasirinkimoStrategija {
    private int priemoneId;

    @Override
    public String pasirinktiTransportoPriemone(int priemoneId) {
        //if(priemoneID nepasirinktas) pasirinkti
        this.priemoneId = priemoneId;
        return "Honda Civic 5 gen.";
        //else return null;
    }

    @Override
    public Ikainiai gautiTransportoPriemonesIkainius() {
        return new IkainiaiBuilder()
                .setPradineKaina(100)
                .setKilometroKaina(30)
                .setMinutesKaina(14)
                .setVirsytoLaikoKaina(6)
                .setVirsytoAtstumoKaina(5)
                .setParosKaina(1500)
                .setSavaitesKaina(7500)
                .setMenesioKaina(30000)
                .createIkainiai();
    }

    @Override
    public void paliktiTransportoPriemone() {
        //palikti priemoneId
        System.out.println("Paliktas Honda Civic, id: " + priemoneId);
    }

    @Override
    public void pranestiApieNetiketuma() {
        System.out.println("Dekojame uz pranesta Honda Civic, id: " + priemoneId + " apgadinima.");
    }
}
