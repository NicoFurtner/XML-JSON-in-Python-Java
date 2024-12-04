import xml.etree.ElementTree as ET

# XML-Datei einlesen
tree = ET.parse('book_store.xml')  # XML Datei einlesen
root = tree.getroot()  # Wurzelelement des XML Files holen (<bookstore>)

# Alle Bücher durchgehen und die Daten ausgeben
print("Bookstore Daten:")
print("-" * 40)

anzahl = 1

# for-Schleife durch alle Bücher im XML
for book in root.findall('.//book'):
        category = book.attrib['category']  # Kategorie
        title = book.find('title').text    # Titel
        author = book.find('author').text  # Autor
        year = book.find('year').text      # Jahr
        price = book.find('price').text    # Preis

        # Ausgabe
        print(f"Anzahl Buch: "+ str(anzahl))
        print(f"Category: {category}")
        print(f"Title: {title}")
        print(f"Author: {author}")
        print(f"Year: {year}")
        print(f"Price: ${price}")
        print("-" * 30)

        anzahl += 1

print("Ende des XMLs der Daten")
