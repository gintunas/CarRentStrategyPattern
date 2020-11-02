package com.company.strategijos;

import com.company.kainosSkaiciavimas.Ikainiai;

public interface TransportoPasirinkimoStrategija {
    String gautiPavadinima();
    void paliktiTransportoPriemone();
    void pranestiApieNetiketuma();
    Ikainiai gautiIkainius();
}
