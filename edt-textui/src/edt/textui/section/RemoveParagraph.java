/** @version $Id: RemoveParagraph.java,v 1.7 2015/11/29 18:21:13 ist181002 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.NoSuchParagraphException;
import edt.Section;
import edt.Document;

/**
 * §2.2.11.
 */
public class RemoveParagraph extends SectionCommand {
	public RemoveParagraph(Section receiver, Document document) {
		super(MenuEntry.REMOVE_PARAGRAPH, receiver, document);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int parId = IO.readInteger(Message.requestParagraphId());
		try{
			if(_receiver.selectParagraph(parId).hasID()){
				_document.removeUniqueElement(_receiver.selectParagraph(parId));
			}
			_receiver.removeParagraph(parId);

		}catch(NoSuchParagraphException e){
			IO.println(Message.noSuchParagraph(parId));
		}
	}
}
