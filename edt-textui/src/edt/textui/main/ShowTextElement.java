/** @version $Id: ShowTextElement.java,v 1.13 2015/11/29 18:21:13 ist181002 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;

import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.textui.CoreVisitor;
import edt.DocumentManager;
import edt.NoSuchTextElementException;

public class ShowTextElement extends Command<DocumentManager> {
   public ShowTextElement(DocumentManager receiver) {
    super(MenuEntry.SHOW_TEXT_ELEMENT, receiver);
  }

    @Override
    public final void execute() throws DialogException, IOException {
        String id = IO.readString(Message.requestElementId());
        try{
            _receiver.getDocument().getUniqueTextElement(id).showContent(new CoreVisitor());
        }catch(NoSuchTextElementException e){
            IO.println(Message.noSuchTextElement(id));
        }
    }
}
