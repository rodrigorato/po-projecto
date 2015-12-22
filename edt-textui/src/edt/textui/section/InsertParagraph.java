/** @version $Id: InsertParagraph.java,v 1.3 2015/11/28 16:44:40 ist181500 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.Section;

/**
 * §2.2.8.
 */
public class InsertParagraph extends SectionCommand {
	public InsertParagraph(Section receiver) {
		super(MenuEntry.INSERT_PARAGRAPH, receiver);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int paragraphId = IO.readInteger(Message.requestParagraphId());
		String paragraphText = IO.readString(Message.requestParagraphContent());
		_receiver.insertParagraph(paragraphId, paragraphText);
	}

}
