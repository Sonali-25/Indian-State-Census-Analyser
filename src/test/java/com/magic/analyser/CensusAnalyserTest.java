package com.magic.analyser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
    private static final String INDIAN_CENSUS_CSV_FILE_PATH ="D:\\Indian State Census Analyzer\\src\\test\\resources\\StateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "D:\\Indian State Census Analyzer\\src\\main\\resources\\StateCensusData.csv";
    private static final String WRONG_FILE_TYPE = "D:\\Indian State Census Analyzer\\src\\main\\resources\\StateCensusData.xls";
    private static final String INDIAN_CENSUS_CSV_WRONG_DELIMITER = "D:\\Indian State Census Analyzer\\src\\main\\resources\\StateCensusData.csv";
    private static final String INDIAN_CENSUS_CSV_MISSING_HEADER = "D:\\Indian State Census Analyzer\\src\\main\\resources\\StateCensusData.csv";
    private static final String INDIAN_STATE_CODE_CSV_FILE_PATH ="D:\\Indian State Census Analyzer\\src\\test\\resources\\State Code.csv";
    private static final String WRONG_INDIAN_STATE_CODE_CSV_FILE_PATH = "D:\\Indian State Census Analyzer\\src\\main\\resources\\StateCensusData.csv";
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
    @Test
    public void givenWrongDelimiter_InIndiaCensusData_ShouldReturnCustomExceptionType() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            censusAnalyser.loadCensus(INDIAN_CENSUS_CSV_WRONG_DELIMITER);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }
    @Test
    public void givenMissingHeader_InIndiaCensusData_ShouldReturnCustomExceptionType() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            censusAnalyser.loadCensus(INDIAN_CENSUS_CSV_MISSING_HEADER);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }
    @Test
    public void givenStateCensusCSVFile_ShouldMatchNumberOfRecordsInFile() {
        try {
            StateCensusAnalyser codeAnalyser = new StateCensusAnalyser();
            int count = codeAnalyser.loadStateCode(INDIAN_STATE_CODE_CSV_FILE_PATH);
            Assertions.assertEquals(37 , count);
        }catch (CensusAnalyserException e) {
        }
    }
    @Test
    public void givenStateCensusCSVFile_WhenPathIsIncorrect_ShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadStateCode(WRONG_INDIAN_STATE_CODE_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM , e.type);
        }
    }

}
