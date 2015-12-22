/** @version $Id: SelectSection.java,v 1.4 2015/11/23 17:57:46 ist181500 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.Section;
import edt.Document;
import edt.NoSuchSectionException;

/**
 * §2.2.4.
 */
public class SelectSection extends SectionCommand {
	public SelectSection(Section receiver, Document document) {
		super(MenuEntry.SELECT_SECTION, receiver, document);

	}

	@Override
	public final void execute() throws DialogException, IOException  {
		int sectionId = IO.readInteger(Message.requestSectionId());
		Section selectedSection = null;

		try{
			selectedSection = _receiver.selectSection(sectionId);
			IO.println(Message.newActiveSection(sectionId));
		}
		catch(NoSuchSectionException e) {
			IO.println(Message.noSuchSection(sectionId));
		}

		if(selectedSection != null)
			edt.textui.section.MenuBuilder.menuFor(selectedSection, _document);
	}
}
