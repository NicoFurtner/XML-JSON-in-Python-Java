import xml.etree.ElementTree as ET
import json

# XML-Datei einlesen
tree = ET.parse('book_store.xml')  # Hier wird die XML-Datei geladen
root = tree.getroot()  # Wurzelelement des XML-Dokuments holen (<bookstore>)


# XML-Daten in ein Dictionary konvertieren
def bookstore_xml_dic(root):
    bookstore = {"bookstore": []}  # Start mit einem leeren 'bookstore' Array

    # Iteriere durch die Kategorien von Büchern
    for category in root.findall('book'):
        # Für jedes Buch im XML, erstelle ein Dictionary
        book_data = {
            "category": category.get('category'),
            "title": category.find('title').text,
            "author": category.find('author').text,
            "year": category.find('year').text,
            "price": category.find('price').text
        }
        bookstore['bookstore'].append(book_data)  # Das Buch zur Liste hinzufügen

    return bookstore


# convert XML-Daten in Python-Dictionary
bookstore_data = bookstore_xml_dic(root)

# Speichern der Daten in einer JSON-Datei
with open('bookstore.json', 'w') as json_file:
    json.dump(bookstore_data, json_file, indent=4)


print(json.dumps(bookstore_data, indent=4))

print("JSON-Datei wurde erstellt!")
