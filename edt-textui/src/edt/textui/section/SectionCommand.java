/** @version $Id: SectionCommand.java,v 1.4 2015/11/28 16:44:40 ist181500 Exp $ */
package edt.textui.section;

import ist.po.ui.Command;

import edt.Section;
import edt.Document;

/**
 * Superclass of all section-context commands.
 */
public abstract class SectionCommand extends Command<Section> {
  	protected Document _document;

	public SectionCommand(String title, Section receiver){
		super(title, receiver);
	}

	public SectionCommand(String title, Section receiver, Document doc) {
		super(title, receiver);
		_document = doc;
	}
}
