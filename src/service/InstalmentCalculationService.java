package service;

import model.InputData;
import model.Instalment;

import java.util.List;

public interface InstalmentCalculationService {
    List<Instalment> calculate(final InputData inputData);
}
