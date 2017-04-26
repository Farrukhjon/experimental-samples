package org.farrukh.experiments;

import org.apache.http.HttpEntity;
import org.apache.http.impl.client.AbstractResponseHandler;

import java.io.IOException;

/**
 * Created by fsattorov on 26.04.2017.
 */
public class BookResponseHandler extends AbstractResponseHandler<Book> {

    private BookMapper bookMapper;

    public BookResponseHandler() {
        bookMapper = new BookMapper();
    }

    @Override
    public Book handleEntity(HttpEntity entity) throws IOException {
        return bookMapper.mapToBook(entity);
    }
}
