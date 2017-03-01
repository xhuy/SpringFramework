package mx.kuautli.service;

import java.util.List;

import mx.kuautli.model.Book;

public interface BookService {
	List<Book> findByTitle(String title);
}
