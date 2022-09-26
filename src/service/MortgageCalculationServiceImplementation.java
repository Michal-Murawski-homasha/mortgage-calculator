package service;

import model.InputData;
import model.Instalment;

import java.util.List;

public class MortgageCalculationServiceImplementation implements MortgageCalculationService {

    private final PrintingService printingService;

    private final InstalmentCalculationService instalmentCalculationService;

    public MortgageCalculationServiceImplementation(PrintingService printingService, InstalmentCalculationService instalmentCalculationService) {
        this.printingService = printingService;
        this.instalmentCalculationService = instalmentCalculationService;
    }

    @Override
    public void calculate(InputData inputData) {
        printingService.printInputDateInfo(inputData);

        List<Instalment> calculate = instalmentCalculationService.calculate(inputData);
    }
}
