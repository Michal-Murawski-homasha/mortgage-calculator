package service;

import model.InputData;
import model.Instalment;
import model.InstalmentAmounts;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InstalmentAmountsServiceImplementation implements InstalmentAmountsService {
    private static final BigDecimal YEAR = BigDecimal.valueOf(12);

    @Override
    public InstalmentAmounts calculate(InputData inputData) {
        switch (inputData.getTypeInstalments()) {
            case CONSTANT:
                return instalmentCalculateConstant(inputData);
            case DECREASING:
                return instalmentCalculateDecreasing(inputData);
            default:
                throw new RuntimeException("Case not handled");
        }
    }

    @Override
    public InstalmentAmounts calculate(InputData inputData, Instalment previousInstalment) {
        switch (inputData.getTypeInstalments()) {
            case CONSTANT:
                return instalmentCalculateConstant(inputData, previousInstalment);
            case DECREASING:
                return instalmentCalculateDecreasing(inputData, previousInstalment);
            default:
                throw new RuntimeException("Case not handled");
        }
    }

    private InstalmentAmounts instalmentCalculateConstant(InputData inputData) {
        BigDecimal interestPercent = inputData.getInterestPercent();
        BigDecimal residualAmount = inputData.getAmount();

        BigDecimal q = calculateQ(interestPercent);

        BigDecimal instalmentAmount = instalmentCalculateConstantAmount(q, inputData.getAmount(), inputData.getNumberInstalments());
        BigDecimal interestAmount = instalmentInterestAmount(residualAmount, interestPercent);
        BigDecimal capitalAmount = instalmentConstantCapitalAmount(instalmentAmount, interestAmount);

        return new InstalmentAmounts(instalmentAmount, interestAmount, capitalAmount);
    }

    private InstalmentAmounts instalmentCalculateConstant(InputData inputData, Instalment previousInstalment) {
        BigDecimal interestPercent = inputData.getInterestPercent();
        BigDecimal residualAmount = previousInstalment.getMortgageResidual().getAmount();

        BigDecimal q = calculateQ(interestPercent);

        BigDecimal instalmentAmount = instalmentCalculateConstantAmount(q, inputData.getAmount(), inputData.getNumberInstalments());
        BigDecimal interestAmount = instalmentInterestAmount(residualAmount, interestPercent);
        BigDecimal capitalAmount = instalmentConstantCapitalAmount(instalmentAmount, interestAmount);

        return new InstalmentAmounts(instalmentAmount, interestAmount, capitalAmount);
    }

    private InstalmentAmounts instalmentCalculateDecreasing(InputData inputData) {
        BigDecimal interestPercent = inputData.getInterestPercent();
        BigDecimal residualAmount = inputData.getAmount();

        BigDecimal interestAmount = instalmentInterestAmount(residualAmount, interestPercent);
        BigDecimal capitalAmount = instalmentDecreasingCapitalAmount(residualAmount, inputData.getNumberInstalments());
        BigDecimal instalmentAmount = capitalAmount.add(interestAmount);

        return new InstalmentAmounts(instalmentAmount, interestAmount, capitalAmount);
    }

    private InstalmentAmounts instalmentCalculateDecreasing(InputData inputData, Instalment previousInstalment) {
        BigDecimal interestPercent = inputData.getInterestPercent();
        BigDecimal residualAmount = previousInstalment.getMortgageResidual().getAmount();

        BigDecimal interestAmount = instalmentInterestAmount(residualAmount, interestPercent);
        BigDecimal capitalAmount = instalmentDecreasingCapitalAmount(inputData.getAmount(), inputData.getNumberInstalments());
        BigDecimal instalmentAmount = capitalAmount.add(interestAmount);

        return new InstalmentAmounts(instalmentAmount, interestAmount, capitalAmount);
    }

    private BigDecimal calculateQ(BigDecimal interestPercent) {
        return interestPercent.divide(YEAR, 10, RoundingMode.HALF_UP).add(BigDecimal.ONE);
    }

    private BigDecimal instalmentCalculateConstantAmount(BigDecimal q, BigDecimal amount, BigDecimal numberInstalments) {
        return amount
                .multiply(q.pow(numberInstalments.intValue()))
                .multiply(q.subtract(BigDecimal.ONE))
                .divide(q.pow(numberInstalments.intValue()).subtract(BigDecimal.ONE), 2, RoundingMode.HALF_UP);
    }

    private BigDecimal instalmentInterestAmount(BigDecimal residualAmount, BigDecimal interestPercent) {
        return residualAmount.multiply(interestPercent).divide(YEAR, 2, RoundingMode.HALF_UP);
    }

    private BigDecimal instalmentConstantCapitalAmount(BigDecimal instalmentAmount, BigDecimal interestAmount) {
        return instalmentAmount.subtract(interestAmount);
    }

    private BigDecimal instalmentDecreasingCapitalAmount(BigDecimal amount, BigDecimal numberInstalments) {
        return amount.divide(numberInstalments, 2, RoundingMode.HALF_UP);
    }
}
