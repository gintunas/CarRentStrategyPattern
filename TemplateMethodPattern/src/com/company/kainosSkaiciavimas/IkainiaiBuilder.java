package com.company.kainosSkaiciavimas;

/**
 * Kainos nurodytos centais.
 */
public class IkainiaiBuilder {
    private int pradineKaina;
    private int kilometroKaina;
    private int minutesKaina;
    private int virsytoLaikoKaina;
    private int virsytoAtstumoKaina;
    private int parosKaina;
    private int savaitesKaina;
    private int menesioKaina;

    public IkainiaiBuilder setPradineKaina(int pradineKaina) {
        this.pradineKaina = pradineKaina;
        return this;
    }

    public IkainiaiBuilder setKilometroKaina(int kilometroKaina) {
        this.kilometroKaina = kilometroKaina;
        return this;
    }

    public IkainiaiBuilder setMinutesKaina(int minutesKaina) {
        this.minutesKaina = minutesKaina;
        return this;
    }

    public IkainiaiBuilder setVirsytoLaikoKaina(int virsytoLaikoKaina) {
        this.virsytoLaikoKaina = virsytoLaikoKaina;
        return this;
    }

    public IkainiaiBuilder setVirsytoAtstumoKaina(int virsytoAtstumoKaina) {
        this.virsytoAtstumoKaina = virsytoAtstumoKaina;
        return this;
    }

    public IkainiaiBuilder setParosKaina(int parosKaina) {
        this.parosKaina = parosKaina;
        return this;
    }

    public IkainiaiBuilder setSavaitesKaina(int savaitesKaina) {
        this.savaitesKaina = savaitesKaina;
        return this;
    }

    public IkainiaiBuilder setMenesioKaina(int menesioKaina) {
        this.menesioKaina = menesioKaina;
        return this;
    }

    public Ikainiai createIkainiai() {
        return new Ikainiai(pradineKaina, kilometroKaina, minutesKaina, virsytoLaikoKaina, virsytoAtstumoKaina, parosKaina, savaitesKaina, menesioKaina);
    }
}