package service;

import model.InputData;
import model.Instalment;

import java.util.List;

public interface IInstalmentCalculationService {
    List<Instalment> calculate(final InputData inputData);
}
