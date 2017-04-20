package org.farrukh.experiments;

import java.util.concurrent.Callable;

public class RequestBookTask implements Callable<Book> {

    private BookService bookService;

    private String id;

    public RequestBookTask(String id) {
        this.id = id;
        this.bookService = BookService.getInstance();
    }

    public Book call() throws Exception {
        Book aBook = bookService.getBookById(id);
        return aBook;
    }

}
