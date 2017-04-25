package org.farrukh.experiments;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    private static BookService instance;

    private PooledConcurrentWebClientUtil pooledConcurrentWebClientUtil;

    private BookMapper bookMapper;

    public BookService() {
        pooledConcurrentWebClientUtil = new PooledConcurrentWebClientUtil();
        bookMapper = new BookMapper();
    }

    public Book getBookById(String id) {
        CloseableHttpResponse response = null;
        try {
            response = pooledConcurrentWebClientUtil.request(id);
            HttpEntity entity = response.getEntity();
            long contentLength = entity.getContentLength();
            Book book = null;
            if (contentLength > 0) {
                book = bookMapper.mapToBook(entity);
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
