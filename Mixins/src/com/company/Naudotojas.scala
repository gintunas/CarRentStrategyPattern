package com.company

import java.math.BigDecimal

import com.company.MokejimoPlatforma.{sumoketi => sumoketiPerPlatforma}
import com.company.enums.{Intervalas, KainosTipas}
import com.company.kainosSkaiciavimas.{KarantinoKainosSkaiciavimas, StandartinesKainosSkaiciavimas}
import com.company.keliones._
import com.company.pavezimai.Pavezimas

import scala.collection.mutable.ListBuffer

class Naudotojas(val kelioniuSarasas: ListBuffer[Kelione], val pavezimuSarasas: ListBuffer[Pavezimas]) {
  var einamasPavezimas: Pavezimas = _
  var einamaKelione: Kelione = _
  var skola: BigDecimal = _

  /**
   * @param priemoneId     x<10000 - dviratis; 10000<x<20000 - pigus automobilis; 20000<x<30000 - prabangus automobilis
   * @param isvykimoTaskas Vietos pavadinimas.
   * @param kainosTipas    Kainos skaiciavimo budas.
   * @return Pradeta kelione.
   */
  def pradetiKelione(priemoneId: Int, isvykimoTaskas: String, kainosTipas: KainosTipas.Value): Kelione = {
    val kelione: Kelione = {
      if (priemoneId < 10000) {
        if (kainosTipas == KainosTipas.KARANTINO)
          new Kelione(priemoneId, isvykimoTaskas) with Dviratis with KarantinoKainosSkaiciavimas
        else if (kainosTipas == KainosTipas.STANDARTINE)
          new Kelione(priemoneId, isvykimoTaskas) with Dviratis with StandartinesKainosSkaiciavimas
        else throw new IllegalArgumentException("Nenustatytas kainos tipas.")
      }

      else if (priemoneId < 20000) {
        if (kainosTipas.equals(KainosTipas.KARANTINO))
          new Kelione(priemoneId, isvykimoTaskas) with EkonomiskasAutomobilis with KarantinoKainosSkaiciavimas
        else if (kainosTipas == KainosTipas.STANDARTINE)
          new Kelione(priemoneId, isvykimoTaskas) with EkonomiskasAutomobilis with StandartinesKainosSkaiciavimas
        else throw new IllegalArgumentException("Nenustatytas kainos tipas.")
      }

      else if (priemoneId < 30000) {
        if (kainosTipas.equals(KainosTipas.KARANTINO))
          new Kelione(priemoneId, isvykimoTaskas) with PrabangusAutomobilis with KarantinoKainosSkaiciavimas
        else if (kainosTipas == KainosTipas.STANDARTINE)
          new Kelione(priemoneId, isvykimoTaskas) with PrabangusAutomobilis with StandartinesKainosSkaiciavimas
        else throw new IllegalArgumentException("Nenustatytas kainos tipas.")
      }
      else throw new IllegalArgumentException("Nera transporto priemones su tokiu identifikaciniu numeriu.")
    }

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
    if (!(30000 < vairuotojasId && vairuotojasId < 40000))
      throw new IllegalArgumentException("Nera vairuotojo su tokiu identifikaciniu numeriu.")

    val pavezimas: Pavezimas =
      if (kainosTipas == KainosTipas.STANDARTINE)
        new Pavezimas(vairuotojasId, isvykimoTaskas) with StandartinesKainosSkaiciavimas
      else if (kainosTipas == KainosTipas.KARANTINO)
        new Pavezimas(vairuotojasId, isvykimoTaskas) with KarantinoKainosSkaiciavimas
      else throw new IllegalArgumentException("Nenustatytas kainos tipas.")

    pavezimuSarasas.addOne(pavezimas)
    einamasPavezimas = pavezimas
    pavezimas
  }

  def uzbaigtiPavezima(atstumas: Float, laikas: Float, atvykimoTaskas: String): Unit = {
    skola = einamasPavezimas.uzbaigtiKelione(atstumas, laikas, atvykimoTaskas)
    sumoketi(skola)
    einamasPavezimas = null
    skola = null
  }
}