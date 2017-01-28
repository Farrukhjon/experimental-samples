package org.farrukh.examples.spring.batch.listener;

import org.farrukh.examples.spring.batch.domain.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemProcessListener;

public class LogProcessorListener implements ItemProcessListener<Greeting, Greeting> {

    private final static Logger logger = LoggerFactory.getLogger(LogProcessorListener.class);

    @Override
    public void beforeProcess(final Greeting item) {

    }

    @Override
    public void afterProcess(final Greeting item, final Greeting result) {
        if (item != null)
            logger.info("Input to Processor: " + item.toString());
        if (result != null)
            logger.info("Output of Processor: " + result.toString());
    }

    @Override
    public void onProcessError(final Greeting item, final Exception e) {

    }

}
