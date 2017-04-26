package org.farrukh.experiments;

import org.apache.http.concurrent.FutureCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class BookFutureCallback implements FutureCallback<Book> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookFutureCallback.class);

    CountDownLatch theLatch;

    public BookFutureCallback(CountDownLatch aLatch) {
        this.theLatch = aLatch;
    }

    @Override
    public void completed(Book result) {
        LOGGER.info("Retrieved the book: ", result);
        theLatch.countDown();
    }

    @Override
    public void failed(Exception ex) {
        LOGGER.error("failed: {}", ex);
        theLatch.countDown();
    }

    @Override
    public void cancelled() {
        LOGGER.warn("cancelled");
        theLatch.countDown();
    }
}
