package org.farrukh.experiments;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    private static BookService instance;

    private WebClientUtil webClientUtil;

    private ObjectMapper mapper;

    public BookService() {
        mapper = new ObjectMapper();
        webClientUtil = new WebClientUtil();
    }

    public Book getBookById(String id) {
        CloseableHttpResponse response = null;
        try {
            response = webClientUtil.request(id);
            HttpEntity entity = response.getEntity();
            long contentLength = entity.getContentLength();
            Book book = null;
            if (contentLength > 0) {
                InputStream content = entity.getContent();
                book = mapper.readValue(content, Book.class);
            }
            return book;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
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
