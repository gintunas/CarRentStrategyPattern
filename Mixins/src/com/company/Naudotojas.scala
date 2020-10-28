package com.company

import java.math.BigDecimal

import com.company.MokejimoPlatforma.{sumoketi => sumoketiPerPlatforma}
import com.company.enums.{Intervalas, KainosTipas}
import com.company.keliones._
import com.company.pavezimai.{Pavezimas, PavezimasKarantinoKaina, PavezimasStandartineKaina}

import scala.collection.mutable.ListBuffer

class Naudotojas(val kelioniuSarasas: ListBuffer[Kelione], val pavezimuSarasas: ListBuffer[Pavezimas]) {
  private var einamasPavezimas: Pavezimas = _
  private var einamaKelione: Kelione = _
  private var skola: BigDecimal = _

  /**
   * @param priemoneId     x<10000 - dviratis; 10000<x<20000 - pigus automobilis; 20000<x<30000 - prabangus automobilis
   * @param isvykimoTaskas Vietos pavadinimas.
   * @param kainosTipas    Kainos skaiciavimo budas.
   * @return Pradeta kelione.
   */
  def pradetiKelione(priemoneId: Int, isvykimoTaskas: String, kainosTipas: Intervalas.Value): Kelione = {
    var kelione: Kelione = null
    if (priemoneId < 10000) if (kainosTipas.equals(KainosTipas.KARANTINO)) kelione = new DviraciuKarantinoKaina(priemoneId, isvykimoTaskas)
    else kelione = new DviraciuStandartineKaina(priemoneId, isvykimoTaskas)
    else if (priemoneId < 20000) if (kainosTipas.equals(KainosTipas.KARANTINO)) kelione = new EkonomiskuAutomobiliuKarantinoKaina(priemoneId, isvykimoTaskas)
    else kelione = new EkonomiskuAutomobiliuStandartineKaina(priemoneId, isvykimoTaskas)
    else if (priemoneId < 30000) if (kainosTipas.equals(KainosTipas.KARANTINO)) kelione = new PrabangiuAutomobiliuKarantinoKaina(priemoneId, isvykimoTaskas)
    else kelione = new PrabangiuAutomobiliuStandartineKaina(priemoneId, isvykimoTaskas)
    else throw new IllegalArgumentException("Nera transporto priemones su tokiu identifikaciniu numeriu.")
    kelioniuSarasas.addOne(kelione)
    einamaKelione = kelione
    System.out.println("Kelione su priemone id: " + priemoneId + " pradeta.")
    kelione
  }

  def uzbaigtiKelione(atstumas: Double, laikas: Double, atvykimoTaskas: String): Unit = {
    skola = einamaKelione.uzbaigtiKelione(atstumas, laikas, atvykimoTaskas)
    sumoketi(skola)
  }

  def uzbaigtiKelione(atstumas: Double, intervalas: Intervalas.Value): Unit = {
    skola = einamaKelione.uzbaigtiNuoma(atstumas, intervalas)
    sumoketi(skola)
  }

  private def sumoketi(kaina: BigDecimal): Unit = {
    System.out.println(kaina)
    sumoketiPerPlatforma(kaina)
    einamaKelione = null
    this.skola = null
  }

  /**
   * @param vairuotojasId  30000<x<40000 - vairuotojo identifikacinis numeris.
   * @param isvykimoTaskas Vietos pavadinimas.
   * @param kainosTipas    Kainos skaiciavimo budas.
   * @return Pradeta pavezimas.
   */
  def pradetiPavezima(vairuotojasId: Int, isvykimoTaskas: String, kainosTipas: KainosTipas.Value): Pavezimas = {
    var pavezimas: Pavezimas = null
    if (kainosTipas.equals(KainosTipas.STANDARTINE)) pavezimas = new PavezimasStandartineKaina(vairuotojasId, isvykimoTaskas)
    else pavezimas = new PavezimasKarantinoKaina(vairuotojasId, isvykimoTaskas)
    pavezimuSarasas.addOne(pavezimas)
    einamasPavezimas = pavezimas
    pavezimas
  }

  def uzbaigtiPavezima(atstumas: Float, laikas: Float, atvykimoTaskas: String): Unit = {
    skola = einamasPavezimas.uzbaigtiPavezima(atstumas, laikas, atvykimoTaskas)
    sumoketi(skola)
    einamasPavezimas = null
    skola = null
  }
}