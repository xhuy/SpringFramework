package mx.kuautli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;

import com.cedarsoftware.util.io.JsonWriter;

@Table
@Entity(name="author")
public class Author {

	@Id
	private Integer idAuthor;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	public Integer getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(Integer idAuthor) {
		this.idAuthor = idAuthor;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public boolean equals(Object o) {
		
		if(this == o)
			return true;
		
        if (!(o instanceof Author)) 
            return false;
        
        Author author = (Author) o;
        
		return new EqualsBuilder()
				.append(this.getIdAuthor(), author.getIdAuthor())
				.append(this.getFirstName(), author.getFirstName())
				.append(this.getLastName(), author.getLastName())
				.isEquals();
	}

	@Override
	public String toString() {
		return JsonWriter.objectToJson(this);
	}
	
}
