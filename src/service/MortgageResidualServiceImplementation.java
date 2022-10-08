package service;

import model.InputData;
import model.Instalment;
import model.InstalmentAmounts;
import model.MortgageResidual;

import java.math.BigDecimal;

public class MortgageResidualServiceImplementation implements MortgageResidualService {
    @Override
    public MortgageResidual calculate(InstalmentAmounts instalmentAmounts, InputData inputData) {
        BigDecimal residualAmount = inputData.getAmount().subtract(instalmentAmounts.getCapitalAmount());
        BigDecimal residualDuration = inputData.getNumberInstalments().subtract(BigDecimal.ONE);

        return new MortgageResidual(residualAmount, residualDuration);
    }

    @Override
    public MortgageResidual calculate(InstalmentAmounts instalmentAmounts, Instalment previousInstalment) {
        MortgageResidual residual = previousInstalment.getMortgageResidual();

        BigDecimal residualAmount = residual.getAmount().subtract(instalmentAmounts.getCapitalAmount());
        BigDecimal residualDuration = residual.getDuration().subtract(BigDecimal.ONE);

        return new MortgageResidual(residualAmount, residualDuration);
    }
}
