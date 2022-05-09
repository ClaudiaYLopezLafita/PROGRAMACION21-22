package com.company.DOM.Ejemplos;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/*
calculo de edad media: para eso deberemos de acceder al elemento EDAD, obtener su contenido y hacer los calculos
para posteriormente mostrar el sultado por pantalla.
 */
public class Ejem05 {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("alumnos.xml"));

            NodeList nl = doc.getElementsByTagName("edad");
            int total=0;
            for (int i = 0; i < nl.getLength(); i++) {
                total+=Integer.parseInt(nl.item(i).getTextContent());
            }

            System.out.println("La media de las edad: "+(total/nl.getLength()));

        }  catch (Exception e) {

        }
    }
}
