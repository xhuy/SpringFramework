package mx.kuautli.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import mx.kuautli.context.PersistenceContextTest;
import mx.kuautli.model.Author;;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorsRepositoryTest extends PersistenceContextTest {

	@Test
	public void aCreateAuthor(){
		
		Author authorActual = new Author();
		authorActual.setIdAuthor(777);
		authorActual.setFirstName("Mctester");
		authorActual.setLastName("testerson");
		
		Author authorExpected = new Author();
		authorExpected.setIdAuthor(777);
		authorExpected.setFirstName("Mctester");
		authorExpected.setLastName("testerson");
		
	    assertThat(
	    		"Must be the same object", 
	    		authorExpected, 
	    		equalTo(authorsRepository.saveAndFlush(authorExpected))); 
	    
	}
	
	@Test
	@Transactional
	@Commit
	public void bEditAuthor(){

		Author authorActual = new Author();
		authorActual = authorsRepository.getOne(777);
		authorActual.setLastName("edit test");
		authorsRepository.saveAndFlush(authorActual);
	
	    assertThat(
	    		"Must be the same object", 
	    		"edit test", 
	    		equalTo(authorsRepository.getOne(777).getLastName()));
	}
	
	@Test
	public void cDeleteAuthor(){
		Author book = new Author();
		book.setIdAuthor(777);
		
		authorsRepository.delete(book);
		
		assertThat("Must be deleted", null, equalTo((authorsRepository.findOne(book.getIdAuthor()))));
		
	}

}
