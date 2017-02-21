package mx.kuautli.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.time.LocalDateTime;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import mx.kuautli.context.PersistenceContextTest;
import mx.kuautli.model.Book;;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BooksRepositoryTest extends PersistenceContextTest {

	@Test
	public void aCreateBook(){
		
		Book bookActual = new Book();
		bookActual.setIsbn("666");
		bookActual.setTitle("test junit");
		bookActual.setDateOfPublication(LocalDateTime.now().toLocalDate());
		
		Book bookExpected = new Book();
		bookExpected.setIsbn("666");
		bookExpected.setTitle("test junit");
		bookExpected.setDateOfPublication(LocalDateTime.now().toLocalDate());
		
	    assertThat(
	    		"Must be the same object", 
	    		bookExpected, 
	    		equalTo(booksRepository.saveAndFlush(bookExpected))); 
	    
	}
	
	@Test
	@Transactional
	@Commit
	public void bEditBook(){

		Book bookActual = new Book();
		bookActual = booksRepository.getOne("666");
		bookActual.setTitle("edit test");
		booksRepository.saveAndFlush(bookActual);
	
	    assertThat(
	    		"Must be the same object", 
	    		"edit test", 
	    		equalTo(booksRepository.getOne("666").getTitle()));
	    
	    booksRepository.flush();
		
	}
	
	@Test
	public void cDeleteBook(){
		Book book = new Book();
		book.setIsbn("666");
		
		booksRepository.delete(book);
		
		assertThat("Must be deleted", null, equalTo((booksRepository.findOne(book.getIsbn()))));
		
	}

}
