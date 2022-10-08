package service;

import model.InputData;
import model.Instalment;
import model.InstalmentAmounts;

public interface InstalmentAmountsService {
    InstalmentAmounts calculate(InputData inputData);

    InstalmentAmounts calculate(InputData inputData, Instalment previousInstalment);
}
