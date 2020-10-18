package com.company.kainosSkaiciavimas;

import java.math.BigDecimal;

public class Ikainiai {
    private final BigDecimal pradineKaina;
    private final BigDecimal kilometroKaina;
    private final BigDecimal minutesKaina;
    private final BigDecimal virsytoLaikoKaina;
    private final BigDecimal virsytoAtstumoKaina;
    private final BigDecimal parosKaina;
    private final BigDecimal savaitesKaina;
    private final BigDecimal menesioKaina;

    /**
     * Kainos turi buti nurodytos centais.
     */
    public Ikainiai(int pradineKaina, int kilometroKaina, int minutesKaina, int virsytoLaikoKaina, int virsytoAtstumoKaina, int parosKaina, int savaitesKaina, int menesioKaina) {
        this.pradineKaina = new BigDecimal(pradineKaina);
        this.kilometroKaina = new BigDecimal(kilometroKaina);
        this.minutesKaina = new BigDecimal(minutesKaina);
        this.virsytoLaikoKaina = new BigDecimal(virsytoLaikoKaina);
        this.virsytoAtstumoKaina = new BigDecimal(virsytoAtstumoKaina);
        this.parosKaina = new BigDecimal(parosKaina);
        this.savaitesKaina = new BigDecimal(savaitesKaina);
        this.menesioKaina = new BigDecimal(menesioKaina);
    }

    public BigDecimal getPradineKaina() {
        return pradineKaina;
    }

    public BigDecimal getKilometroKaina() {
        return kilometroKaina;
    }

    public BigDecimal getMinutesKaina() {
        return minutesKaina;
    }

    public BigDecimal getVirsytoLaikoKaina() {
        return virsytoLaikoKaina;
    }

    public BigDecimal getVirsytoAtstumoKaina() {
        return virsytoAtstumoKaina;
    }

    public BigDecimal getParosKaina() {
        return parosKaina;
    }

    public BigDecimal getSavaitesKaina() {
        return savaitesKaina;
    }

    public BigDecimal getMenesioKaina() {
        return menesioKaina;
    }
}
