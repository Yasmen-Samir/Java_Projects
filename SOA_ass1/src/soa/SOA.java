package soa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

public class SOA {

    public static ArrayList<Book> takeInput(int numOfBooks) {
        ArrayList<Book> Books = new ArrayList<Book>();
        Scanner input = new Scanner(System.in);
        Book book = new Book();
        double priced;
        String ID;
        String author;
        String title;
        String Genre;
        double price;
        String publish_date;
        String describtion;
        for (int i = 0; i < numOfBooks; i++) {
            ID = "BK" + (i + 1);
            System.out.println("Please enter book " + (i + 1) + " information");
            System.out.println("Book Author: ");
            author = input.nextLine();
            System.out.println("Book Title: ");
            title = input.nextLine();
            System.out.println("Book Genre: ");
            Genre = input.nextLine();
            System.out.println("Book Price: ");
            price = Double.parseDouble(input.nextLine());
            System.out.println("Book publish_date: ");
            publish_date = input.nextLine();
            System.out.println("Book describtion: ");
            describtion = input.nextLine();
            book = new Book(ID, author, title, Genre, price, publish_date, describtion);
            Books.add(book);
        }
        return Books;
    }

    ;
    public static void main(String[] args) throws ParserConfigurationException, IOException, FileNotFoundException, TransformerException, SAXException {

        Scanner input = new Scanner(System.in);
        ArrayList<Book> Books = new ArrayList<Book>();
        Book book = new Book();
        int numOfBooks;
        String n;
        String searchKey;

        while (true) {
            System.out.println("Choose:");
            System.out.println("1)Rewrite Xml folder with new Data ");
            System.out.println("2)Append New Data to Xml");
            System.out.println("3)Search by Title");
            System.out.println("4)Search by Author");
            System.out.println("5)Delete by ID");
            System.out.println("6)Close");
            n = input.nextLine();
            if (n.equals("1")) {
            System.out.println("Enter Num Of Books u want to add : ");
            numOfBooks = Integer.parseInt(input.nextLine());
            Books = takeInput(numOfBooks);
            book.writeXML(Books);
            }
            else if (n.equals("2")) {
            System.out.println("Enter Num Of Books u want to add : ");
            numOfBooks = Integer.parseInt(input.nextLine());
            Books = takeInput(numOfBooks);
            book.appendDatainXml(Books);
            }
            else if(n.equals("3")){
            System.out.println("Enter Title you want to search: ");
            searchKey=input.nextLine();
            System.out.println(book.nodeDeleteOrPrint(searchKey,2));
            }
            else if(n.equals("4")){
            System.out.println("Enter Author you want to search: ");
            searchKey=input.nextLine();
            System.out.println(book.nodeDeleteOrPrint(searchKey,1));
            }
            else if(n.equals("5")){
            System.out.println("Enter ID you want to Delete: ");
            searchKey=input.nextLine();
            System.out.println(book.nodeDeleteOrPrint(searchKey,0));
            
            
            }else if(n.equals("6")){
             break;
                  
            
            }else{
                System.out.println("Wrong Number!");
             }
            
        }

    }
}
