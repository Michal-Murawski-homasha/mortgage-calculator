package service;

import model.InputData;
import model.Instalment;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class InstalmentCalculationService implements IInstalmentCalculationService {

    @Override
    public List<Instalment> calculate(InputData inputData) {
        List<Instalment> instalments = new LinkedList<>();
        BigDecimal instalmentsNumber = BigDecimal.ONE;
        Instalment firstInstalment = calculateFirstInstalment(instalmentsNumber, inputData);
        instalments.add(firstInstalment);
        Instalment previewsInstalment = firstInstalment;

        for (BigDecimal index = instalmentsNumber.add(BigDecimal.ONE);
             instalmentsNumber.compareTo(inputData.getNumberInstalments()) <= 0;
             index = index.add(BigDecimal.ONE)) {
                Instalment nextInstalment = calculateNextInstalment(index, inputData, previewsInstalment);
                instalments.add(nextInstalment);
                previewsInstalment = nextInstalment;
        }
        return instalments;
    }

    private Instalment calculateFirstInstalment(BigDecimal instalmentsNumber, InputData inputData) {
        return null;
    }

    private Instalment calculateNextInstalment(BigDecimal index, InputData inputData, Instalment previewsInstalment) {
        return null;
    }
}
