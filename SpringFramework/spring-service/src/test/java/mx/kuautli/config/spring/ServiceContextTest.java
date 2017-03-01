package mx.kuautli.config.spring;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.kuautli.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceContext.class)
public class ServiceContextTest {
	
	@Autowired
	protected BookService bookService;
	
}
