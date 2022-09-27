package service;

import model.InputData;
import model.Instalment;

import java.util.List;

public class MortgageCalculationService implements IMortgageCalculationService {

    private final IPrintingService printingService;

    private final IInstalmentCalculationService IInstalmentCalculationService;

    public MortgageCalculationService(IPrintingService printingService, IInstalmentCalculationService instalmentCalculationService) {
        this.printingService = printingService;
        this.IInstalmentCalculationService = instalmentCalculationService;
    }

    @Override
    public void calculate(InputData inputData) {
        printingService.printInputDateInfo(inputData);

        List<Instalment> calculate = IInstalmentCalculationService.calculate(inputData);
    }
}
