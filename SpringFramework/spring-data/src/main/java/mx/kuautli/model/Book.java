package mx.kuautli.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;

import com.cedarsoftware.util.io.JsonWriter;

@Table
@Entity(name="books")
public class Book {

	@Id
	@Column
	private String isbn;
	
	@Column
	private String title;
	
	@Column(name="date_of_publication")
	private LocalDate dateOfPublication;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(LocalDate dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	@Override
	public boolean equals(Object o) {
		
		if(this == o)
			return true;
		
        if (!(o instanceof Book)) 
            return false;
        
		Book book = (Book) o;
        
		return new EqualsBuilder()
				.append(this.getIsbn(), book.getIsbn())
				.append(this.getTitle(), book.getTitle())
				.append(this.getDateOfPublication(), book.getDateOfPublication())
				.isEquals();
	}

	@Override
	public String toString() {
		return JsonWriter.objectToJson(this);
	}

}
