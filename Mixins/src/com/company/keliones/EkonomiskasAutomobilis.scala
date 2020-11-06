package com.company.keliones

import com.company.kainosSkaiciavimas.Ikainiai

trait EkonomiskasAutomobilis extends Kelione {
  private val transportoPriemonesPavadinimas = "Honda Civic 5 gen."
  val _ikainiai: Ikainiai = new Ikainiai(100, 30, 14, 6, 5, 1522, 7500, 30000)

  def gautiTransportoPriemonesPavadinima: String = transportoPriemonesPavadinimas

  def gautiIkainius: Ikainiai = _ikainiai

  def pranestiApieNetiketuma(): Unit = System.out.println("Dekojame uz pranesta Honda Civic apgadinima.")

  protected def paliktiTransportoPriemone(priemoneId : Int): Unit = { //palikti priemoneId
    System.out.println("Paliktas Honda Civic, id: " + priemoneId)
  }
}