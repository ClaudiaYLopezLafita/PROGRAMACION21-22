package com.company.DOM.Ejemplos;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/*
Obtener todos los contenidos del documento xml.
Se puede observar los saltos de leina dejado por las tabulacione sy las etiquetas.
 */

public class Ejem01 {
    public static void main(String[] args) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        String s="";
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("alumnos.xml"));

            // Obtener el elemento raiz
            Element root = doc.getDocumentElement();

            // hijos
            System.out.println("Nodos hijos del documento: "
            +doc.getChildNodes().getLength());

            for (int i = 0; i < doc.getChildNodes().getLength(); i++) {
                String content = root.getTextContent();
                System.out.println(content);
            }

        }  catch (Exception e) {

        }
    }
}
