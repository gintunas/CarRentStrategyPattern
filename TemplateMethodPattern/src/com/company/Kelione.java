package com.company;

import com.company.enums.Intervalas;
import com.company.kainosSkaiciavimas.Ikainiai;

import java.math.BigDecimal;

public abstract class Kelione {
    protected Ikainiai ikainiai;
    private final String isvykimoTaskas;
    private final int priemoneId;
    public String transportoPriemonesPavadinimas;
    private String atvykimoTaskas;
    private double atstumas;
    private double laikas;
    private BigDecimal kaina;
    private Intervalas ilgalaikisIntervalas;

    public Kelione(int priemoneId, String isvykimoTaskas) throws IllegalArgumentException, UnsupportedOperationException {
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
        BigDecimal sumineKaina = apskaiciuotiKelionesKaina(atstumas, laikas, ikainiai);
        sumineKaina = koreguotiSumineKaina(isvykimoTaskas, atvykimoTaskas, sumineKaina);
        paliktiTransportoPriemone();
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
        BigDecimal sumineKaina = apskaiciuotiKelionesKaina(atstumas, 0, ikainiai);
        sumineKaina = sumineKaina.add(skaiciuotiIlgalaikeKaina(ikainiai, intervalas));
        this.paliktiTransportoPriemone();
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

    public Kelione getTransportoPriemone() {
        return this;
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

    protected abstract String pasirinktiTransportoPriemone(int priemoneId);

    protected abstract void paliktiTransportoPriemone();

    protected abstract void pranestiApieNetiketuma();

    protected abstract Ikainiai gautiTransportoPriemonesIkainius();

    protected abstract BigDecimal apskaiciuotiKelionesKaina(double atstumas, double laikas, Ikainiai ikainiai);

    protected abstract BigDecimal koreguotiSumineKaina(String is, String i, BigDecimal kaina);

    protected abstract BigDecimal skaiciuotiIlgalaikeKaina(Ikainiai ikainiai, Intervalas intervalas);

}