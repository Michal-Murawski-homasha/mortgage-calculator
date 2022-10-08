package service;

import model.*;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class InstalmentCalculationServiceImplementation implements InstalmentCalculationService {
    private final TimePointService timePointService;
    private final InstalmentAmountsService instalmentAmountsService;
    private final MortgageResidualService mortgageResidualService;

    public InstalmentCalculationServiceImplementation(TimePointService timePointService,
                                                      InstalmentAmountsService instalmentAmountsService,
                                                      MortgageResidualService mortgageResidualService
    ) {
        this.timePointService = timePointService;
        this.instalmentAmountsService = instalmentAmountsService;
        this.mortgageResidualService = mortgageResidualService;
    }

    @Override
    public List<Instalment> calculate(InputData inputData) {
        List<Instalment> instalments = new LinkedList<>();
        BigDecimal instalmentsNumber = BigDecimal.ONE;
        Instalment firstInstalment = calculateInstalment(instalmentsNumber, inputData);
        instalments.add(firstInstalment);
        Instalment previewsInstalment = firstInstalment;

        for (BigDecimal index = instalmentsNumber.add(BigDecimal.ONE);
             instalmentsNumber.compareTo(inputData.getNumberInstalments()) <= 0;
             index = index.add(BigDecimal.ONE)) {
                Instalment nextInstalment = calculateInstalment(index, inputData, previewsInstalment);
                instalments.add(nextInstalment);
                previewsInstalment = nextInstalment;
        }
        return instalments;
    }

    private Instalment calculateInstalment(BigDecimal instalmentsNumber, InputData inputData) {
        TimePoint timePoint = timePointService.calculate(instalmentsNumber, inputData);
        InstalmentAmounts instalmentAmounts = instalmentAmountsService.calculate(inputData);
        MortgageResidual mortgageResidual = mortgageResidualService.calculate(instalmentAmounts, inputData);

        return new Instalment(instalmentsNumber, timePoint, instalmentAmounts, mortgageResidual);
    }

    private Instalment calculateInstalment(BigDecimal instalmentsNumber, InputData inputData, Instalment previousInstalment) {
        TimePoint timePoint = timePointService.calculate(instalmentsNumber, inputData);
        InstalmentAmounts instalmentAmounts = instalmentAmountsService.calculate(inputData, previousInstalment);
        MortgageResidual mortgageResidual = mortgageResidualService.calculate(instalmentAmounts, previousInstalment);

        return new Instalment(instalmentsNumber, timePoint, instalmentAmounts, mortgageResidual);
    }
}
