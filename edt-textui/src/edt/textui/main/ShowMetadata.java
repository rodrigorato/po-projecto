/** @version $Id: ShowMetadata.java,v 1.9 2015/11/28 16:44:40 ist181500 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;

import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.DocumentManager;

/**
 * Apresenta MetaInformacao sobre o documento.
 */
public class ShowMetadata extends Command<DocumentManager> {
	public ShowMetadata(DocumentManager receiver) {
		super(MenuEntry.SHOW_METADATA, receiver);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		IO.println(Message.documentTitle(_receiver.getDocument().getTitle()));
		for(String[] s : _receiver.getDocAuthors())
			IO.println(Message.author(s[0], s[1]));
		IO.println(Message.documentSections(_receiver.getDocument().getNumberOfSections()));
		IO.println(Message.documentBytes(_receiver.getDocument().getSize()));
		IO.println(Message.documentIdentifiers(_receiver.getDocument().getNumberOfUniqueIDs()));
	}
}
