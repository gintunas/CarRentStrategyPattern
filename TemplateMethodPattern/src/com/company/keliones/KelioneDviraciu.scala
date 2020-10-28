package com.company.keliones

import com.company.kainosSkaiciavimas.Ikainiai

@throws[UnsupportedOperationException]
abstract class KelioneDviraciu(override val priemoneId: Int, override val isvykimoTaskas: String) extends Kelione(priemoneId, isvykimoTaskas) {
  transportoPriemonesPavadinimas = pasirinktiTransportoPriemone(priemoneId)
  if (transportoPriemonesPavadinimas.isEmpty) throw new UnsupportedOperationException("Nepavyko pasirinkti transporto priemones.")
  ikainiai = gautiTransportoPriemonesIkainius

  override def pasirinktiTransportoPriemone(priemoneId: Int): String = { //if(priemoneID nepasirinktas) pasirinkti
    "Rambynas 300"
    //else return null;
  }

  override def gautiTransportoPriemonesIkainius = new Ikainiai(10, 0, 0, 20, 0, 300, 1500, 3000)

  override def paliktiTransportoPriemone(): Unit = { //palikti priemoneId
    System.out.println("Paliktas Rambynas 300, id: " + priemoneId)
  }

  override def pranestiApieNetiketuma(): Unit = System.out.println("Dekojame uz pranesta dviracio Rambynas 300, id: " + priemoneId + " apgadinima.")
}