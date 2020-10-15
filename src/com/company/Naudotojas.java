package com.company;

import com.company.enums.Intervalas;
import com.company.enums.KainosTipas;

import java.math.BigDecimal;
import java.util.List;

public class Naudotojas {
    private final List<Kelione> kelioniuSarasas;
    private final List<Pavezimas> pavezimuSarasas;
    private Pavezimas einamasPavezimas;
    private Kelione einamaKelione;
    private BigDecimal kaina;

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
        Kelione kelione = new Kelione(priemoneId, isvykimoTaskas, kainosTipas);
        kelioniuSarasas.add(kelione);
        einamaKelione = kelione;
        System.out.println("Kelione su priemone id: " + priemoneId + " pradeta.");
        return kelione;
    }

    public void uzbaigtiKelione(double atstumas, double laikas, String atvykimoTaskas) {
        kaina = einamaKelione.uzbaigtiKelione(atstumas, laikas, atvykimoTaskas);
        sumoketiUzKelione(kaina);
    }

    public void uzbaigtiKelione(double atstumas, Intervalas intervalas) {
        kaina = einamaKelione.uzbaigtiNuoma(atstumas, intervalas);
        sumoketiUzKelione(kaina);
    }

    private void sumoketiUzKelione(BigDecimal kaina) {
        new MokejimoPlatforma.sumoketi(kaina);
        einamaKelione = null;
        this.kaina = null;
    }

    /**
     * @param vairuotojasId  30000<x<40000 - vairuotojo identifikacinis numeris.
     * @param isvykimoTaskas Vietos pavadinimas.
     * @param kainosTipas    Kainos skaiciavimo budas.
     * @return Pradeta pavezimas.
     */
    public Pavezimas pradetiPavezima(int vairuotojasId, String isvykimoTaskas, KainosTipas kainosTipas) {
        Pavezimas pavezimas = new Pavezimas(vairuotojasId, isvykimoTaskas, kainosTipas);
        pavezimuSarasas.add(pavezimas);
        einamasPavezimas = pavezimas;
        return pavezimas;
    }

    public void uzbaigtiPavezima(float atstumas, float laikas, String atvykimoTaskas) {
        kaina = einamasPavezimas.uzbaigtiPavezima(atstumas, laikas, atvykimoTaskas);
        sumoketiUzKelione(kaina);
        einamasPavezimas = null;
        kaina = null;
    }
}