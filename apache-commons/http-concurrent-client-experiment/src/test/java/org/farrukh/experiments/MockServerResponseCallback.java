package org.farrukh.experiments;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockserver.matchers.HttpRequestMatcher;
import org.mockserver.mock.action.ExpectationCallback;
import org.mockserver.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.mockserver.model.Header.header;
import static org.mockserver.model.HttpResponse.response;

public class MockServerResponseCallback implements ExpectationCallback {

    private static final Logger LOGGER = LoggerFactory.getLogger(MockServerResponseCallback.class);

    private ObjectMapper mapper = new ObjectMapper();

    public HttpResponse handle(HttpRequest httpRequest) {
        List<Parameter> parameters = httpRequest.getQueryStringParameters();
        String bookId = parameters.get(0).getValues().get(0).getValue();
        LOGGER.info("Responding to the client with asset id: {}", bookId);
        return response()
                .withHeaders(
                        header("Content-Type", "application/json; charset=utf-8")
                )
                .withStatusCode(200)
                .withBody(generateJsonBook(bookId));
    }

    private String generateJsonBook(String bookId) {
        Book book = new Book();
        Author author = new Author();
        author.setName("Alex");
        book.setAuthors(Arrays.asList(author));
        book.setId(bookId);
        book.setName("Book " + bookId);
        try {
            return mapper.writeValueAsString(book);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
