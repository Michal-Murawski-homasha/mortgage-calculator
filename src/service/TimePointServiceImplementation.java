package service;

import model.InputData;
import model.TimePoint;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TimePointServiceImplementation implements TimePointService {
    private static final BigDecimal YEAR = BigDecimal.valueOf(12);

    @Override
    public TimePoint calculate(BigDecimal instalmentsNumber, InputData inputData) {
        LocalDate date = getLocalDate(instalmentsNumber, inputData);
        BigDecimal year = calculateYear(instalmentsNumber);
        BigDecimal month = calculateMonth(instalmentsNumber);

        return new TimePoint(date, year, month);
    }

    private static LocalDate getLocalDate(BigDecimal instalmentsNumber, InputData inputData) {
        return inputData.getRepaymentStartDay().
                plus(instalmentsNumber.subtract(BigDecimal.ONE).intValue(), ChronoUnit.MONTHS);
    }

    private BigDecimal calculateYear(final BigDecimal instalmentNumber) {
        return instalmentNumber.divide(YEAR, RoundingMode.UP).max(BigDecimal.ONE);
    }

    private BigDecimal calculateMonth(final BigDecimal instalmentNumber) {
        return BigDecimal.ZERO.equals(instalmentNumber.remainder(YEAR)) ? YEAR : instalmentNumber.remainder(YEAR);
    }
}
