/** @version $Id: EditParagraph.java,v 1.3 2015/11/26 23:16:15 ist181002 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.Section;
import edt.NoSuchParagraphException;

/**
 * §2.2.10.
 */
public class EditParagraph extends SectionCommand {
	public EditParagraph(Section receiver) {
		super(MenuEntry.EDIT_PARAGRAPH, receiver);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int paragraphId = IO.readInteger(Message.requestParagraphId());
		try{
			_receiver.editParagraph(paragraphId, IO.readString(Message.requestParagraphContent()));
		}catch(NoSuchParagraphException e){
			IO.println(Message.noSuchParagraph(paragraphId));
		}
	}

}
