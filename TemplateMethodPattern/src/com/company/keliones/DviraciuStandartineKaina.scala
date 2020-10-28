package com.company.keliones

import com.company.kainosSkaiciavimas.StandartinesKainosSkaiciavimas

@throws[IllegalArgumentException]
@throws[UnsupportedOperationException]
class DviraciuStandartineKaina(override val priemoneId: Int, override val isvykimoTaskas: String)
  extends KelioneDviraciu(priemoneId, isvykimoTaskas)
    with StandartinesKainosSkaiciavimas