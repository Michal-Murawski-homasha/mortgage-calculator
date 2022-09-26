import model.InputData;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        InputData inputData = new InputData()
                .withAmount(new BigDecimal(2980000))
                .withNumberInstalments(BigDecimal.valueOf(160));
    }
}