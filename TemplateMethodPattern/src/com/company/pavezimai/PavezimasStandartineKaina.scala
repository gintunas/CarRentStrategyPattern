package com.company.pavezimai

import com.company.kainosSkaiciavimas.StandartinesKainosSkaiciavimas

class PavezimasStandartineKaina(override val vairuotojasId: Int, override val isvykimoTaskas: String)
  extends Pavezimas(vairuotojasId, isvykimoTaskas)
    with StandartinesKainosSkaiciavimas
