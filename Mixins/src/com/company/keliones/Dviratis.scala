package com.company.keliones

import com.company.kainosSkaiciavimas.Ikainiai

trait Dviratis extends Kelione {
  val transportoPriemonesPavadinimas = "Rambynas 300"
  val _ikainiai: Ikainiai = new Ikainiai(10, 0, 0, 20, 0, 300, 1500, 3000)

  override def gautiTransportoPriemonesPavadinima: String = transportoPriemonesPavadinimas

  override def gautiTransportoPriemonesIkainius: Ikainiai = _ikainiai

  override def paliktiTransportoPriemone(): Unit = { //palikti priemoneId
    System.out.println("Paliktas Rambynas 300, id: " + priemoneId)
  }

  override def pranestiApieNetiketuma(): Unit = System.out.println("Dekojame uz pranesta dviracio Rambynas 300, id: " + priemoneId + " apgadinima.")
}