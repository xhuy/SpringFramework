package mx.kuautli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.kuautli.model.Author;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Integer>{
	
	public List<Author> findByFirstNameLike(String name);

	public List<Author> findByLastNameLike(String name);
	
}
