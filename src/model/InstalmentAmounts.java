package model;

import java.math.BigDecimal;

public class InstalmentAmounts {
    private final BigDecimal instalmentAmount;
    private final BigDecimal interestAmount;
    private final BigDecimal capitalAmount;

    public InstalmentAmounts(BigDecimal instalmentAmount, BigDecimal interestAmount, BigDecimal capitalAmount) {
        this.instalmentAmount = instalmentAmount;
        this.interestAmount = interestAmount;
        this.capitalAmount = capitalAmount;
    }

    public BigDecimal getInstalmentAmount() {
        return instalmentAmount;
    }

    public BigDecimal getInterestAmount() {
        return interestAmount;
    }

    public BigDecimal getCapitalAmount() {
        return capitalAmount;
    }
}
