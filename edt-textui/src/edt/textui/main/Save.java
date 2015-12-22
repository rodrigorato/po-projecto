/** @version $Id: Save.java,v 1.9 2015/11/29 18:21:13 ist181002 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.DocumentManager;

public class Save extends Command<DocumentManager> {
	public Save(DocumentManager receiver) {
		super(MenuEntry.SAVE, receiver);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		if(_receiver.anonymousDocument())
			_receiver.setPathName(IO.readString(Message.newSaveAs()));
		try{
			_receiver.saveDocument();
			_receiver.setUnchanged();
		}
		catch(IOException e){ /* Handle the IOException caused by writing the document to disk. */ }
	}
}
