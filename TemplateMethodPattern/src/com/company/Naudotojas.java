package com.company;

import com.company.enums.Intervalas;
import com.company.enums.KainosTipas;
import com.company.keliones.*;
import com.company.pavezimai.Pavezimas;
import com.company.pavezimai.PavezimasKarantinoKaina;
import com.company.pavezimai.PavezimasStandartineKaina;

import java.math.BigDecimal;
import java.util.List;

public class Naudotojas {
    private final List<Kelione> kelioniuSarasas;
    private final List<Pavezimas> pavezimuSarasas;
    private Pavezimas einamasPavezimas;
    private Kelione einamaKelione;
    private BigDecimal skola;

    public Naudotojas(List<Kelione> kelioniuSarasas, List<Pavezimas> pavezimuSarasas) {
        this.kelioniuSarasas = kelioniuSarasas;
        this.pavezimuSarasas = pavezimuSarasas;
    }

    /**
     * @param priemoneId     x<10000 - dviratis; 10000<x<20000 - pigus automobilis; 20000<x<30000 - prabangus automobilis
     * @param isvykimoTaskas Vietos pavadinimas.
     * @param kainosTipas    Kainos skaiciavimo budas.
     * @return Pradeta kelione.
     */
    public Kelione pradetiKelione(int priemoneId, String isvykimoTaskas, KainosTipas kainosTipas) {
        Kelione kelione;

        if (priemoneId < 10000) {
            if (kainosTipas.equals(KainosTipas.KARANTINO))
                kelione = new DviraciuKarantinoKaina(priemoneId, isvykimoTaskas);
            else kelione = new DviraciuStandartineKaina(priemoneId, isvykimoTaskas);
        } else if (priemoneId < 20000) {
            if (kainosTipas.equals(KainosTipas.KARANTINO))
                kelione = new EkonomiskuAutomobiliuKarantinoKaina(priemoneId, isvykimoTaskas);
            else kelione = new EkonomiskuAutomobiliuStandartineKaina(priemoneId, isvykimoTaskas);
        } else if (priemoneId < 30000) {
            if (kainosTipas.equals(KainosTipas.KARANTINO))
                kelione = new PrabangiuAutomobiliuKarantinoKaina(priemoneId, isvykimoTaskas);
            else kelione = new PrabangiuAutomobiliuStandartineKaina(priemoneId, isvykimoTaskas);
        } else throw new IllegalArgumentException("Nera transporto priemones su tokiu identifikaciniu numeriu.");

        kelioniuSarasas.add(kelione);
        einamaKelione = kelione;
        System.out.println("Kelione su priemone id: " + priemoneId + " pradeta.");
        return kelione;
    }

    public void uzbaigtiKelione(double atstumas, double laikas, String atvykimoTaskas) {
        skola = einamaKelione.uzbaigtiKelione(atstumas, laikas, atvykimoTaskas);
        sumoketi(skola);
        einamaKelione = null;
    }

    public void uzbaigtiKelione(double atstumas, Intervalas intervalas) {
        skola = einamaKelione.uzbaigtiNuoma(atstumas, intervalas);
        sumoketi(skola);
        einamaKelione = null;
    }

    private void sumoketi(BigDecimal kaina) {
        new MokejimoPlatforma.sumoketi(kaina);
        this.skola = null;
    }

    /**
     * @param vairuotojasId  30000<x<40000 - vairuotojo identifikacinis numeris.
     * @param isvykimoTaskas Vietos pavadinimas.
     * @param kainosTipas    Kainos skaiciavimo budas.
     * @return Pradeta pavezimas.
     */
    public void pradetiPavezima(int vairuotojasId, String isvykimoTaskas, KainosTipas kainosTipas) throws IllegalArgumentException {
        if (!(30000 < vairuotojasId && vairuotojasId < 40000))
            throw new IllegalArgumentException("Nera vairuotojo su tokiu identifikaciniu numeriu.");

        Pavezimas pavezimas;
        if (kainosTipas.equals(KainosTipas.STANDARTINE))
            pavezimas = new PavezimasStandartineKaina(vairuotojasId, isvykimoTaskas);
        else pavezimas = new PavezimasKarantinoKaina(vairuotojasId, isvykimoTaskas);
        pavezimuSarasas.add(pavezimas);
        einamasPavezimas = pavezimas;
    }

    public void uzbaigtiPavezima(float atstumas, float laikas, String atvykimoTaskas) {
        skola = einamasPavezimas.uzbaigtiPavezima(atstumas, laikas, atvykimoTaskas);
        sumoketi(skola);
        einamasPavezimas = null;
    }

    public List<Kelione> getKelioniuSarasas() {
        return kelioniuSarasas;
    }

    public List<Pavezimas> getPavezimuSarasas() {
        return pavezimuSarasas;
    }

    public Pavezimas getEinamasPavezimas() {
        return einamasPavezimas;
    }

    public Kelione getEinamaKelione() {
        return einamaKelione;
    }

    public BigDecimal getSkola() {
        return skola;
    }
}