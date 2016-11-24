package org.farrukh.experiments.quickfixj.client;

import edu.emory.mathcs.backport.java.util.concurrent.ExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.Executors;

public class MarketMsgProcessor implements Runnable {
    
    private ExecutorService executorPool;

    public MarketMsgProcessor() {
        executorPool = Executors.newSingleThreadExecutor();
    }

    @Override
    public void run() {
        
    }
    
    void start() {
        executorPool.execute(this);
    }
    
    void stop() {
        executorPool.shutdown();
    }

}
