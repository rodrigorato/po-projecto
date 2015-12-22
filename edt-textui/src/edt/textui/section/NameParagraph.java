/** @version $Id: NameParagraph.java,v 1.7 2015/11/29 18:21:13 ist181002 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.Section;
import edt.Document;
import edt.NoSuchParagraphException;

/**
 * §2.2.9.
 */
public class NameParagraph extends SectionCommand {
    public NameParagraph(Section receiver, Document document){
        super(MenuEntry.NAME_PARAGRAPH, receiver, document);
    }
    @Override
    public final void execute() throws DialogException, IOException {
        int parId = IO.readInteger(Message.requestParagraphId());
        try{
            String uniqueId = IO.readString(Message.requestUniqueId());
            if(_document.addUniqueElement(uniqueId, _receiver.selectParagraph(parId)))
                IO.println(Message.paragraphNameChanged());

        }catch(NoSuchParagraphException e){
                IO.println(Message.noSuchParagraph(parId));
        }
    }
}
