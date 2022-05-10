package com.company.DOM.Ejemplos;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Ejem03 {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        String s="";
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("alumnos.xml"));

            // Obtener el elemento raiz
            Element root = doc.getDocumentElement();
            NodeList nl = doc.getElementsByTagName("alumno");


            // hijos
            System.out.println("Nodos hijos del documento: "
                    +doc.getChildNodes().getLength());
            System.out.println("Nodos del nodo raiz del documento: "
                    +root.getChildNodes().getLength());

            for (int i = 0; i < nl.getLength() ; i++) {
                System.out.println("Tipo del Nodo:"+nl.item(i).getNodeType());
                System.out.println("Contenido del Nodo:"+nl.item(i).getTextContent());
                System.out.println("-------------------------------------------------");
            }

        }  catch (Exception e) {

        }
    }
}
