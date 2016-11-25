package org.farrukh.experiments.quickfixj.server;

import java.util.ArrayList;
import java.util.List;

import quickfix.field.SecurityReportID;
import quickfix.fix50sp2.SecurityDefinition;
import quickfix.fix50sp2.TradeCaptureReport;
import quickfix.fix50sp2.component.Instrument;

public class InMemoryMarketDataProviderStub {
    
    private final List<SecurityDefinition> securityDefinitions;
    
    private final List<Instrument> instruments;
    
    private final List<TradeCaptureReport> tradeCaptureReports;
    
    public InMemoryMarketDataProviderStub() {
        securityDefinitions = new ArrayList<>();
        instruments = new ArrayList<>();
        tradeCaptureReports = new ArrayList<>();
        populateSecurityDefinitions(securityDefinitions);
        populateTradeCaptureReports(tradeCaptureReports);
    }

    private void populateSecurityDefinitions(List<SecurityDefinition> messages) {
        if(messages == null) {
            throw new IllegalArgumentException("Init before pass!");
        }
        SecurityDefinition securityDefinition = new SecurityDefinition();
        securityDefinition.set(new SecurityReportID());
        messages.add(securityDefinition);
    }

    private void populateTradeCaptureReports(List<TradeCaptureReport> tradeCaptureReports) {
        TradeCaptureReport tradeCaptureReport = new TradeCaptureReport();
        tradeCaptureReports.add(tradeCaptureReport);
    }

    public List<SecurityDefinition> getSecurityDefinitions() {
        return securityDefinitions;
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public List<TradeCaptureReport> getTradeCaptureReports() {
        return tradeCaptureReports;
    }

}
