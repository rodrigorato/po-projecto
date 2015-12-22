/** @version $Id: TextEditor.java,v 1.6 2015/11/13 18:32:27 ist181500 Exp $ */
package edt.textui;

import static ist.po.ui.Dialog.IO;

import java.io.IOException;

import edt.DocumentManager;
import edt.AuthorAlreadyExistsException;

/**
 * Class that starts the application's textual interface.
 */
public class TextEditor {
	public static void main(String[] args) {
		DocumentManager dm = new DocumentManager();
		String datafile = System.getProperty("import"); //$NON-NLS-1$
		if (datafile != null) {
			try{ dm.importDatafile(datafile); }
			catch(IOException e){ /* Handle the IOException caught from reading the import property */ }
			catch(AuthorAlreadyExistsException e){ /* Handle the AuthorAlreadyExistsException */ }
		}
		
		edt.textui.main.MenuBuilder.menuFor(dm);
		IO.closeDown();
	}
}
