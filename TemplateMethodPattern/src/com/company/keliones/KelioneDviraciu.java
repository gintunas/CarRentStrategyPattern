package com.company.keliones;

import com.company.kainosSkaiciavimas.Ikainiai;
import com.company.kainosSkaiciavimas.IkainiaiBuilder;

public abstract class KelioneDviraciu extends Kelione {
    private int priemoneId;

    public KelioneDviraciu(int priemoneId, String isvykimoTaskas) throws UnsupportedOperationException {
        super(priemoneId, isvykimoTaskas);

        transportoPriemonesPavadinimas = pasirinktiTransportoPriemone(priemoneId);
        if (transportoPriemonesPavadinimas.isEmpty())
            throw new UnsupportedOperationException("Nepavyko pasirinkti transporto priemones.");

        ikainiai = gautiTransportoPriemonesIkainius();
    }

    @Override
    public String pasirinktiTransportoPriemone(int priemoneId) {
        //if(priemoneID nepasirinktas) pasirinkti
        this.priemoneId = priemoneId;
        return "Rambynas 300";
        //else return null;
    }

    @Override
    public Ikainiai gautiTransportoPriemonesIkainius() {
        return new IkainiaiBuilder()
                .setPradineKaina(10)
                .setKilometroKaina(0)
                .setMinutesKaina(0)
                .setVirsytoLaikoKaina(20)
                .setVirsytoAtstumoKaina(0)
                .setParosKaina(300)
                .setSavaitesKaina(1500)
                .setMenesioKaina(3000)
                .createIkainiai();
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