package com.company.pavezimai;

import com.company.kainosSkaiciavimas.Ikainiai;
import com.company.kainosSkaiciavimas.IkainiaiBuilder;

import java.math.BigDecimal;

public abstract class Pavezimas {
    private final Ikainiai ikainiai;
    private final int vairuotojasId;
    private final String vairuotojoVardas;
    private final String isvykimoTaskas;
    private String atvykimoTaskas;
    private double atstumas;
    private double laikas;
    private BigDecimal kaina;

    public Pavezimas(int vairuotojasId, String isvykimoTaskas) {
        if (!(30000 < vairuotojasId && vairuotojasId < 40000))
            throw new IllegalArgumentException("Nera vairuotojo su tokiu identifikaciniu numeriu.");

        this.ikainiai = nustatytiIkainius();
        this.vairuotojoVardas = "Vėjas Nupūstas";
        this.vairuotojasId = vairuotojasId;
        this.isvykimoTaskas = isvykimoTaskas;
        System.out.println("Jusu pavezimas pradetas, vairuotojas " + vairuotojoVardas + ".");
    }

    private Ikainiai nustatytiIkainius() {
        return new IkainiaiBuilder()
                .setPradineKaina(100)
                .setKilometroKaina(100)
                .setMinutesKaina(12)
                .createIkainiai();
    }

    /**
     * @return Pavezimo kaina.
     */
    public BigDecimal uzbaigtiPavezima(double atstumas, double laikas, String atvykimoTaskas) throws UnsupportedOperationException {
        if (atvykimoTaskas.isEmpty()) {
            throw new UnsupportedOperationException("Nenustatytas atvykimo taskas.");
        }
        BigDecimal sumineKaina = this.apskaiciuotiKelionesKaina(atstumas, laikas, ikainiai);
        sumineKaina = this.koreguotiSumineKaina(isvykimoTaskas, atvykimoTaskas, sumineKaina);
        System.out.println("Ačiū, kad važiavote su " + vairuotojoVardas + ".");
        this.kaina = sumineKaina;
        this.atstumas = atstumas;
        this.laikas = laikas;
        this.atvykimoTaskas = atvykimoTaskas;
        return sumineKaina;
    }

    protected abstract BigDecimal koreguotiSumineKaina(String isvykimoTaskas, String atvykimoTaskas, BigDecimal sumineKaina);

    protected abstract BigDecimal apskaiciuotiKelionesKaina(double atstumas, double laikas, Ikainiai ikainiai);

    public int getVairuotojasId() {
        return vairuotojasId;
    }

    public String getVairuotojoVardas() {
        return vairuotojoVardas;
    }

    public String getIsvykimoTaskas() {
        return isvykimoTaskas;
    }

    public String getAtvykimoTaskas() {
        return atvykimoTaskas;
    }

    public double getAtstumas() {
        return atstumas;
    }

    public double getLaikas() {
        return laikas;
    }

    public BigDecimal getKaina() {
        return kaina;
    }
}
