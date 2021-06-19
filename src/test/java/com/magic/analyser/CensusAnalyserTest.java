package com.magic.analyser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
    private static final String INDIAN_CENSUS_CSV_FILE_PATH ="D:\\Indian State Census Analyzer\\src\\test\\resources\\StateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "D:\\Indian State Census Analyzer\\src\\main\\resources\\StateCensusData.csv";
    private static final String WRONG_FILE_TYPE = "D:\\Indian State Census Analyzer\\src\\main\\resources\\StateCensusData.xls";
    @Test
    public void givenIndianCensusCSC_WhenChecked_ShouldReturnCorrectRecords() {
        StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
        int count = 0;
        try {
            count = censusAnalyser.loadCensus(INDIAN_CENSUS_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
        }
        Assertions.assertEquals(29, count);
    }
    @Test
    public void givenIndianCensusCSV_WhenWrongFile_ShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadCensus(WRONG_CSV_FILE_PATH);
        } catch(CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }

    }
    @Test
    public void givenWrongFileType_WhenChecked_ShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadCensus(WRONG_FILE_TYPE);
        } catch(CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.WRONG_TYPE, e.type);
        }
    }
}
