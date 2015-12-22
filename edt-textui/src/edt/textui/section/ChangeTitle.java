/** @version $Id: ChangeTitle.java,v 1.3 2015/11/23 17:57:46 ist181500 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.Section;

/**
 * §2.2.1.
 */
public class ChangeTitle extends SectionCommand {
	public ChangeTitle(Section receiver) {
		super(MenuEntry.CHANGE_TITLE, receiver);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		_receiver.setTitle(IO.readString(Message.requestSectionTitle()));
	}
}
