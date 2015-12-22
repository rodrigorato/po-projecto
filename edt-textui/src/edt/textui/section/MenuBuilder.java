/** @version $Id: MenuBuilder.java,v 1.5 2015/11/29 18:21:13 ist181002 Exp $ */
package edt.textui.section;

import ist.po.ui.Command;
import ist.po.ui.Menu;

import edt.Section;
import edt.Document;

public class MenuBuilder {
  public static void menuFor(Section receiver, Document document) {
    Menu menu = new Menu(MenuEntry.TITLE,
        new Command<?>[] {
            new ChangeTitle(receiver),
            new ListSections(receiver),
            new ShowContent(receiver),
            new SelectSection(receiver, document),
            new InsertSection(receiver),
            new NameSection(receiver, document),
            new RemoveSection(receiver, document),
            new InsertParagraph(receiver),
            new NameParagraph(receiver, document),
            new EditParagraph(receiver),
            new RemoveParagraph(receiver, document)
    });
    menu.open();
  }
}
