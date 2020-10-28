package com.company.keliones

import java.math.BigDecimal

import com.company.enums.Intervalas
import com.company.kainosSkaiciavimas.Ikainiai

@throws[IllegalArgumentException]
@throws[UnsupportedOperationException]
abstract class Kelione
(val priemoneId: Int, val isvykimoTaskas: String) {
  protected var ikainiai: Ikainiai = _
  var transportoPriemonesPavadinimas: String = _
  private var atvykimoTaskas: String = _
  private var atstumas = .0
  private var laikas = .0
  private var kaina: BigDecimal = _
  private var ilgalaikisIntervalas: Intervalas.Value = _

  /**
   * @return Keliones kaina.
   */
  @throws[UnsupportedOperationException]
  def uzbaigtiKelione(atstumas: Double, laikas: Double, atvykimoTaskas: String): BigDecimal = {
    if (atvykimoTaskas.isEmpty) throw new UnsupportedOperationException("Nenustatytas atvykimo taskas.")
    var sumineKaina = apskaiciuotiKelionesKaina(atstumas, laikas, ikainiai)
    sumineKaina = koreguotiSumineKaina(isvykimoTaskas, atvykimoTaskas, sumineKaina)
    paliktiTransportoPriemone()
    this.kaina = sumineKaina
    this.atstumas = atstumas
    this.laikas = laikas
    this.atvykimoTaskas = atvykimoTaskas
    sumineKaina
  }

  @throws[UnsupportedOperationException]
  def uzbaigtiNuoma(atstumas: Double, intervalas: Intervalas.Value): BigDecimal = {
    if (intervalas == null) throw new UnsupportedOperationException("Nenustatytas nuomos intervalas.")
    var sumineKaina = apskaiciuotiKelionesKaina(atstumas, 0, ikainiai)
    sumineKaina = sumineKaina.add(skaiciuotiIlgalaikeKaina(ikainiai, intervalas))
    this.paliktiTransportoPriemone()
    System.out.println("Baigete transporto priemones nuoma. Nuomos laikas: " + intervalas + ".")
    this.kaina = sumineKaina
    this.ilgalaikisIntervalas = intervalas
    this.atstumas = atstumas
    sumineKaina
  }

  def getTransportoPriemonesPavadinimas: String = transportoPriemonesPavadinimas

  def getTransportoPriemone: Kelione = this

  protected def pasirinktiTransportoPriemone(priemoneId: Int): String

  protected def paliktiTransportoPriemone()

  def pranestiApieNetiketuma()

  protected def gautiTransportoPriemonesIkainius: Ikainiai

  protected def apskaiciuotiKelionesKaina(atstumas: Double, laikas: Double, ikainiai: Ikainiai): BigDecimal

  protected def koreguotiSumineKaina(is: String, i: String, kaina: BigDecimal): BigDecimal

  protected def skaiciuotiIlgalaikeKaina(ikainiai: Ikainiai, intervalas: Intervalas.Value): BigDecimal
}