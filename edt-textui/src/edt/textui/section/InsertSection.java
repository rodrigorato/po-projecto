/** @version $Id: InsertSection.java,v 1.4 2015/11/29 18:21:13 ist181002 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.Section;

/**
 * §2.2.5.
 */
public class InsertSection extends SectionCommand {
  public InsertSection(Section receiver) {
    super(MenuEntry.INSERT_SECTION, receiver);
  }

  @Override
  public final void execute() throws DialogException, IOException {
      int sectionId = IO.readInteger(Message.requestSectionId());
      String sectionTitle = IO.readString(Message.requestSectionTitle());
      _receiver.insertSection(sectionId, sectionTitle);
  }
}
