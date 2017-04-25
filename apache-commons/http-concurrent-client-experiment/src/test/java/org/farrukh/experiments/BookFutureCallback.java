package org.farrukh.experiments;

import org.apache.http.concurrent.FutureCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookFutureCallback implements FutureCallback<Book> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookFutureCallback.class);

    @Override
    public void completed(Book result) {
        LOGGER.info("Retrieved the book: ", result);
    }

    @Override
    public void failed(Exception ex) {

    }

    @Override
    public void cancelled() {

    }
}
