package com.company.pavezimai

import com.company.kainosSkaiciavimas.KarantinoKainosSkaiciavimas

class PavezimasKarantinoKaina(override val vairuotojasId: Int, override val isvykimoTaskas: String)
  extends Pavezimas(vairuotojasId, isvykimoTaskas)
    with KarantinoKainosSkaiciavimas
