package mx.kuautli.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;

import com.cedarsoftware.util.io.JsonWriter;

@Table
@Entity(name = "books_by_author")
public class BooksByAuthor {

	@EmbeddedId
	private BooksByAuthorPK pk;

	public BooksByAuthorPK getPk() {
		return pk;
	}

	public void setPk(BooksByAuthorPK pk) {
		this.pk = pk;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;

		if (!(o instanceof BooksByAuthor))
			return false;

		BooksByAuthor booksByAuthor = (BooksByAuthor) o;

		return new EqualsBuilder()
				.append(this.getPk().getIdAuthor(), booksByAuthor.getPk().getIdAuthor())
				.append(this.getPk().getIsbn(), booksByAuthor.getPk().getIsbn())
				.isEquals();
	}

	@Override
	public String toString() {
		return JsonWriter.objectToJson(this);
	}

	@Embeddable
	public static class BooksByAuthorPK implements Serializable {

		private static final long serialVersionUID = -7667453341227957001L;

		private int idAuthor;

		private String isbn;
		
		public BooksByAuthorPK(){
			
		}

		public int getIdAuthor() {
			return idAuthor;
		}

		public void setIdAuthor(int idAuthor) {
			this.idAuthor = idAuthor;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + idAuthor;
			result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object o) {

			if (this == o)
				return true;

			if (!(o instanceof BooksByAuthorPK))
				return false;

			BooksByAuthorPK booksByAuthorPK = (BooksByAuthorPK) o;

			return new EqualsBuilder()
					.append(this.getIdAuthor(), booksByAuthorPK.getIdAuthor())
					.append(this.getIsbn(), booksByAuthorPK.getIsbn())
					.isEquals();
		}
	}

}
