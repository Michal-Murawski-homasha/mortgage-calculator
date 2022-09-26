package service;

import model.InputData;

import java.io.DataInput;

public interface PrintingService {
    String INTEREST_SUM = "SUMA ODSETEK";
    String NUMBER_INSTALMENT = "NR: ";
    String YEAR = "ROK: ";
    String MONTH = "MIESIĄC";
    String DAY = "DZIEŃ";
    String INSTALMENT = "RATA: ";
    String INTEREST = "ODSETKI: ";
    String CAPITAL = "KAPITAŁ: ";
    String LEFT = "POZOSTAŁO: ";
    String MORTGAGE_AMOUNT = "KWOTA KREDYTU: ";
    String MORTGAGE_PERIOD = "OKRES KREDYTOWANIA";

    String CURRENCY = "PLN";
    String SPACE = "\n";
    String PERCENT = "%";

    void printInputDateInfo(final InputData inputData);
}
