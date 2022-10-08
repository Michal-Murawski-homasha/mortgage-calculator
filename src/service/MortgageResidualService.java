package service;

import model.InputData;
import model.Instalment;
import model.InstalmentAmounts;
import model.MortgageResidual;

public interface MortgageResidualService {
    MortgageResidual calculate(InstalmentAmounts instalmentAmounts, InputData inputData);
    MortgageResidual calculate(InstalmentAmounts instalmentAmounts, Instalment previousInstalment);
}
