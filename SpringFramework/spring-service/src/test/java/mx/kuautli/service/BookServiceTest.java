package mx.kuautli.service;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import mx.kuautli.config.spring.ServiceContextTest;
import mx.kuautli.model.Book;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.anyOf;

public class BookServiceTest extends ServiceContextTest{
	
	@Test
	public void findByTitleTest(){
		String titleToSearch = "test junit";
		List<Book> books = bookService.findByTitle(titleToSearch);
		
		List<String> filtered = 
				books
				.stream()
				.map(Book::getTitle)
				.filter(title ->  title.contains(titleToSearch))
				.collect(Collectors.toList());
		
		assertThat("All the books finded must have test", filtered, anyOf(contains(titleToSearch)));
	}

}
