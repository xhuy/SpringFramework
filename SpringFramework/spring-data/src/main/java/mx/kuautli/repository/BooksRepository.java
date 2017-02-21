package mx.kuautli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.kuautli.model.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, String>{
	public List<Book> findByTitleLike(String title);
}
