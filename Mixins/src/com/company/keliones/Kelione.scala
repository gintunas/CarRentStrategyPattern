package com.company.keliones

import java.math.BigDecimal

import com.company.enums.Intervalas
import com.company.kainosSkaiciavimas.KainosSkaiciavimas

abstract class Kelione(val priemoneId: Int, val isvykimoTaskas: String) extends KainosSkaiciavimas with TransportoPriemone {
  var atvykimoTaskas: String = _
  var atstumas = .0
  var laikas = .0
  private var kaina: BigDecimal = _
  private var ilgalaikisIntervalas: Intervalas.Value = _

  /**
   * @return Keliones kaina.
   */
  def uzbaigtiKelione(atstumas: Double, laikas: Double, atvykimoTaskas: String): BigDecimal = {
    if (atvykimoTaskas.isEmpty) throw new UnsupportedOperationException("Nenustatytas atvykimo taskas.")
    var sumineKaina = apskaiciuotiKelionesKaina(atstumas, laikas, gautiIkainius)
    sumineKaina = koreguotiSumineKaina(isvykimoTaskas, atvykimoTaskas, sumineKaina)
    paliktiTransportoPriemone(priemoneId)
    this.kaina = sumineKaina
    this.atstumas = atstumas
    this.laikas = laikas
    this.atvykimoTaskas = atvykimoTaskas
    sumineKaina
  }

  def uzbaigtiNuoma(atstumas: Double, intervalas: Intervalas.Value): BigDecimal = {
    if (intervalas == null) throw new UnsupportedOperationException("Nenustatytas nuomos intervalas.")
    val ikainiai = gautiIkainius
    var sumineKaina = apskaiciuotiKelionesKaina(atstumas, 0, ikainiai)
    sumineKaina = sumineKaina.add(skaiciuotiIlgalaikeKaina(ikainiai, intervalas))
    paliktiTransportoPriemone(priemoneId)
    System.out.println("Baigete transporto priemones nuoma. Nuomos laikas: " + intervalas + ".")
    this.kaina = sumineKaina
    this.ilgalaikisIntervalas = intervalas
    this.atstumas = atstumas
    sumineKaina
  }
}