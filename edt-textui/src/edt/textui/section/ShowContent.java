/** @version $Id: ShowContent.java,v 1.7 2015/11/29 18:21:13 ist181002 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.textui.CoreVisitor;
import edt.Section;
import edt.Paragraph;

/**
 * §2.2.3.
 */
public class ShowContent extends SectionCommand {
	public ShowContent(Section receiver) {
		super(MenuEntry.SHOW_CONTENT, receiver);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		_receiver.showContent(new CoreVisitor());
	}
}
