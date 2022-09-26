package service;

import model.InputData;

public class PrintingServiceImplementation implements PrintingService {

    @Override
    public void printInputDateInfo(InputData inputData) {
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(MORTGAGE_AMOUNT).append(inputData.getAmount()).append(CURRENCY);
        msg.append(NEW_LINE);
        msg.append(MORTGAGE_PERIOD).append(inputData.getNumberInstalments()).append(MONTH);
        msg.append(NEW_LINE);
        msg.append(INTEREST).append(inputData.getInterestDisplay()).append(PERCENT);
        msg.append(NEW_LINE);

        printMassage(msg);
    }

    private void printMassage(StringBuilder sb) {
        System.out.println(sb);
    }
}
