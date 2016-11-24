package org.farrukh.experiments.quickfixj.client.processor;

public interface MarketOperation {
    
    void buy(Security security);
    
    void sell(Security security);

}
