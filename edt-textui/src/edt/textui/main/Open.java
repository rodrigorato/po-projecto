/** @version $Id: Open.java,v 1.7 2015/11/29 18:21:13 ist181002 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.FileNotFoundException;
import java.io.IOException;

import edt.DocumentManager;

public class Open extends Command<DocumentManager> {
	public Open(DocumentManager receiver) {
		super(MenuEntry.OPEN, receiver);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		String filename = IO.readString(Message.openFile());
		try {
			_receiver.openDocument(filename);
			_receiver.setUnchanged();
		}
		catch(FileNotFoundException e){ IO.println(Message.fileNotFound(filename)); }
		catch(IOException e){ /* Handle the IOException caused by reading a file */ }
		catch(ClassNotFoundException e){ /* Handle the ClassNotFoundException caught by reading an object */ }
	}
}
