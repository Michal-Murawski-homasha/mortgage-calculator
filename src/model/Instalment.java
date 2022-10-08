package model;

import java.math.BigDecimal;

public class Instalment {
    private final BigDecimal instalmentNumber;
    private final TimePoint timePoint;
    private final InstalmentAmounts instalmentAmounts;
    private final MortgageResidual mortgageResidual;

    public Instalment(BigDecimal instalmentNumber, TimePoint timePoint, InstalmentAmounts instalmentAmounts, MortgageResidual mortgageResidual) {
        this.instalmentNumber = instalmentNumber;
        this.timePoint = timePoint;
        this.instalmentAmounts = instalmentAmounts;
        this.mortgageResidual = mortgageResidual;
    }

    public BigDecimal getInstalmentNumber() {
        return instalmentNumber;
    }

    public TimePoint getTimePoint() {
        return timePoint;
    }

    public InstalmentAmounts getInstalmentAmounts() {
        return instalmentAmounts;
    }

    public MortgageResidual getMortgageResidual() {
        return mortgageResidual;
    }

    @Override
    public String toString() {
        return "Instalment{" +
                "instalmentAmounts=" + instalmentAmounts +
                ", mortgageResidual=" + mortgageResidual +
                '}';
    }
}
