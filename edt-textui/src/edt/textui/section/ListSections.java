/** @version $Id: ListSections.java,v 1.7 2015/11/28 16:53:19 ist181500 Exp $ */
package edt.textui.section;

import ist.po.ui.DialogException;

import java.io.IOException;

import edt.textui.CoreVisitor;
import edt.Section;

/**
 * §2.2.2.
 */
public class ListSections extends SectionCommand {
	public ListSections(Section receiver) {
		super(MenuEntry.LIST_SECTIONS, receiver);
	}

	/**
	* Lista todas as sub-seccoes da secçao
	*/
	@Override
	public final void execute() throws DialogException, IOException {
		_receiver.showAllSections(new CoreVisitor());
	}
}
