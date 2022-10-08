import model.InputData;
import service.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        InputData inputData = new InputData()
                .withAmount(new BigDecimal(2980000))
                .withNumberInstalments(BigDecimal.valueOf(160));

        PrintingService printingService = new PrintingServiceImplementation();
        InstalmentCalculationService instalmentCalculationService = new InstalmentCalculationServiceImplementation(
                new TimePointServiceImplementation(),
                new InstalmentAmountsServiceImplementation(),
                new MortgageResidualServiceImplementation()
        );

        MortgageCalculationService mortgageCalculationService = new MortgageCalculationServiceImplementation(printingService, instalmentCalculationService);
        mortgageCalculationService.calculate(inputData);
    }
}