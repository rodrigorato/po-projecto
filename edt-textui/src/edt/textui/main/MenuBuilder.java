/** @version $Id: MenuBuilder.java,v 1.6 2015/11/23 18:30:42 ist181002 Exp $ */
package edt.textui.main;

import ist.po.ui.Command;
import ist.po.ui.Menu;
import edt.DocumentManager;

public abstract class MenuBuilder {
  public static void menuFor(DocumentManager dm) {
    Menu menu = new Menu(MenuEntry.TITLE, new Command<?>[] {
            new New(dm),
            new Open(dm),
            new Save(dm),
            new ShowMetadata(dm),
            new AddAuthor(dm),
            new ShowIndex(dm),
            new ShowTextElement(dm),
            new Edit(dm)
    });
    menu.open();
  }
}
