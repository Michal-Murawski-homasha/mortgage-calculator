package service;

import model.*;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class InstalmentCalculationService implements IInstalmentCalculationService {
    private final TimePointService timePointService;
    private final InstalmentAmountsService instalmentAmountsService;
    private final MortgageResidualService mortgageResidualService;

    public InstalmentCalculationService(TimePointService timePointService,
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
        TimePoint timePoint = timePointService.calculate();
        InstalmentAmounts instalmentAmounts = instalmentAmountsService.calculate();
        MortgageResidual mortgageResidual = mortgageResidualService.calculate();

        return new Instalment(instalmentsNumber, timePoint, instalmentAmounts, mortgageResidual);
    }

    private Instalment calculateInstalment(BigDecimal instalmentsNumber, InputData inputData, Instalment previewsInstalment) {
        TimePoint timePoint = timePointService.calculate();
        InstalmentAmounts instalmentAmounts = instalmentAmountsService.calculate();
        MortgageResidual mortgageResidual = mortgageResidualService.calculate();

        return new Instalment(instalmentsNumber, timePoint, instalmentAmounts, mortgageResidual);
    }
}
