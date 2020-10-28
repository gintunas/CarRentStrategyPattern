package com.company.keliones

import com.company.kainosSkaiciavimas.KarantinoKainosSkaiciavimas

@throws[IllegalArgumentException]
@throws[UnsupportedOperationException]
class EkonomiskuAutomobiliuKarantinoKaina(override val priemoneId: Int, override val isvykimoTaskas: String)
  extends KelioneEkonomiskuAutomobiliu(priemoneId, isvykimoTaskas)
    with KarantinoKainosSkaiciavimas
