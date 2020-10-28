package com.company.pavezimai

import java.math.BigDecimal

import com.company.kainosSkaiciavimas.Ikainiai

abstract class Pavezimas(val vairuotojasId: Int, val isvykimoTaskas: String) {
  if (!(30000 < vairuotojasId && vairuotojasId < 40000)) throw new IllegalArgumentException("Nera vairuotojo su tokiu identifikaciniu numeriu.")
  val ikainiai: Ikainiai = nustatytiIkainius
  val vairuotojoVardas = "Vėjas Nupūstas"
  var atvykimoTaskas: String = _
  var atstumas = .0
  var laikas = .0
  var kaina: BigDecimal = _
  System.out.println("Jusu pavezimas pradetas, vairuotojas " + vairuotojoVardas + ".")

  private def nustatytiIkainius = new Ikainiai(100, 100, 12, 0)

  /**
   * @return Pavezimo kaina.
   */
  @throws[UnsupportedOperationException]
  def uzbaigtiPavezima(atstumas: Double, laikas: Double, atvykimoTaskas: String): BigDecimal = {
    if (atvykimoTaskas.isEmpty) throw new UnsupportedOperationException("Nenustatytas atvykimo taskas.")
    var sumineKaina: BigDecimal = this.apskaiciuotiKelionesKaina(atstumas, laikas, ikainiai)
    sumineKaina = this.koreguotiSumineKaina(isvykimoTaskas, atvykimoTaskas, sumineKaina)
    System.out.println("Ačiū, kad važiavote su " + vairuotojoVardas + ".")
    this.kaina = sumineKaina
    this.atstumas = atstumas
    this.laikas = laikas
    this.atvykimoTaskas = atvykimoTaskas
    sumineKaina
  }

  protected def koreguotiSumineKaina(isvykimoTaskas: String, atvykimoTaskas: String, sumineKaina: BigDecimal): BigDecimal

  protected def apskaiciuotiKelionesKaina(atstumas: Double, laikas: Double, ikainiai: Ikainiai): BigDecimal
}