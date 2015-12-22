/** @version $Id: Edit.java,v 1.9 2015/11/29 18:21:13 ist181002 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.DocumentManager;

public class Edit extends Command<DocumentManager> {
  public Edit(DocumentManager receiver) {
    super(MenuEntry.OPEN_DOCUMENT_EDITOR, receiver);
  }

  @Override
  public final void execute() throws DialogException, IOException {
      _receiver.setChanged();
      edt.textui.section.MenuBuilder.menuFor(_receiver.getDocument(), _receiver.getDocument());
  }
}
