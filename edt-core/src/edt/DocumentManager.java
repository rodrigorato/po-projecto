package edt;

import java.util.List;
import java.util.LinkedList;
import java.io.*;

public class DocumentManager{
    /** The DocumentManager's current Document. */
    private Document _doc = new Document();

    /** The Document's State (True if the Document was changed). */
    private boolean _changed = false;

    /** The Document's pathname. */
    private String _pathName = "";

    /**  Creates a new Document with no pathname. */
    public void newDocument(){
        _pathName = "";
        _changed = false;
        _doc = new Document();
    }

    /** @return the document itself. */
    public Document getDocument(){ return _doc; }

    /** @param newPathName The Document's new pathname. */
    public void setPathName(String newPathName){ _pathName = newPathName;}

    /** Sets the document's status as unchanged. */
    public void setUnchanged(){ _changed = false; }

    /** Sets the document's status as changed. */
    public void setChanged(){ _changed = true; }

    /** @return true if we have no name associated to the current document, false otherwise. */
    public boolean anonymousDocument(){ return _pathName.equals("");}

    /** @return a list with information about the authors. */
    public List<String[]> getDocAuthors(){
        List<String[]> l = new LinkedList<>();
        for(Author a : _doc.getAuthors()){
            String[] s = {a.getName(), a.getEmail()}; 
            l.add(s); 
        }
        return l;
    }

    /** 
     * @param name The new author's name.
     * @param email The new author's email.
     * @throws AuthorAlreadyExistsException
     * */
    public void addAuthorToDoc(String name, String email) throws AuthorAlreadyExistsException{
        Author author = new Author(name, email);
        getDocument().addAuthor(author);
    }

    /**
     * @param pathname The pathname of the Document to be opened.
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void openDocument(String pathname) throws FileNotFoundException, ClassNotFoundException, IOException{
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(pathname)));
        _doc = (Document)ois.readObject();
        setPathName(pathname);
        ois.close();
    }

    /**
     * Saves the current document on disk. 
     * @throws IOException
     */
    public void saveDocument() throws IOException{
        if(_changed) {
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(_pathName)));
            oos.writeObject(_doc);
            oos.close();
        }
    }

    /**
     * Interprets the string it gets as an argument
     * and sets it as the current document, provided that
     * it is in the right format.
     * If the string isn't in the right format
     * unexpected behaviour may occur.
     *f
     * @param datafile will be interpreted and set as the current document.
     * @throws AuthorAlreadyExistsException
     * @throws IOException
     */
    public void importDatafile(String datafile) throws IOException, AuthorAlreadyExistsException {
        BufferedReader br = new BufferedReader(new FileReader(datafile));
        Document newDoc = new Document();
        String fieldSplitter = "\\|"; /* Used to split the fields in the imported file */
        String s;
        String[] fields;
        Section temp_sec = null;

        /* Sets the document's title, its the first line in the imported file */
        newDoc.setTitle(br.readLine());

        /* For each field separated by '|' in the second line there is an author to add */
        for (String author : br.readLine().split(fieldSplitter)) {
            String[] author_fields = author.split("/");
            newDoc.addAuthor(new Author(author_fields[0], author_fields[1]));
        }

        while ((s = br.readLine()) != null) {
            fields = s.split(fieldSplitter);
            if (fields[0].equals("SECTION")) {
                temp_sec = new Section(fields[2]);
                newDoc.addUniqueElement(fields[1], temp_sec);
                newDoc.addSection(temp_sec);
            }

            if (fields[0].equals("PARAGRAPH")) {
                if (temp_sec == null)
                    newDoc.addParagraph(new Paragraph(fields[1]));
                else {
                    temp_sec.addParagraph(new Paragraph(fields[1]));
                }
            }
        }
        /* Sets the current document in DocumentManager to the one built by what we just interpreted */
        _doc = newDoc;
        setChanged(); /* we want to save this */
    }
}
