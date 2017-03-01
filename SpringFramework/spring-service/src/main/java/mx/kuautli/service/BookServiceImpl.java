package mx.kuautli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.kuautli.model.Book;
import mx.kuautli.repository.BooksRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BooksRepository bookRepository;

	@Override
	public List<Book> findByTitle(String title) {
		return bookRepository.findByTitleLike(title);
	}

}
