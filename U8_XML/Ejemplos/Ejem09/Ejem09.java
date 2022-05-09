package com.company.DOM.Ejemplos.Ejem09;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Ejem09 {
    public static void main(String[] args) {
        //Obtenemos la referencia al objeto Document
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder  db = null;

        try {
             db = dbf.newDocumentBuilder();

             // indicamos el archivo que queremos modificar - en este caso añadir nodo
            Document doc = db.parse(new File("personasXML.xml"));

            // 1. BORRAR EL PRIMER NODO

            // obtener el elemento padre
            Element root = doc.getDocumentElement();

            //borrarmo el primir nodo.
            root.removeChild(root.getElementsByTagName("pesona").item(0));


            // 2. AÑADIR UN NUEVO ELEMENTO

            //Obtenemos el nodo raíz
            Node root2 = doc.getDocumentElement();

            //Nodo texto de salto de línea que voy a utilizar posteriormente
            Text saltoLinea = doc.createTextNode("\n");

            //Creo la etiqueta padre persona, le doy nombre
            Element persona = doc.createElement("persona");
            persona.setAttribute("id","4");

            //Creo la etiqueta hija nombre y le doy valor
            Element nombre = doc.createElement("nombre");
            nombre.setTextContent("Chema Durán");

            //Creo la etiqueta hija edad y le doy valor
            Element edad = doc.createElement("edad");
            edad.setTextContent("50");

            //Construyo toda la estructura general de la etiqueta
            //persona.appendChild(saltoLinea);
            persona.appendChild(nombre);
            //persona.appendChild(saltoLinea);
            persona.appendChild(edad);
            //persona.appendChild(saltoLinea);

            //Añadimos ese nuevo nodo al root
            root.appendChild(persona);

        } catch (Exception e) {

        }
    }
}
