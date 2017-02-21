package mx.kuautli.context;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.kuautli.config.spring.PersistenceJPAConfig;
import mx.kuautli.repository.AuthorsRepository;
import mx.kuautli.repository.BooksByAuthorRepository;
import mx.kuautli.repository.BooksRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceJPAConfig.class)
public class PersistenceContextTest {

	@Autowired
	protected BooksRepository booksRepository;

	@Autowired
	protected AuthorsRepository authorsRepository;

	@Autowired
	protected BooksByAuthorRepository booksByAuthorRepository;

}
