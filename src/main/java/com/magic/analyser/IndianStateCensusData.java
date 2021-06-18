package com.magic.analyser;

import com.opencsv.bean.CsvBindByName;
public class IndianStateCensusData {

    @CsvBindByName(column = "State")
    public String state;
    @CsvBindByName(column = "Population")
    public long population;
    @CsvBindByName(column = "AreaInSqKm" )
    public long areaInSqKm;
    @CsvBindByName(column = "DensityPerSqKm")
    public long densityPerSqKm;
}

