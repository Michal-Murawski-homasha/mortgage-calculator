import model.InputData;
import model.InstalmentAmounts;
import model.MortgageResidual;
import model.TimePoint;
import service.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        InputData inputData = new InputData()
                .withAmount(new BigDecimal(2980000))
                .withNumberInstalments(BigDecimal.valueOf(160));

        IPrintingService printingService = new PrintingService();
        IInstalmentCalculationService instalmentCalculationService = new InstalmentCalculationService(
                new TimePointServiceImplementation(),
                new InstalmentAmountsServiceImplementation(),
                new MortgageResidualServiceImplementation()
        );

        IMortgageCalculationService mortgageCalculationService = new MortgageCalculationService(printingService, instalmentCalculationService);
        mortgageCalculationService.calculate(inputData);
    }
}