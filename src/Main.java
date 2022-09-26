import model.InputData;
import service.MortgageCalculationService;
import service.MortgageCalculationServiceImplementation;
import service.PrintingService;
import service.PrintingServiceImplementation;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        InputData inputData = new InputData()
                .withAmount(new BigDecimal(2980000))
                .withNumberInstalments(BigDecimal.valueOf(160));

        PrintingService printingService = new PrintingServiceImplementation();
        MortgageCalculationService mortgageCalculationService = new MortgageCalculationServiceImplementation(printingService);
        mortgageCalculationService.calculate(inputData);
    }
}