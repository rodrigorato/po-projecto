package edt;

public class Paragraph extends TextElement{
	/** The Paragraph's text content. */
	private String _content;
	
	/**
	 * Paragraph's constructor.
	 *
	 * @param text The Paragraph's text content.
	 */
	public Paragraph(String text){ _content = text;}
	
	/** @return the Paragraph's text content. */
	public String getContent(){ return _content;}
	
	/** @param text The Paragraph's new text content. */
	public void setContent(String text){ _content = text;}

	/** @param visitor The visitor to which the Paragraph's content is passed to. */
	@Override
	public void showContent(TextElementVisitor visitor){
		visitor.visitParagraph(this);
	}

	/** @return the length of the Paragraph's text content. */
	@Override
	public int getSize(){ return getContent().length();}
}
