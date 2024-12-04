import xml.etree.ElementTree as ET

# XML-Datei einlesen
tree = ET.parse('book_store.xml')  # XML Datei einlesen
root = tree.getroot()  # Wurzelelement des XML Files holen (<bookstore>)

# Alle Bücher durchgehen und deren Daten ausgeben
print("Bookstore Daten:")
print("-" * 40)
