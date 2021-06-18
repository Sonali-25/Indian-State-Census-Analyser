package com.magic.analyser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CensusAnalyserTest {
    private static final String INDIAN_CENSUS_CSV_FILE_PATH ="D:\\Indian State Census Analyzer\\src\\test\\resources\\StateCensusData.csv";
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
}
