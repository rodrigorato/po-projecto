package edt;

import java.io.Serializable;

public abstract class TextElement implements Serializable, Comparable<TextElement>{
	/** The TextElement's unique ID. */
	private String _uniqueID = "";
	
	/** @return the TextElement's ID. */
	public String getID(){ return _uniqueID;}

	/** @param uniqueID The TextElement's new ID. */
	public void setID(String uniqueID){ _uniqueID = uniqueID;}

	/** @return true if the TextElement has a uniqueID. */
	public boolean hasID(){ return !getID().equals("");}

	/** @param visitor The visitor to which the TextElement's complete content is passed to. */
	public abstract void showContent(TextElementVisitor visitor);

	/** @return the length of the TextElement's text content. */
	public abstract int getSize();
	
	/**
	 * @param otherTextElement The TextElement to be compared to the current TextElement.
	 * @return the comparation value.
	 */
	@Override
	public int compareTo(TextElement otherTextElement){
		return getID().compareTo(otherTextElement.getID());
	}
}
