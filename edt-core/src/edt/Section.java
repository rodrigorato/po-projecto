package edt;

import java.util.List;
import java.util.ArrayList;

public class Section extends TextElement{
	/** The Section's title. */
	private String _title;

	/** The Section's sub sections. */
	private List<Section> _sections = new ArrayList<>();

	/** The Section's paragraphs. */
	private List<Paragraph> _paragraphs = new ArrayList<>();

	/**
	 * Section's constructor.
	 *
	 * @param title The Section's title.
	 */
	public Section(String title){ _title = title;}

	/** @return the Section's title. */
	public String getTitle(){ return _title;}

	/** @return the list of sub sections */
	public List<Section> getSections(){ return _sections;}

	/** @return the list of paragraphs */
	public List<Paragraph> getParagraphs(){ return _paragraphs;}

	/** @param newTitle The Section's new title. */
	public void setTitle(String newTitle){ _title = newTitle;}

	/**
	 * Adds a sub section to the sub sections list.
	 *
	 * @param newSection The new sub section of the Section.
	 */
	public void addSection(Section newSection){
		_sections.add(newSection);
	}

	/**
	 * Adds a paragraph to the paragraphs list.
	 *
	 * @param newParagraph The new Paragraph of the Section.
	 */
	public void addParagraph(Paragraph newParagraph){
		_paragraphs.add(newParagraph);
	}

	/**
	 * Adds a sub section to the sub sections list at the specified index.
	 *
	 * @param index The index where the new subSection is to be placed.
	 * @param title The new sub section's title.
	 */
	public void insertSection(int index, String title){
		Section s = new Section(title);
		try{ _sections.add(index, s); }
		catch(IndexOutOfBoundsException e){ _sections.add(s); }
	}

	/**
	 * Adds a paragraph to the paragraphs list at the specified index.
	 *
	 * @param index The index where the new paragraph is to be placed.
	 * @param content The new paragraph's content
	 */
	public void insertParagraph(int index, String content){
		Paragraph p = new Paragraph(content);
		try{ _paragraphs.add(index, p); }
		catch(IndexOutOfBoundsException e){ _paragraphs.add(p); }
	}

	/**
	 * @param index The index of the sub section to be selected.
	 * @return the Section's sub section with the given index.
	 * @throws NoSuchSectionException
	 */
	public Section selectSection(int index) throws NoSuchSectionException{
		try {
			return _sections.get(index);
		} catch (IndexOutOfBoundsException e) {
			throw new NoSuchSectionException();
		}
	}

	/**
	 * @param index The index of the paragraph to be selected.
	 * @return the Section's paragraph with the given index.
	 * @throws NoSuchParagraphException
	 */
	public Paragraph selectParagraph(int index) throws NoSuchParagraphException{
		try {
			return _paragraphs.get(index);
		} catch (IndexOutOfBoundsException e) {
			throw new NoSuchParagraphException();
		}
	}

	/**
	 * @param index The local index of the section to be removed.
	 * @throws NoSuchSectionException
     */
	public void removeSection(int index) throws NoSuchSectionException{
		try{
			_sections.remove(index);
		} catch(IndexOutOfBoundsException e){
			throw new NoSuchSectionException();
		}
	}

	/**
	 * @param index The index of the paragraph to be removed.
	 * @throws NoSuchParagraphException
	 */
	public void removeParagraph(int index) throws NoSuchParagraphException{
		try{
			_paragraphs.remove(index);
		}catch (IndexOutOfBoundsException e){
			throw new NoSuchParagraphException();
		}
	}

	/**
	 * @param index The index of the paragraph to be edited.
	 * @param newText The new text content of the selected paragraph.
	 * @throws NoSuchParagraphException
	 */
	public void editParagraph(int index, String newText) throws NoSuchParagraphException{
		selectParagraph(index).setContent(newText);
	}

	/** @return list with all the Section's elements (including itself) that have a unique identifier. */
	public List<TextElement> getUniqueMembers(){
		List<TextElement> identifiable = new ArrayList<>();
		if(hasID()) identifiable.add(this);
		for(Paragraph p : getParagraphs())
			if(p.hasID())
				identifiable.add(p);
		for(Section s : getSections()){
			identifiable.addAll(s.getUniqueMembers());
			if(s.hasID())
				identifiable.add(s);
		}
		return identifiable;
	}

	/** 
	 * @param visitor The visitor to which all of the content information is passed to.
	 */
	@Override
	public void showContent(TextElementVisitor visitor){
		visitor.visitSectionContent(this);
	}

	/**
	 * @param visitor The visitor to which all of the sub sections information is passed to.
	 */
	public void showAllSections(TextElementVisitor visitor){
		visitor.visitAllSections(this);
	}

	/**
	 * @param visitor The visitor to which only the top sub sections information is passed to.
	 */
	public void showTopSections(TextElementVisitor visitor){
		visitor.visitTopSections(this);
	}

	/**
	 * @param visitor The visitor to which the title and ID of the section information is passed to.
	 */
	public void showSectionInfo(TextElementVisitor visitor){
		visitor.visitSection(this);
	}

	/** @return the size of the Section's paragraphs and subSections. */
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