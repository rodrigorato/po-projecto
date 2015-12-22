/** @version $Id: RemoveSection.java,v 1.8 2015/11/29 18:21:13 ist181002 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.util.List;
import java.io.IOException;

import edt.Section;
import edt.Document;
import edt.NoSuchSectionException;
import edt.TextElement;

/**
 * §2.2.7.
 */
public class RemoveSection extends SectionCommand {
    public RemoveSection(Section receiver, Document document) {
        super(MenuEntry.REMOVE_SECTION, receiver, document);
    }

    @Override
    public final void execute() throws DialogException, IOException {
        int sectionId = IO.readInteger(Message.requestSectionId());
        try{
            Section toRemove = _receiver.selectSection(sectionId);
            List<TextElement> _identifiable = toRemove.getUniqueMembers();
            _document.removeUniqueElements(_identifiable);
            _receiver.removeSection(sectionId);
        } catch(NoSuchSectionException e){
            IO.println(Message.noSuchSection(sectionId));
        }
    }
}
