package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class MokejimoPlatforma {
    public static class sumoketi{
        /**
         *
         * @param kaina kaina nurodyta centais
         */
        public sumoketi(BigDecimal kaina) {
            kaina = kaina.setScale(2, RoundingMode.HALF_EVEN)
                    .divide(new BigDecimal(100), RoundingMode.HALF_EVEN);
            NumberFormat eurKainosFormatas = NumberFormat.getCurrencyInstance(Locale.GERMANY);
            System.out.println("Uz kelione sumoketa " + eurKainosFormatas.format(kaina));
        }
    }

}
