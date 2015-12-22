package edt;

public interface TextElementVisitor {
    public void visitDocument(Document doc);
    public void visitSection(Section sec);
    public void visitParagraph(Paragraph par);
    public void visitTopSections(Section sec);
    public void visitAllSections(Section sec);
    public void visitSectionContent(Section sec);
}
