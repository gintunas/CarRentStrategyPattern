package com.company.keliones

import com.company.kainosSkaiciavimas.Ikainiai

trait Dviratis extends TransportoPriemone {
  private val transportoPriemonesPavadinimas = "Rambynas 300"
  val _ikainiai: Ikainiai = new Ikainiai(10, 0, 0, 20, 0, 300, 1500, 3000)

  def gautiTransportoPriemonesPavadinima: String = transportoPriemonesPavadinimas

  def gautiIkainius: Ikainiai = _ikainiai

  def pranestiApieNetiketuma(): Unit = System.out.println("Dekojame uz pranesta dviracio Rambynas 300 apgadinima.")

  protected def paliktiTransportoPriemone(priemoneId : Int): Unit = { //palikti priemoneId
    System.out.println("Paliktas Rambynas 300, id: " + priemoneId)
  }
}