package edt;

import java.io.Serializable;

public class Author implements Comparable<Author>, Serializable{
	/** The Author's name. */
	private String _name;

	/** The Author's email. */
	private String _email;
	
	/**
	 * Author's constructor.
	 *
	 * @param name The Author's name.
	 * @param email The Author's email.
	 */
	public Author(String name, String email) {
		_name = name;
		_email = email;
	}

	/** @return the Author's name. */
	public String getName(){ return _name; }

	/** @return the Author's email. */
	public String getEmail(){ return _email; }
	
	/** @param object The object to be compared to the current Author. */
	@Override
	public boolean equals(Object object){
		if(object instanceof Author){
			Author author = (Author) object;
			return author.getEmail().equals(getEmail()) && author.getName().equals(getName());
		}
		return false;
	}

	/**
	 * @param author The author to be compared to the current Author.
	 * @return the comparation value.
	 */
	@Override
	public int compareTo(Author author){
		if (getName().equals(author.getName()))
			return getEmail().compareTo(author.getEmail());
		else
			return getName().compareTo(author.getName());
	}
}