package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InputData {
    private LocalDate repaymentStartDay = LocalDate.of(2022, 10, 10);
    private BigDecimal wiborPercent = new BigDecimal(1.73);
    private BigDecimal amount = new BigDecimal(300000);
    private BigDecimal numberInstallments = new BigDecimal(180);
}
