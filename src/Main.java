import model.InputData;
import service.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        InputData inputData = new InputData()
                .withAmount(new BigDecimal(2980000))
                .withNumberInstalments(BigDecimal.valueOf(160));

        IPrintingService printingService = new PrintingService();
        IInstalmentCalculationService instalmentCalculationService = new InstalmentCalculationService();

        IMortgageCalculationService mortgageCalculationService = new MortgageCalculationService(printingService, instalmentCalculationService);
        mortgageCalculationService.calculate(inputData);
    }
}