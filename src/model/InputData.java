package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class InputData {
    public static final BigDecimal PERCENT = BigDecimal.valueOf(100);

    private LocalDate repaymentStartDay = LocalDate.of(2022, 10, 10);
    private BigDecimal wiborPercent = new BigDecimal(1.73);
    private BigDecimal amount = new BigDecimal(300000);
    private BigDecimal numberInstalments = new BigDecimal(180);
    private TypeInstalments typeInstalments = TypeInstalments.CONSTANT;
    private BigDecimal bankMarginPercent = new BigDecimal(1.9);


    public InputData withRepaymentStartDay(LocalDate repaymentStartDay) {
        this.repaymentStartDay = repaymentStartDay;
        return this;
    }
    public InputData withWiborPercent(BigDecimal wiborPercent) {
        this.wiborPercent = wiborPercent;
        return this;
    }
    public InputData withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }
    public InputData withNumberInstalments(BigDecimal numberInstalments) {
        this.numberInstalments = numberInstalments;
        return this;
    }
    public InputData withTypeInstalments(TypeInstalments typeInstalments) {
        this.typeInstalments = typeInstalments;
        return this;
    }
    public InputData withBankMarginPercent(BigDecimal bankMarginPercent) {
        this.bankMarginPercent = bankMarginPercent;
        return this;
    }

    public LocalDate getRepaymentStartDay() {
        return repaymentStartDay;
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getNumberInstalments() {
        return numberInstalments;
    }

    public TypeInstalments getTypeInstalments() {
        return typeInstalments;
    }

    public BigDecimal getInterestPercent() {
        return wiborPercent.add(bankMarginPercent).divide(PERCENT, 10, RoundingMode.HALF_UP);
    }
    public BigDecimal getInterestDisplay() {
        return wiborPercent.add(bankMarginPercent).setScale(2, RoundingMode.HALF_UP);
    }
}
