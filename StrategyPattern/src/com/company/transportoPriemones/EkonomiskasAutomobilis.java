package com.company.transportoPriemones;

import com.company.kainosSkaiciavimas.Ikainiai;
import com.company.kainosSkaiciavimas.IkainiaiBuilder;
import com.company.strategijos.TransportoPasirinkimoStrategija;

public class EkonomiskasAutomobilis implements TransportoPasirinkimoStrategija {
    private final int priemoneId;
    private final String transportoPriemonesPavadinimas = "Rambynas 300";
    private final Ikainiai ikainiai = new IkainiaiBuilder()
            .setPradineKaina(100)
            .setKilometroKaina(30)
            .setMinutesKaina(14)
            .setVirsytoLaikoKaina(6)
            .setVirsytoAtstumoKaina(5)
            .setParosKaina(1500)
            .setSavaitesKaina(7500)
            .setMenesioKaina(30000)
            .createIkainiai();

    public EkonomiskasAutomobilis(int priemoneId) {
        this.priemoneId = priemoneId;
    }

    @Override
    public Ikainiai gautiIkainius() {
        return ikainiai;
    }

    @Override
    public String gautiPavadinima() {
        return transportoPriemonesPavadinimas;
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
