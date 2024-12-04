package org.example;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;

public class XMLToJSON{
    public static void main(String[] args) {
        try {
            // XML-Datei einlesen
            File inputFile = new File("book_store.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();  // Normalisieren der XML-Daten

            // JSON-Objekt und Array erstellen
            JSONObject bookstoreJson = new JSONObject();
            JSONArray booksArray = new JSONArray();

            // Alle Bücher durchgehen und konvertieren
            NodeList bookList = doc.getElementsByTagName("book");
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

                    // Buch in ein JSONObject konvertieren
                    JSONObject bookData = new JSONObject();
                    bookData.put("category", category);
                    bookData.put("title", title);
                    bookData.put("author", author);
                    bookData.put("year", year);
                    bookData.put("price", price);

                    // Buch zur Liste hinzufügen
                    booksArray.put(bookData);
                }
            }

            // JSON-Daten in das Haupt-JSONObject einfügen
            bookstoreJson.put("bookstore", booksArray);

            // JSON-Datei speichern
            FileWriter file = new FileWriter("bookstore.json");
            file.write(bookstoreJson.toString(4));  // Mit Einrückungen speichern
            file.close();

            System.out.println("JSON-Datei wurde erstellt!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
