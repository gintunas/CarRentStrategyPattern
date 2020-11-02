package com.company;

import com.company.enums.Intervalas;
import com.company.enums.KainosTipas;
import com.company.kainosSkaiciavimas.KarantinoKainosSkaiciavimas;
import com.company.kainosSkaiciavimas.StandartinesKainosSkaiciavimas;
import com.company.strategijos.KainosSkaiciavimoStrategija;
import com.company.strategijos.TransportoPasirinkimoStrategija;
import com.company.transportoPriemones.KelioneDviraciu;
import com.company.transportoPriemones.KelioneEkonomiskuAutomobiliu;
import com.company.transportoPriemones.KelionePrabangiuAutomobiliu;

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

    private TransportoPasirinkimoStrategija nustatytiTransportoPasirinkimoStrategija(int priemoneId) throws IllegalArgumentException {
        TransportoPasirinkimoStrategija tps;
        if (priemoneId < 10000) {
            tps = new KelioneDviraciu(priemoneId);
        } else if (priemoneId < 20000) {
            tps = new KelioneEkonomiskuAutomobiliu(priemoneId);
        } else if (priemoneId < 30000) {
            tps = new KelionePrabangiuAutomobiliu(priemoneId);
        } else throw new IllegalArgumentException("Nera transporto priemones su tokiu identifikaciniu numeriu.");
        return tps;
    }

    private KainosSkaiciavimoStrategija nustatytiKainosSkaiciavimoStrategija(KainosTipas kainosTipas) throws IllegalArgumentException {
        KainosSkaiciavimoStrategija kss;
        if (kainosTipas == KainosTipas.KARANTINO) {
            kss = new KarantinoKainosSkaiciavimas();
        } else if (kainosTipas == KainosTipas.STANDARTINE) {
            kss = new StandartinesKainosSkaiciavimas();
        } else throw new IllegalArgumentException("Nenustatytas kainos skaiciavimo budas");
        return kss;
    }

    /**
     * @param priemoneId     x<10000 - dviratis; 10000<x<20000 - pigus automobilis; 20000<x<30000 - prabangus automobilis
     * @param isvykimoTaskas Vietos pavadinimas.
     * @param kainosTipas    Kainos skaiciavimo budas.
     * @return Pradeta kelione.
     */
    public Kelione pradetiKelione(int priemoneId, String isvykimoTaskas, KainosTipas kainosTipas) {
        TransportoPasirinkimoStrategija tps = nustatytiTransportoPasirinkimoStrategija(priemoneId);
        KainosSkaiciavimoStrategija kss = nustatytiKainosSkaiciavimoStrategija(kainosTipas);
        Kelione kelione = new Kelione(priemoneId, isvykimoTaskas, tps, kss);
        kelioniuSarasas.add(kelione);
        einamaKelione = kelione;
        System.out.println("Kelione su priemone id: " + kelione.getPriemoneId() + " pradeta.");
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
     * @return Pradetas pavezimas.
     */
    public Pavezimas pradetiPavezima(int vairuotojasId, String isvykimoTaskas, KainosTipas kainosTipas) throws IllegalArgumentException {
        if (!(30000 < vairuotojasId && vairuotojasId < 40000))
            throw new IllegalArgumentException("Nera vairuotojo su tokiu identifikaciniu numeriu.");

        KainosSkaiciavimoStrategija kss = nustatytiKainosSkaiciavimoStrategija(kainosTipas);
        Pavezimas pavezimas = new Pavezimas(vairuotojasId, isvykimoTaskas, kss);
        pavezimuSarasas.add(pavezimas);
        einamasPavezimas = pavezimas;
        return pavezimas;
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