/** @version $Id: New.java,v 1.7 2015/11/29 18:21:13 ist181002 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.DocumentManager;

public class New extends Command<DocumentManager> {
	public New(DocumentManager receiver) {
		super(MenuEntry.NEW, receiver);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		_receiver.newDocument();
		_receiver.setChanged();
	}
}
