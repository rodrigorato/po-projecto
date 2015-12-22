package edt;

import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.io.Serializable;

public class Document extends Section implements Serializable{
	/** The Document's Authors. */
	private Set<Author> _authors = new TreeSet<>();

	/** The Document's Map of unique IDs. */
	private Map<String, TextElement> _uniqueElements = new TreeMap<>();

	/** Initial Document's constructor. */
	public Document(){ super(""); }

	/**
	 * Document's constructor.
	 *
	 * @param title The Document's title.
	 * @param author The Document's first author.
	 */
	public Document(String title, Author author){
		super(title);
		_authors.add(author);
	}

	/** @return the list of Authors. */
	public Set<Author> getAuthors(){ return _authors; }

	/** @return the number of top sections. */
	public int getNumberOfSections(){ return getSections().size(); }

	/** @return the number of mapped elements. */
	public int getNumberOfUniqueIDs(){ return _uniqueElements.size();}

	/**
	 * @param uniqueId The desired text element's unique ID.
	 * @return the text element identified by the unique ID.
	 * @throws NoSuchTextElementException
	 */
	public TextElement getUniqueTextElement(String uniqueId) throws NoSuchTextElementException{
		TextElement unique = _uniqueElements.get(uniqueId);
		if(unique == null)
			throw new NoSuchTextElementException();
		return unique;
	}

	/**
	 * @param author The new author of the Document.
	 * @throws AuthorAlreadyExistsException
	 */
	public void addAuthor(Author author) throws AuthorAlreadyExistsException{
		if(_authors.contains(author))
			throw new AuthorAlreadyExistsException();
		else{ _authors.add(author); }
	}

	/**
	 * Maps a TextElement to his uniqueID.
	 *
	 * @param uniqueID The ID of the TextElement to be added to the Map.
	 * @param textElement The TextElement to be added to the map.
	 * @return true if an element has been renamed, false otherwise.
	 */
	public boolean addUniqueElement(String uniqueID, TextElement textElement) {
		boolean replacedStatus = false;
		if(uniqueID.length() != 0){
			if(_uniqueElements.containsKey(uniqueID)) {
				TextElement elementToRemove = _uniqueElements.get(uniqueID);
				elementToRemove.setID("");
				_uniqueElements.remove(uniqueID);
			}
			if(textElement.hasID()) {
				_uniqueElements.remove(textElement.getID());
				replacedStatus = true;
			}

			_uniqueElements.put(uniqueID, textElement);
			textElement.setID(uniqueID);
		}
		return replacedStatus;
	}

	/** @param element The TextElement to be removed from _mappedElements. */
	public void removeUniqueElement(TextElement element){
			_uniqueElements.remove(element.getID());
	}

	/** @param list The List of TextElements to be removed from _mappedElements. */
	public void removeUniqueElements(List<TextElement> list){
		for(TextElement element : list)
			removeUniqueElement(element);
	}

	/** @param visitor The visitor to which the title of the section information is passed to. */
	public void showSectionInfo(TextElementVisitor visitor){
		visitor.visitDocument(this);
	}

	/** @return the size of the Document's paragraphs and sections. */
	@Override
	public int getSize() {
		int soma = getTitle().length();
		for (Paragraph p : getParagraphs()){
			soma += p.getSize();
		}
		for (Section s : getSections()){
			soma += s.getSize();
		}
		return soma;
	}
}
