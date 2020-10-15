package com.company;

import com.company.enums.Intervalas;
import com.company.enums.KainosTipas;
import com.company.kainosSkaiciavimas.Ikainiai;
import com.company.kainosSkaiciavimas.KarantinoKainosSkaiciavimas;
import com.company.kainosSkaiciavimas.StandartinesKainosSkaiciavimas;
import com.company.strategijos.KainosSkaiciavimoStrategija;
import com.company.strategijos.TransportoPasirinkimoStrategija;
import com.company.transportoPriemones.Dviratis;
import com.company.transportoPriemones.PigusAutomobilis;
import com.company.transportoPriemones.PrabangusAutomobilis;

import java.math.BigDecimal;

public class Kelione {
    private final KainosSkaiciavimoStrategija kainosSkaiciavimas;
    private final TransportoPasirinkimoStrategija transportoPriemone;
    private final Ikainiai ikainiai;
    private final String isvykimoTaskas;
    private final int priemoneId;
    private final String transportoPriemonesPavadinimas;
    private String atvykimoTaskas;
    private double atstumas;
    private Double laikas;
    private BigDecimal kaina;
    private Intervalas ilgalaikisIntervalas;

    public Kelione(int priemoneId, String isvykimoTaskas, KainosTipas kainosTipas) throws IllegalArgumentException, UnsupportedOperationException {
        if (priemoneId < 10000) {
            transportoPriemone = new Dviratis();
        } else if (priemoneId < 20000) {
            transportoPriemone = new PigusAutomobilis();
        } else if (priemoneId < 30000) {
            transportoPriemone = new PrabangusAutomobilis();
        } else throw new IllegalArgumentException("Nera transporto priemones su tokiu identifikaciniu numeriu.");

        transportoPriemonesPavadinimas = transportoPriemone.pasirinktiTransportoPriemone(priemoneId);

        if (transportoPriemonesPavadinimas.isEmpty())
            throw new UnsupportedOperationException("Nepavyko pasirinkti transporto priemones.");

        ikainiai = transportoPriemone.gautiTransportoPriemonesIkainius();

        if (kainosTipas == KainosTipas.STANDARTINE) {
            kainosSkaiciavimas = new StandartinesKainosSkaiciavimas();
        } else if (kainosTipas == KainosTipas.KARANTINO) {
            kainosSkaiciavimas = new KarantinoKainosSkaiciavimas();
        } else throw new IllegalArgumentException("Nepavyko nustatyti kainos skaiciavio tipo.");

        this.priemoneId = priemoneId;
        this.isvykimoTaskas = isvykimoTaskas;
    }

    /**
     * @return Keliones kaina.
     */
    public BigDecimal uzbaigtiKelione(double atstumas, double laikas, String atvykimoTaskas) throws UnsupportedOperationException {
        if (atvykimoTaskas.isEmpty()) {
            throw new UnsupportedOperationException("Nenustatytas atvykimo taskas.");
        }
        BigDecimal sumineKaina = kainosSkaiciavimas.apskaiciuotiKelionesKaina(atstumas, laikas, ikainiai);
        sumineKaina = kainosSkaiciavimas.koreguotiSumineKaina(isvykimoTaskas, atvykimoTaskas, sumineKaina);
        transportoPriemone.paliktiTransportoPriemone();
        this.kaina = sumineKaina;
        this.atstumas = atstumas;
        this.laikas = laikas;
        this.atvykimoTaskas = atvykimoTaskas;
        return sumineKaina;
    }

    /**
     * @return Keliones kaina.
     */
    public BigDecimal uzbaigtiNuoma(double atstumas, Intervalas intervalas) throws UnsupportedOperationException{
        if (intervalas == null) {
            throw new UnsupportedOperationException("Nenustatytas nuomos intervalas.");
        }
        BigDecimal sumineKaina = kainosSkaiciavimas.apskaiciuotiKelionesKaina(atstumas, 0, ikainiai);
        sumineKaina = sumineKaina.add(kainosSkaiciavimas.skaiciuotiIlgalaikeKaina(ikainiai, intervalas));
        transportoPriemone.paliktiTransportoPriemone();
        System.out.println("Baigete transporto priemones nuoma. Nuomos laikas: " + intervalas + ".");
        this.kaina = sumineKaina;
        this.ilgalaikisIntervalas = intervalas;
        this.atstumas = atstumas;
        return sumineKaina;
    }

    public String getIsvykimoTaskas() {
        return isvykimoTaskas;
    }

    public int getPriemoneId() {
        return priemoneId;
    }

    public String getTransportoPriemonesPavadinimas() {
        return transportoPriemonesPavadinimas;
    }

    public TransportoPasirinkimoStrategija getTransportoPriemone() {
        return transportoPriemone;
    }

    public String getAtvykimoTaskas() {
        return atvykimoTaskas;
    }

    public double getAtstumas() {
        return atstumas;
    }

    public Double getLaikas() {
        return laikas;
    }

    public BigDecimal getKaina() {
        return kaina;
    }

    public Intervalas getIlgalaikisIntervalas() {
        return ilgalaikisIntervalas;
    }
}