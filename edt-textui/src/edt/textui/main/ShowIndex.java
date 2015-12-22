/** @version $Id: ShowIndex.java,v 1.14 2015/11/29 18:21:13 ist181002 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;


import edt.textui.CoreVisitor;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.DocumentManager;

public class ShowIndex extends Command<DocumentManager> {
	public ShowIndex(DocumentManager receiver) {
		super(MenuEntry.SHOW_INDEX, receiver);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		CoreVisitor vis = new CoreVisitor();
		_receiver.getDocument().showSectionInfo(vis);
		_receiver.getDocument().showTopSections(vis);
	}
}