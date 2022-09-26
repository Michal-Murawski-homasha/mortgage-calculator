package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InputData {
    private LocalDate repaymentStartDay = LocalDate.of(2022, 10, 10);
    private BigDecimal wiborPercent = new BigDecimal(1.73);
    private BigDecimal amount = new BigDecimal(300000);
    private BigDecimal numberInstalments = new BigDecimal(180);
    private TypeInstalments typeInstalments = TypeInstalments.CONSTANT;
    private BigDecimal bankMargin = new BigDecimal(1.9);


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
    public InputData withBankMargin(BigDecimal bankMargin) {
        this.bankMargin = bankMargin;
        return this;
    }






    public LocalDate getRepaymentStartDay() {
        return repaymentStartDay;
    }

    public BigDecimal getWiborPercent() {
        return wiborPercent;
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

    public BigDecimal getBankMargin() {
        return bankMargin;
    }
}
