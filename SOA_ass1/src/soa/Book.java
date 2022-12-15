package soa;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Book {

    String ID;
    String author;
    String title;
    String Genre;
    double price;
    String publish_date;
    String describtion;

    public Book() {

    }

    public Book(String ID, String author, String title, String Genre, double price, String publish_date, String describtion) {
        this.ID = ID;
        this.author = author;
        this.Genre = Genre;
        this.describtion = describtion;
        this.price = price;
        this.publish_date = publish_date;
        this.title = title;
    }

    @Override
    public String toString() {
        return ("Book id: " + this.ID + "\n"
                + "Book author: " + this.author + "\n"
                + "title: " + this.title + "\n"
                + "Genre: " + this.Genre + "\n"
                + "price: " + this.price + "\n"
                + "publish_date: " + this.publish_date + "\n"
                + "Description: " + this.describtion);
    }

    public Document parseDocument() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("output.xml"));
        return document;

    }

    public String getLastID() throws ParserConfigurationException, SAXException, IOException {

        Document document = parseDocument();

        NodeList nodeList = document.getElementsByTagName("Book");
        Node lastBook = nodeList.item(nodeList.getLength() - 1);
        String ID = lastBook.getAttributes().getNamedItem("ID").getNodeValue();

        return ID;
    }

    public void writeXML(ArrayList<Book> books) throws ParserConfigurationException, FileNotFoundException, IOException, TransformerException {
        DocumentBuilderFactory doc = DocumentBuilderFactory.newNSInstance();
        DocumentBuilder builder = doc.newDocumentBuilder();

        //build xml document
        Document xmlDoc = builder.newDocument();

        Element root = xmlDoc.createElement("Catalogue");

        for (int i = 0; i < books.size(); i++) {
            Element Book = xmlDoc.createElement("Book");
            Book.setAttribute("ID", books.get(i).ID);

            Element Author = xmlDoc.createElement("Author");
            Text AuthorText = xmlDoc.createTextNode(books.get(i).author);
            Author.appendChild(AuthorText);

            Book.appendChild(Author);

            Element Title = xmlDoc.createElement("Title");
            Text TitleText = xmlDoc.createTextNode(books.get(i).title);
            Title.appendChild(TitleText);

            Book.appendChild(Title);

            Element genre = xmlDoc.createElement("Genre");
            Text GenreText = xmlDoc.createTextNode(books.get(i).Genre);
            genre.appendChild(GenreText);

            Book.appendChild(genre);

            Element Pricee = xmlDoc.createElement("Price");
            Text priceText = xmlDoc.createTextNode(String.valueOf(books.get(i).price));
            Pricee.appendChild(priceText);

            Book.appendChild(Pricee);

            Element date = xmlDoc.createElement("Publish_Date");
            Text dateText = xmlDoc.createTextNode(books.get(i).publish_date);
            date.appendChild(dateText);

            Book.appendChild(date);

            Element desc = xmlDoc.createElement("Description");
            Text descText = xmlDoc.createTextNode(books.get(i).describtion);
            desc.appendChild(descText);

            Book.appendChild(desc);

            root.appendChild(Book);
        }
        xmlDoc.appendChild(root);

        printToXml(xmlDoc);

        printToConsole(xmlDoc);
    }

    public void appendDatainXml(ArrayList<Book> books) throws ParserConfigurationException, TransformerException, SAXException, IOException {
        Document doc;
        String ID;
        String lastID = getLastID();
        String[] part = lastID.split("(?<=\\D)(?=\\d)");
        int lastid = Integer.parseInt(part[1]);
        try {
            doc = parseDocument();

            Element catalogue = doc.getDocumentElement();
            for (int i = 0; i < books.size(); i++) {
                 ID = "BK" + (lastid+(i + 1));
                Element newBook = doc.createElement("Book");
                newBook.setAttribute("ID", ID);
                Element author = doc.createElement("Author");
                author.setTextContent(books.get(i).author);
                Element title = doc.createElement("Title");
                title.setTextContent(books.get(i).title);
                Element genre = doc.createElement("Genre");
                genre.setTextContent(books.get(i).Genre);
                Element price = doc.createElement("Price");
                price.setTextContent(String.valueOf(books.get(i).price));
                Element publishDate = doc.createElement("Publish_Date");
                publishDate.setTextContent(books.get(i).publish_date);
                Element description = doc.createElement("Description");
                description.setTextContent(books.get(i).describtion);
                newBook.appendChild(author);
                newBook.appendChild(title);
                newBook.appendChild(genre);
                newBook.appendChild(price);
                newBook.appendChild(publishDate);
                newBook.appendChild(description);
                catalogue.appendChild(newBook);

            }           
            printToXml(doc);
        } catch (SAXException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //n refer to
    // if equal=0 delete with id
    //if Equal=1 search with author
    //if Equal=2 search with Title
    public String nodeDeleteOrPrint(String searchKey, int n) throws ParserConfigurationException, IOException, TransformerException {

        try {
            Book book;
            Document document = parseDocument();
            Node nod = null;
            NodeList nodeList = document.getDocumentElement().getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    String ID = node.getAttributes().getNamedItem("ID").getNodeValue();
                    String author = elem.getElementsByTagName("Author")
                            .item(0).getChildNodes().item(0).getNodeValue();
                    String title = elem.getElementsByTagName("Title").item(0)
                            .getChildNodes().item(0).getNodeValue();
                    String genre = elem.getElementsByTagName("Genre")
                            .item(0).getChildNodes().item(0).getNodeValue();
                    Double price = Double.parseDouble(elem.getElementsByTagName("Price")
                            .item(0).getChildNodes().item(0).getNodeValue());
                    String publishDate = elem.getElementsByTagName("Publish_Date")
                            .item(0).getChildNodes().item(0).getNodeValue();
                    String descri = elem.getElementsByTagName("Description")
                            .item(0).getChildNodes().item(0).getNodeValue();

                    if (n == 0 && ID.equals(searchKey)) {
                        nod=node;
                        document.getDocumentElement().removeChild(nod);
                        printToXml(document);
                        return "Book deleted successfully";

                    } else if (n == 1 && author.equals(searchKey)) {
                        book = new Book(ID, author, title, genre, price, publishDate, descri);
                        return book.toString();
                    } else if (n == 2 && title.equals(searchKey)) {
                        book = new Book(ID, author, title, genre, price, publishDate, descri);
                        return book.toString();
                    }

                }

            }
           
        } catch (SAXException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "not found";
    }

    // print to xml by calling outputXml
    public void printToConsole(Document document) throws TransformerException {
        outputXML(document, System.out);
    }

    public void printToXml(Document document) throws TransformerException {
        try (FileOutputStream output = new FileOutputStream("output.xml")) {
            outputXML(document, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void outputXML(Document doc, OutputStream output) throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // pretty print
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);

    }

}
