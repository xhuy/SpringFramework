package mx.kuautli.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import mx.kuautli.context.PersistenceContextTest;
import mx.kuautli.model.Author;
import mx.kuautli.model.Book;
import mx.kuautli.model.BooksByAuthor;
import mx.kuautli.model.BooksByAuthor.BooksByAuthorPK;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BooksByAuthorRepositoryTest extends PersistenceContextTest{

	@Test
	@Transactional
	@Commit
	public void aCreateBooksByAuthor(){
		
		Author authorActual = new Author();
		authorActual.setIdAuthor(123);
		authorActual.setFirstName("Key");
		authorActual.setLastName("Compound");
		authorsRepository.save(authorActual);
		
		Book bookActual = new Book();
		bookActual.setIsbn("321");
		bookActual.setTitle("Two columns");
		bookActual.setDateOfPublication(LocalDateTime.now().toLocalDate()); 
		booksRepository.save(bookActual);
		
		BooksByAuthor bookByAuthor = new BooksByAuthor();
		BooksByAuthorPK pk = new BooksByAuthorPK();
		pk.setIdAuthor(123);
		pk.setIsbn("321");
		bookByAuthor.setPk(pk);
		
		booksByAuthorRepository.saveAndFlush(bookByAuthor);
		
		BooksByAuthorPK expected = new BooksByAuthorPK();
		expected.setIdAuthor(123);
		expected.setIsbn("321");
		
	    assertThat(
	    		"Must be the same object", 
	    		"321", 
	    		equalTo(booksByAuthorRepository.getOne(expected).getPk().getIsbn())); 
	}
	
	@Test
	@Transactional(noRollbackFor=JpaObjectRetrievalFailureException.class)
	@Commit
	public void bDeleteAuthor(){
		
		BooksByAuthor bookByAuthor = new BooksByAuthor();
		BooksByAuthorPK pk = new BooksByAuthorPK();
		pk.setIdAuthor(123);
		pk.setIsbn("321");
		bookByAuthor.setPk(pk);
		
		booksByAuthorRepository.delete(bookByAuthor);
		
		booksByAuthorRepository.flush();
		
		try{
			booksByAuthorRepository.getOne(pk);	
		}
		catch (JpaObjectRetrievalFailureException e){
			
		}
		catch (Exception error){
			Assert.fail("Should be Entity Not Found Exception");
		}
	    
		Author authorActual = new Author();
		authorActual.setIdAuthor(123);
		authorsRepository.delete(authorActual);
		
		Book bookActual = new Book();
		bookActual.setIsbn("321");
		booksRepository.delete(bookActual);
	}

}
