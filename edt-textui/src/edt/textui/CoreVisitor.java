package edt.textui;

import ist.po.ui.DialogException;
import static ist.po.ui.Dialog.IO;
import java.io.IOException;
import edt.textui.section.Message;

import edt.TextElementVisitor;
import edt.Paragraph;
import edt.Section;
import edt.Document;


public class CoreVisitor implements TextElementVisitor {
    public void visitDocument(Document doc){
        IO.println("{" + doc.getTitle() + "}");
    }

    public void visitSection(Section sec){
        IO.println(Message.sectionIndexEntry(sec.getID(), sec.getTitle()));
    }

    public void visitParagraph(Paragraph par){
        IO.println(par.getContent());
    }


    public void visitTopSections(Section sec){
        for(Section sub : sec.getSections())
            visitSection(sub);
    }

    public void visitAllSections(Section sec){
        for(Section sub : sec.getSections()) {
            visitSection(sub);
            visitAllSections(sub);
        }
    }

    public void visitSectionContent(Section sec){
        sec.showSectionInfo(this);
        for(Paragraph par : sec.getParagraphs())
            visitParagraph(par);
        for(Section sub : sec.getSections())
            visitSectionContent(sub);
    }
}
