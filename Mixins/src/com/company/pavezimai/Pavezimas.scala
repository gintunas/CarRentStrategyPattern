package com.company.pavezimai

import com.company.kainosSkaiciavimas.Ikainiai
import com.company.keliones.Kelione

abstract class Pavezimas(val vairuotojasId: Int, override val isvykimoTaskas: String) extends Kelione(vairuotojasId, isvykimoTaskas) {
  private val vairuotojoVardas = "Vėjas Nupūstas"
  System.out.println("Jusu pavezimas pradetas, vairuotojas " + vairuotojoVardas + ".")

  private val _ikainiai = new Ikainiai(100, 100, 12, 0)

  override def gautiTransportoPriemonesPavadinima: String = "Vairuotojas " + vairuotojoVardas

  override def gautiIkainius: Ikainiai = _ikainiai

  override def pranestiApieNetiketuma(): Unit = System.out.println("Dekojame uz pranesta neatitikima vaziuojant su " + vairuotojoVardas + " .")

  protected override def paliktiTransportoPriemone(vairuotojoVardas : Int): Unit = {
    System.out.println("Ačiū, kad važiavote su " + vairuotojoVardas + ". Kviečiame ir toliau naudotis mūsų paslaugomis.")
  }

}