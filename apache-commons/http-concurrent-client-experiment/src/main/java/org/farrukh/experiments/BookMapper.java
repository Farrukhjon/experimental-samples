package org.farrukh.experiments;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;

import java.io.IOException;
import java.io.InputStream;

public class BookMapper {

    private ObjectMapper mapper;

    public BookMapper() {
        this.mapper = new ObjectMapper();
    }

    public Book mapToBook(HttpEntity entity) throws IOException {
        Book book;InputStream content = entity.getContent();
        book = mapper.readValue(content, Book.class);
        return book;
    }

}
