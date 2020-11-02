package com.company.transportoPriemones;

import com.company.kainosSkaiciavimas.Ikainiai;
import com.company.kainosSkaiciavimas.IkainiaiBuilder;
import com.company.strategijos.TransportoPasirinkimoStrategija;

public class KelioneDviraciu implements TransportoPasirinkimoStrategija {
    private final int priemoneId;
    private final String transportoPriemonesPavadinimas = "Rambynas 300";
    private final Ikainiai ikainiai = new IkainiaiBuilder()
            .setPradineKaina(10)
            .setKilometroKaina(0)
            .setMinutesKaina(0)
            .setVirsytoLaikoKaina(20)
            .setVirsytoAtstumoKaina(0)
            .setParosKaina(300)
            .setSavaitesKaina(1500)
            .setMenesioKaina(3000)
            .createIkainiai();

    public KelioneDviraciu(int priemoneId) {
        this.priemoneId = priemoneId;
    }

    @Override
    public Ikainiai gautiIkainius() {
        return ikainiai;
    }

    @Override
    public String gautiTransportoPriemonesPavadinima() {
        return transportoPriemonesPavadinimas;
    }

    @Override
    public void paliktiTransportoPriemone() {
        //palikti priemoneId
        System.out.println("Paliktas Rambynas 300, id: " + priemoneId);
    }

    @Override
    public void pranestiApieNetiketuma() {
        System.out.println("Dekojame uz pranesta dviracio Rambynas 300, id: " + priemoneId + " apgadinima.");
    }
}