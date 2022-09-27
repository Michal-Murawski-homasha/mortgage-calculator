package service;

import model.InputData;

public interface IPrintingService {
    String INTEREST_SUM = "SUMA ODSETEK";
    String NUMBER_INSTALMENT = "NR: ";
    String YEAR = "ROK: ";
    String MONTH = " MIESIĘCY";
    String DAY = " DZIEŃ";
    String INSTALMENT = "RATA: ";
    String INTEREST = "OPROCENTOWANIE: ";
    String CAPITAL = "KAPITAŁ: ";
    String LEFT = "POZOSTAŁO: ";
    String MORTGAGE_AMOUNT = "KWOTA KREDYTU: ";
    String MORTGAGE_PERIOD = "OKRES KREDYTOWANIA: ";

    String CURRENCY = "PLN";
    String NEW_LINE = "\n";
    String PERCENT = "%";

    void printInputDateInfo(final InputData inputData);
}