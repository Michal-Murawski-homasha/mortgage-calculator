package service;

import model.InputData;

public class MortgageCalculationServiceImplementation implements MortgageCalculationService {

    private final PrintingService printingService;

    public MortgageCalculationServiceImplementation(PrintingService printingService) {
        this.printingService = printingService;
    }

    @Override
    public void calculate(InputData inputData) {
        printingService.printInputDateInfo(inputData);
    }
}
