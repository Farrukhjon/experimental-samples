package org.farrukh.experiments;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;
import java.io.InputStream;

public class BookService {

    private static BookService instance;

    private WebClientUtil webClientUtil;

    private ObjectMapper mapper;

    public BookService() {
        mapper = new ObjectMapper();
    }

    public Book getBookById(String id) {
        CloseableHttpResponse response = null;
        try {
            response = webClientUtil.request(id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return mapToBook(response);
    }

    private Book mapToBook(CloseableHttpResponse response) {
        HttpEntity entity = response.getEntity();
        try {
            InputStream content = entity.getContent();
            return mapper.readValue(content, Book.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BookService getInstance() {
        if (instance == null) {
            synchronized (BookService.class) {
                if (instance == null) {
                    instance = new BookService();
                }
            }
        }
        return instance;
    }
}
