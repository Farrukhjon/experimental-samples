package org.farrukh.experiments;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockserver.mock.action.ExpectationCallback;
import org.mockserver.model.Header;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import java.util.Arrays;

import static org.mockserver.model.HttpResponse.response;

public class MockServerResponseCallback implements ExpectationCallback {

    private ObjectMapper mapper = new ObjectMapper();

    public HttpResponse handle(HttpRequest httpRequest) {
        String bookId = httpRequest.getQueryStringParameters().get(0).getValues().get(0).getValue();
        HttpResponse httpResponse = response()
                .withHeaders(
                        new Header("Content-Type", "application/json; charset=utf-8")
                )
                .withStatusCode(200)
                .withBody(generateJsonBook(bookId));
        return httpResponse;
    }

    private String generateJsonBook(String bookId) {
        Book book = new Book();
        Author author = new Author();
        author.setName("Alex");
        book.setAuthors(Arrays.asList(author));
        book.setId(bookId);
        book.setName("Book " + bookId);
        try {
            String jsonBook = mapper.writeValueAsString(book);
            return jsonBook;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
