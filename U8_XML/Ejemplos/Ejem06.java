package com.company.DOM.Ejemplos;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/*
Calculo de la edad media mediante el recorrido de cada etiqueta. Haciendo una comparacion de
de los tipos de nodos.
 */
public class Ejem06 {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("persona.xml"));

            // obtenemos las lista de todos los nodos del documento.
            NodeList nl = doc.getDocumentElement().getChildNodes();
            int total =0;
            int contador=0;

            for (int i = 0; i < nl.getLength(); i++) {
                if (nl.item(i).getNodeType()== Node.ELEMENT_NODE){
                    NodeList ml2 = nl.item(i).getChildNodes();
                    for (int j = 0; j < ml2.getLength(); j++) {
                        if (ml2.item(j).getNodeType()==Node.ELEMENT_NODE){
                            Element nieto = (Element) ml2.item(j);
                            if (nieto.getTagName().equals("edad")) {
                                total += Integer.parseInt(nieto.getTextContent());
                                contador++;
                            }
                        }
                    }
                }
            }

            System.out.println("La media es: " +(total/contador));
        } catch (Exception e) {

        }
    }
}
