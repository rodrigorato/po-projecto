/** @version $Id: AddAuthor.java,v 1.8 2015/11/29 18:21:13 ist181002 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;

import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.DocumentManager;
import edt.AuthorAlreadyExistsException;

public class AddAuthor extends Command<DocumentManager> {
	public AddAuthor(DocumentManager receiver) {
		super(MenuEntry.ADD_AUTHOR, receiver);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		String name = IO.readString(Message.requestAuthorName());
		String email = IO.readString(Message.requestEmail());

		try{
			_receiver.addAuthorToDoc(name, email);
			_receiver.setChanged();
		}
	  	catch(AuthorAlreadyExistsException e){
			IO.println(Message.duplicateAuthor(name));
		}
	}
}
