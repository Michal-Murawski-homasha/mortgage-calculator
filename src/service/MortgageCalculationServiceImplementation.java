package service;

import model.InputData;
import model.Instalment;

import java.util.List;

public class MortgageCalculationServiceImplementation implements MortgageCalculationService {

    private final PrintingService printingService;

    private final InstalmentCalculationService InstalmentCalculationService;

    public MortgageCalculationServiceImplementation(PrintingService printingService, InstalmentCalculationService instalmentCalculationService) {
        this.printingService = printingService;
        this.InstalmentCalculationService = instalmentCalculationService;
    }

    @Override
    public void calculate(InputData inputData) {
        printingService.printInputDateInfo(inputData);

        List<Instalment> instalments = InstalmentCalculationService.calculate(inputData);

    }
}
