/** @version $Id: NameSection.java,v 1.8 2015/11/29 18:21:13 ist181002 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.NoSuchSectionException;
import edt.Section;
import edt.Document;

/**
 * §2.2.6.
 */
public class NameSection extends SectionCommand {
    public NameSection(Section receiver, Document document){
        super(MenuEntry.NAME_SECTION, receiver, document);
    }

    @Override
    public final void execute() throws DialogException, IOException{
        int sectionId = IO.readInteger(Message.requestSectionId());
        try{
            String uniqueId = IO.readString(Message.requestUniqueId());
            if(_document.addUniqueElement(uniqueId, _receiver.selectSection(sectionId)))
                IO.println(Message.sectionNameChanged());

        }catch(NoSuchSectionException e){
            IO.println(Message.noSuchSection(sectionId));
        }
    }
}