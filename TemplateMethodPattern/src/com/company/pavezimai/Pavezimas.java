package com.company.pavezimai;

import com.company.kainosSkaiciavimas.Ikainiai;
import com.company.kainosSkaiciavimas.IkainiaiBuilder;

import java.math.BigDecimal;

public abstract class Pavezimas {
    private final String vairuotojoVardas = "Vėjas Nupūstas";
    private final Ikainiai ikainiai = new IkainiaiBuilder()
            .setPradineKaina(100)
            .setKilometroKaina(100)
            .setMinutesKaina(12)
            .createIkainiai();

    private final int vairuotojasId;
    private final String isvykimoTaskas;
    private String atvykimoTaskas;
    private double atstumas;
    private double laikas;
    private BigDecimal kaina;

    public Pavezimas(int vairuotojasId, String isvykimoTaskas) {
        this.vairuotojasId = vairuotojasId;
        this.isvykimoTaskas = isvykimoTaskas;
        System.out.println("Jusu pavezimas pradetas, vairuotojas " + getVairuotojoVardas() + ".");
    }

    /**
     * @return Pavezimo kaina.
     */
    public BigDecimal uzbaigtiPavezima(double atstumas, double laikas, String atvykimoTaskas) throws UnsupportedOperationException {
        if (atvykimoTaskas.isEmpty()) {
            throw new UnsupportedOperationException("Nenustatytas atvykimo taskas.");
        }
        BigDecimal sumineKaina = apskaiciuotiKelionesKaina(atstumas, laikas, gautiVairuotojoIkainius());
        sumineKaina = koreguotiSumineKaina(getIsvykimoTaskas(), atvykimoTaskas, sumineKaina);
        System.out.println("Ačiū, kad važiavote su " + getVairuotojoVardas() + ".");
        this.kaina = sumineKaina;
        this.atstumas = atstumas;
        this.laikas = laikas;
        this.atvykimoTaskas = atvykimoTaskas;
        return sumineKaina;
    }

    public Ikainiai gautiVairuotojoIkainius() {
        return ikainiai;
    }

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

    protected abstract BigDecimal koreguotiSumineKaina(String isvykimoTaskas, String atvykimoTaskas, BigDecimal sumineKaina);

    protected abstract BigDecimal apskaiciuotiKelionesKaina(double atstumas, double laikas, Ikainiai ikainiai);
}
