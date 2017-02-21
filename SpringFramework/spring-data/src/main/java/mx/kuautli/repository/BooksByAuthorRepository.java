package mx.kuautli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.kuautli.model.BooksByAuthor;
import mx.kuautli.model.BooksByAuthor.BooksByAuthorPK;

@Repository
public interface BooksByAuthorRepository extends JpaRepository<BooksByAuthor, BooksByAuthorPK>{
	
}
