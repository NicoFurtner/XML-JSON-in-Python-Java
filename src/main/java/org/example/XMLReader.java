package org.example;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class XMLReader {
    public static void main(String[] args) {
        try {
            // XML-Datei einlesen
            File inputFile = new File("book_store.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Alle Bücher durchgehen und die Daten ausgeben
            System.out.println("Bookstore Daten:");
            System.out.println("-".repeat(40));

            // Durch alle Bücher im XML gehen
            NodeList bookList = doc.getElementsByTagName("book");
            int anzahl = 1;
            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;

                    // Buchdaten extrahieren
                    String category = bookElement.getAttribute("category");
                    String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                    String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                    String year = bookElement.getElementsByTagName("year").item(0).getTextContent();
                    String price = bookElement.getElementsByTagName("price").item(0).getTextContent();

                    // Ausgabe
                    System.out.println("Anzahl Buch: " + anzahl);
                    System.out.println("Category: " + category);
                    System.out.println("Title: " + title);
                    System.out.println("Author: " + author);
                    System.out.println("Year: " + year);
                    System.out.println("Price: $" + price);
                    System.out.println("-".repeat(30));

                    anzahl++;
                }
            }
            System.out.println("Ende des XMLs der Daten");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
