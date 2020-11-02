package com.company;

import com.company.enums.Intervalas;
import com.company.kainosSkaiciavimas.Ikainiai;
import com.company.strategijos.KainosSkaiciavimoStrategija;
import com.company.strategijos.TransportoPasirinkimoStrategija;

import java.math.BigDecimal;

public class Kelione {
    private final TransportoPasirinkimoStrategija tps;
    private final KainosSkaiciavimoStrategija kss;

    private final int priemoneId;
    private final String isvykimoTaskas;
    private String atvykimoTaskas;
    private double atstumas;
    private double laikas;
    private BigDecimal kaina;
    private Intervalas ilgalaikisIntervalas;

    public Kelione(int priemoneId, String isvykimoTaskas, TransportoPasirinkimoStrategija tps, KainosSkaiciavimoStrategija kss) throws IllegalArgumentException, UnsupportedOperationException {
        this.tps = tps;
        this.kss = kss;
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
        BigDecimal sumineKaina = kss.apskaiciuotiKelionesKaina(atstumas, laikas, tps.gautiIkainius());
        sumineKaina = kss.koreguotiSumineKaina(isvykimoTaskas, atvykimoTaskas, sumineKaina);
        tps.paliktiTransportoPriemone();
        this.kaina = sumineKaina;
        this.atstumas = atstumas;
        this.laikas = laikas;
        this.atvykimoTaskas = atvykimoTaskas;
        return sumineKaina;
    }

    /**
     * @return Keliones kaina.
     */
    public BigDecimal uzbaigtiNuoma(double atstumas, Intervalas intervalas) throws UnsupportedOperationException {
        if (intervalas == null) {
            throw new UnsupportedOperationException("Nenustatytas nuomos intervalas.");
        }
        Ikainiai ikainiai = tps.gautiIkainius();
        BigDecimal sumineKaina = kss.apskaiciuotiKelionesKaina(atstumas, 0, ikainiai);
        sumineKaina = sumineKaina.add(kss.skaiciuotiIlgalaikeKaina(ikainiai, intervalas));
        tps.paliktiTransportoPriemone();
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

    public String gautiTransportoPriemonesPavadinima() {
        return tps.gautiTransportoPriemonesPavadinima();
    }

    public TransportoPasirinkimoStrategija getTransportoPriemone() {
        return tps;
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